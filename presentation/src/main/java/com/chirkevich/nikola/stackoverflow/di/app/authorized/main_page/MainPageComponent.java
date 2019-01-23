package com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page;

import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPagePresenter;

import dagger.Subcomponent;

@Subcomponent(modules = MainPageModule.class)
public interface MainPageComponent {
    MainPagePresenter provideMainPagePresenter();
}
