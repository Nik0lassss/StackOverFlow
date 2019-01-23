package com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page;

import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPagePresenter;

import dagger.Module;

@Module
public class MainPageModule {

    MainPagePresenter mainPagePresenter() {
        return new MainPagePresenter();
    }
}
