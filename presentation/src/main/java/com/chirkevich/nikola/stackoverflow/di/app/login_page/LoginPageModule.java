package com.chirkevich.nikola.stackoverflow.di.app.login_page;


import com.chirkevich.nikola.data.internet.InterceptManager;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;
import com.chirkevich.nikola.domain.buisness.user.IUserInteractor;
import com.chirkevich.nikola.stackoverflow.ui.login_page.LoginPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class LoginPageModule {




    @Provides
    LoginPresenter provideStartPagePresenter(AuthentificationInteractorImpl authentificationInteractor,
                                             IUserInteractor iUserInteractor,
                                             InterceptManager interceptManager,
                                             @Named(UI_SCHEDULER) Scheduler scheduler) {
        return new LoginPresenter(authentificationInteractor, iUserInteractor, interceptManager, scheduler);
    }


}
