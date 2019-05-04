package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.local.database.dao.site.SiteDataSource;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

public class SiteLocalRepositoryImpl implements SiteLocalRepository {

    private SiteDataSource siteDataSource;
    private Scheduler scheduler;

    public SiteLocalRepositoryImpl(SiteDataSource siteDataSource, Scheduler scheduler) {
        this.siteDataSource = siteDataSource;
        this.scheduler = scheduler;
    }

    @Override
    public Completable saveSite(Sites sites) {
        return siteDataSource.saveSite(sites)
                .subscribeOn(scheduler);
    }

    @Override
    public Single<List<Sites>> getSites() {
        return siteDataSource.getSites()
                .observeOn(scheduler);
    }


}
