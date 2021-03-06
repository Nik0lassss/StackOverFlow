package com.chirkevich.nikola.stackoverflow.di.app.authorized;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page.MainPageComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.site_page.SitePageComponent;

import dagger.Subcomponent;

@Subcomponent(modules = {SitesModule.class})
@AuthorizedScope
public interface AuthorizedComponent {

    MainPageComponent provideMainPageComponent();
    SitePageComponent provideSitePageComponent();

}
