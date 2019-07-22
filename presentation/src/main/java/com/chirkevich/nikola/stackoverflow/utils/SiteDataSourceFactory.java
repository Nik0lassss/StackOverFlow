package com.chirkevich.nikola.stackoverflow.utils;

import android.arch.paging.DataSource;

import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractorImpl;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageDataSource;

public class SiteDataSourceFactory extends DataSource.Factory<Integer, SiteItem> {

    private SitePageInteractorImpl sitePageInteractor;
    private SiteDataSourceFilter siteDataSourceFilter;

    public SiteDataSourceFactory(SitePageInteractorImpl sitePageInteractor, SiteDataSourceFilter siteDataSourceFilter) {
        this.sitePageInteractor = sitePageInteractor;
        this.siteDataSourceFilter = siteDataSourceFilter;
    }


    @Override
    public DataSource<Integer, SiteItem> create() {
        return new SitePageDataSource(sitePageInteractor, siteDataSourceFilter);
    }
}
