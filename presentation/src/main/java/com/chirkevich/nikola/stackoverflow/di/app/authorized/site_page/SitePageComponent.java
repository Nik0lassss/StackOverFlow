package com.chirkevich.nikola.stackoverflow.di.app.authorized.site_page;

import com.chirkevich.nikola.stackoverflow.ui.sites_page.SitePagePresenter;

import dagger.Subcomponent;

@Subcomponent(modules = SitePageModule.class)
public interface SitePageComponent {

    SitePagePresenter provideSitePagePresenter();
}
