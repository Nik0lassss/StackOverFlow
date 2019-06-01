package com.chirkevich.nikola.stackoverflow.di.app.start_page;

import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class StartPageModule {

    @Provides
    StartPagePresenter provideStartPagePresenter() {
        return new StartPagePresenter();
    }
}
