package com.chirkevich.nikola.stackoverflow.di.app;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.login_page.LoginPageComponent;
import com.chirkevich.nikola.stackoverflow.di.app.start_page.StartPageComponent;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent
@UnAuthorizedScope
public interface UnAuthorizedComponent {

    LoginPageComponent provideLoginPageComponent();

    StartPageComponent provideStartPageComponent();

}
