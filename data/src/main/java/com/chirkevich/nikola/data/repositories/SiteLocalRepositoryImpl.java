package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDataSource;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

public class SiteLocalRepositoryImpl implements SiteLocalRepository {

    private SiteItemDataSource siteItemDataSource;
    private Scheduler scheduler;

    public SiteLocalRepositoryImpl(SiteItemDataSource siteItemDataSource, Scheduler scheduler) {
        this.siteItemDataSource = siteItemDataSource;
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
}
