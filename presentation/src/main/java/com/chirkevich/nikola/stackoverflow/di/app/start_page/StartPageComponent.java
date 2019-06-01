package com.chirkevich.nikola.stackoverflow.di.app.start_page;


import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {StartPageModule.class})
@StartPageScope
public interface StartPageComponent {
    StartPagePresenter provideStartPagePresenter();
}
