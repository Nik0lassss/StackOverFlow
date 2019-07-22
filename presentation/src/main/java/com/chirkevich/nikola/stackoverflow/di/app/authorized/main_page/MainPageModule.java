package com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page;

import com.chirkevich.nikola.domain.buisness.synchronization.SynchronizationInteractorImpl;
import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPagePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPageModule {

    @Provides
    MainPagePresenter mainPagePresenter(SynchronizationInteractorImpl synchronizationInteractor) {
        return new MainPagePresenter(synchronizationInteractor);
    }

}
