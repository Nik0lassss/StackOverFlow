package com.chirkevich.nikola.stackoverflow.di.app;

import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedScope;
import com.chirkevich.nikola.stackoverflow.di.app.splash_screen.SplashScreenComponent;

import dagger.Subcomponent;

@Subcomponent(modules = AuthorizedNetworkModule.class)
@AuthorizedNetworkScope
public interface AuthorizedNetworkComponent {


}
