package com.chirkevich.nikola.stackoverflow.di.app.authorized.login_page;

import com.chirkevich.nikola.stackoverflow.ui.login_page.LoginPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = LoginPageModule.class)
public interface LoginPageComponent {

    LoginPresenter provideLoginPresenter();
}
