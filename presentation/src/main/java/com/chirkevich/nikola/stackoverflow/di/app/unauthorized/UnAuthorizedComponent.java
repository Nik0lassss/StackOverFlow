package com.chirkevich.nikola.stackoverflow.di.app.unauthorized;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.DbModule;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.login_page.LoginPageComponent;
import com.chirkevich.nikola.stackoverflow.di.app.unauthorized.start_page.StartPageComponent;
import com.chirkevich.nikola.stackoverflow.di.app.unauthorized.start_page.StartPageModule;

import dagger.Subcomponent;

@Subcomponent(modules = {DbModule.class, NetworkModule.class})
@UnAuthorizedScope
public interface UnAuthorizedComponent {

    LoginPageComponent provideLoginPageComponent();

    StartPageComponent provideStartPageComponent();
}
