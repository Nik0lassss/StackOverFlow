package com.chirkevich.nikola.stackoverflow.di.app.authorized;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.start_page.StartPageComponent;
import com.chirkevich.nikola.stackoverflow.ui.start_page.RedirectCallback;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = {DbModule.class, NetworkModule.class})
public interface AuthorizedComponent {

    StartPageComponent provideStartPageComponent();


}
