package com.chirkevich.nikola.stackoverflow.di.app.authorized;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page.MainPageComponent;

import dagger.Subcomponent;

@Subcomponent(modules = {DbModule.class,  SitesModule.class})
@AuthorizedScope
public interface AuthorizedComponent {

    MainPageComponent provideMainPageComponent();

}
