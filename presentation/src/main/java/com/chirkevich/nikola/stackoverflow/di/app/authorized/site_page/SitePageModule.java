package com.chirkevich.nikola.stackoverflow.di.app.authorized.site_page;


import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.SitePagePresenter;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageDataSource;
import com.chirkevich.nikola.stackoverflow.utils.MainThreadExecutor;
import com.chirkevich.nikola.stackoverflow.utils.SiteDataSourceFactory;
import com.chirkevich.nikola.stackoverflow.utils.SiteDataSourceFilter;

import java.util.concurrent.Executors;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class SitePageModule {

    @Provides
    @SitePageScope
    SitePagePresenter provideSitePagePresenter(SitePageInteractor sitePageInteractor,
                                               LiveData<PagedList<SiteItem>> siteItemsPagedList,
                                               SiteDataSourceFilter siteDataSourceFilter,
                                               @Named(UI_SCHEDULER) Scheduler scheduler) {
        return new SitePagePresenter(sitePageInteractor, siteItemsPagedList, siteDataSourceFilter, scheduler);
    }

    @Provides
    @SitePageScope
    SitePageInteractor provideSitePageInteractor(SitesRemoteRepository sitesRemoteRepository) {
        return new SitePageInteractor(sitesRemoteRepository);
    }

    @Provides
    @SitePageScope
    SitePageDataSource provideSitePageDataSource(SitePageInteractor sitePageInteractor, SiteDataSourceFilter siteDataSourceFilter) {
        return new SitePageDataSource(sitePageInteractor, siteDataSourceFilter);
    }

    @Provides
    @SitePageScope
    PagedList.Config providePageAdaptersConfig() {
        return new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build();
    }

    @Provides
    @SitePageScope
    LiveData<PagedList<SiteItem>> providePagedList(SiteDataSourceFactory sitePageDataSourceFactory, PagedList.Config config) {
        return new LivePagedListBuilder<>(sitePageDataSourceFactory, config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build();
    }

    @Provides
    @SitePageScope
    SiteDataSourceFilter provideFilter() {
        return new SiteDataSourceFilter();
    }

    @Provides
    @SitePageScope
    SiteDataSourceFactory provideSiteDataSourceFactory(SitePageInteractor sitePageInteractor,
                                                       SiteDataSourceFilter siteDataSourceFilter) {
        return new SiteDataSourceFactory(sitePageInteractor, siteDataSourceFilter);
    }
}
