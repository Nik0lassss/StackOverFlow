package com.chirkevich.nikola.stackoverflow.di.app.authorized;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page.MainPageComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.start_page.StartPageComponent;

import dagger.Subcomponent;

@Subcomponent(modules = {DbModule.class, NetworkModule.class})
@AuthorizedScope
public interface AuthorizedComponent {

    MainPageComponent provideMainPageComponent();

}
