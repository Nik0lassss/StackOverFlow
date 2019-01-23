package com.chirkevich.nikola.stackoverflow.di.app.unauthorized;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.DbModule;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.main_page.MainPageComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.start_page.StartPageComponent;

import dagger.Subcomponent;

@Subcomponent(modules = {DbModule.class, NetworkModule.class})
@UnAuthorizedScope
public interface UnAuthorizedComponent {

    StartPageComponent provideStartPageComponent();
}
