package com.chirkevich.nikola.stackoverflow.di.app.authorized.site_page;


import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.SitePagePresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class SitePageModule {

    @Provides
    SitePagePresenter provideSitePagePresenter(SitePageInteractor sitePageInteractor, @Named(UI_SCHEDULER) Scheduler scheduler) {
        return new SitePagePresenter(sitePageInteractor, scheduler);
    }

    @Provides
    SitePageInteractor provideSitePageInteractor(SitesRemoteRepository sitesRemoteRepository) {
        return new SitePageInteractor(sitesRemoteRepository);
    }
}
