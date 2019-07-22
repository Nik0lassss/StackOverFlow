package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.repositories.AppPreferencesRepository;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class SitePageInteractorImpl implements SitePageInteractor {


    private SitesRemoteRepository sitesRemoteRepository;
    private SiteLocalRepository siteLocalRepository;
    private AppPreferencesRepository appPreferencesRepository;


    public SitePageInteractorImpl(SitesRemoteRepository sitesRemoteRepository,
                                  SiteLocalRepository siteLocalRepository,
                                  AppPreferencesRepository appPreferencesRepository) {
        this.sitesRemoteRepository = sitesRemoteRepository;
        this.siteLocalRepository = siteLocalRepository;
        this.appPreferencesRepository = appPreferencesRepository;
    }

    @Override
    public Single<List<SiteItem>> getSites(Integer page, Integer pageSize) {
        return Single.never();
    }

    @Override
    public Completable loadSites(Integer page, Integer pageSize) {
//        return sitesRemoteRepository.getSites(page, pageSize)
//                .flatMapCompletable(siteLocalRepository::saveSite)
//                .map(sites -> {
//                    appPreferencesRepository.setLastLoadedSitesPage(page)
//                            .andThen(appPreferencesRepository.setIsHasMoreSitePages(sites.getHasMore()))
//                            .subscribe();
//                });
        return Completable.complete();
    }


}
