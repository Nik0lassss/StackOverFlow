package com.chirkevich.nikola.stackoverflow.di.app.splash_screen;

import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.stackoverflow.ui.splash_screen.SplashPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = SplashScreenModule.class)
public interface SplashScreenComponent {

    SplashPresenter provideSplashScreenPresenter();

}
