package com.chirkevich.nikola.stackoverflow.di.app.authorized.site_page;


import android.arch.paging.PagedList;

import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.SitePagePresenter;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageDataSource;
import com.chirkevich.nikola.stackoverflow.utils.MainThreadExecutor;

import java.util.concurrent.Executors;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class SitePageModule {

    @Provides
    SitePagePresenter provideSitePagePresenter(SitePageInteractor sitePageInteractor,
                                               PagedList<SiteItem> siteItemsPagedList,
                                               @Named(UI_SCHEDULER) Scheduler scheduler) {
        return new SitePagePresenter(sitePageInteractor, siteItemsPagedList, scheduler);
    }

    @Provides
    SitePageInteractor provideSitePageInteractor(SitesRemoteRepository sitesRemoteRepository) {
        return new SitePageInteractor(sitesRemoteRepository);
    }

    @Provides
    SitePageDataSource provideSitePageDataSource(SitePageInteractor sitePageInteractor) {
        return new SitePageDataSource(sitePageInteractor);
    }

    @Provides
    PagedList.Config providePageAdaptersConfig() {
        return new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build();
    }

    @Provides
    PagedList<SiteItem> providePagedList(SitePageDataSource sitePageDataSource, PagedList.Config config) {
        return new PagedList.Builder<>(sitePageDataSource, config)
                .setNotifyExecutor(new MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build();
    }
}
