package com.chirkevich.nikola.stackoverflow.di.app.authorized;

import android.support.annotation.NonNull;

import com.chirkevich.nikola.domain.buisness.synchronization.SynchronizationInteractor;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import dagger.Module;
import dagger.Provides;

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

}
