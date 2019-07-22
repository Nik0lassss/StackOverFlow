package com.chirkevich.nikola.stackoverflow.di.app.start_page;

import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;
import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class StartPageModule {

    @Provides
    StartPagePresenter provideStartPagePresenter(AuthentificationInteractorImpl authentificationInteractor, @Named(UI_SCHEDULER) Scheduler scheduler) {
        return new StartPagePresenter(authentificationInteractor, scheduler);
    }
}
