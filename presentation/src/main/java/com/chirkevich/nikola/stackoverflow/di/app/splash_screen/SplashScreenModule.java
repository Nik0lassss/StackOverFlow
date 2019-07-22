package com.chirkevich.nikola.stackoverflow.di.app.splash_screen;

import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;
import com.chirkevich.nikola.stackoverflow.ui.splash_screen.SplashPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.IO_SCHEDULER;

@Module
public class SplashScreenModule {

    @Provides
    SplashPresenter provideSplashScreenPresenter(AuthentificationInteractorImpl authentificationInteractor,
                                                 @Named(IO_SCHEDULER) Scheduler scheduler) {
        return new SplashPresenter(authentificationInteractor, scheduler);
    }
}
