package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.internet.model.sites.SitesResponse;
import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDataSource;
import com.chirkevich.nikola.data.mappers.sites.SitesMapper;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.repositories.AppPreferencesRepository;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;

import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class SiteLocalRepositoryImpl implements SiteLocalRepository {


    private SitesMapper sitesMapper = Mappers.getMapper(SitesMapper.class);

    private SiteItemDataSource siteItemDataSource;
    private StackOverFlowService stackOverFlowService;
    private AppPreferencesRepository appPreferencesRepository;
    private Scheduler scheduler;

    public SiteLocalRepositoryImpl(SiteItemDataSource siteItemDataSource,
                                   StackOverFlowService stackOverFlowService,
                                   AppPreferencesRepository appPreferencesRepository,
                                   Scheduler scheduler) {
        this.siteItemDataSource = siteItemDataSource;
        this.stackOverFlowService = stackOverFlowService;
        this.appPreferencesRepository = appPreferencesRepository;
        this.scheduler = scheduler;
    }


    @Override
    public Completable deleteAllSites() {
        return Completable.fromRunnable(() -> siteItemDataSource.deleteAllSites())
                .subscribeOn(scheduler);
    }

    @Override
    public Completable saveSite(Sites sites) {
        return Completable.fromRunnable(() -> siteItemDataSource.saveSites(sites.getItems()))
                .subscribeOn(scheduler);
    }

    @Override
    public Single<List<SiteItem>> getSites() {
        return Single.fromCallable(() -> siteItemDataSource.getSites())
                .subscribeOn(scheduler);
    }


    @Override
    public Single<List<SiteItem>> getSites(int offset, int size, String filter) {
        return Single.<List<SiteItem>>create(emitter -> {
            Integer pageSize = appPreferencesRepository.pageSize();
            List<SiteItem> siteItems = siteItemDataSource.getSites(offset, size, filter);
            List<SiteItem> result = new ArrayList<>();
            boolean hasMore = appPreferencesRepository.isHasMoreSitePages();
            if (siteItems.size() < size && hasMore) {
                boolean needLoadMore = true;

                while (needLoadMore && hasMore) {
                    Integer loadedPage = appPreferencesRepository.getLastLoadedSitesPage();
                    SitesResponse sitesResponse = stackOverFlowService.getSites(loadedPage, pageSize).blockingGet();
                    Sites sites = sitesMapper.toSites(sitesResponse);
                    hasMore = sites.getHasMore();
                    appPreferencesRepository.setLastLoadedSitesPage(++loadedPage);
                    appPreferencesRepository.setIsHasMoreSitePages(hasMore);
                    siteItemDataSource.saveSites(sites.getItems());
                    result.addAll(siteItemDataSource.getSites(offset, size, filter));
                    needLoadMore = result.size() < size;
                }
                emitter.onSuccess(result);
            } else emitter.onSuccess(siteItems);
        }).subscribeOn(scheduler);
    }

}
