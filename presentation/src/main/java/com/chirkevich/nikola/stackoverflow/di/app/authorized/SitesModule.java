package com.chirkevich.nikola.stackoverflow.di.app.authorized;

import android.support.annotation.NonNull;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.local.database.dao.site.SiteDataSource;
import com.chirkevich.nikola.data.repositories.AnswerRemoteRepositoryImpl;
import com.chirkevich.nikola.data.repositories.SiteLocalRepositoryImpl;
import com.chirkevich.nikola.data.repositories.SitesRemoteRepositoryImpl;
import com.chirkevich.nikola.domain.buisness.synchronization.SynchronizationInteractor;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.IO_SCHEDULER;

@Module
public class SitesModule {


    @Provides
    @NonNull
    @AuthorizedScope
    SynchronizationInteractor synchronizationInteractor(AnswerRemoteRepository answerRemoteRepository,
                                                        SiteLocalRepository siteLocalRepository,
                                                        SitesRemoteRepository sitesRemoteRepository) {
        return new SynchronizationInteractor(answerRemoteRepository, siteLocalRepository, sitesRemoteRepository);
    }

    @Provides
    @AuthorizedScope
    AnswerRemoteRepository answerRemoteRepository(@Named(IO_SCHEDULER) Scheduler scheduler,
                                                  StackOverFlowService stackOverFlowService) {
        return new AnswerRemoteRepositoryImpl(scheduler, stackOverFlowService);
    }

    @Provides
    @AuthorizedScope
    SiteLocalRepository siteLocalRepository(@Named(IO_SCHEDULER) Scheduler scheduler,
                                               SiteDataSource siteDataSource) {
        return new SiteLocalRepositoryImpl(siteDataSource, scheduler);
    }

    @Provides
    @AuthorizedScope
    SitesRemoteRepository sitesRemoteRepositoryy(@Named(IO_SCHEDULER) Scheduler scheduler,
                                                 StackOverFlowService stackOverFlowService) {
        return new SitesRemoteRepositoryImpl(stackOverFlowService, scheduler);
    }


}
