package com.chirkevich.nikola.stackoverflow.di.app.authorized.start_page;

import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = StartPageModule.class)
public interface StartPageComponent {

    StartPagePresenter provideStartPagePresenter();
}
