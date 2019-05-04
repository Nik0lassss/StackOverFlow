package com.chirkevich.nikola.stackoverflow.di.app.authorized.login_page;


import android.content.Context;

import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.local.account.AccountManagerWrapper;
import com.chirkevich.nikola.data.repositories.AnswerRemoteRepositoryImpl;
import com.chirkevich.nikola.data.repositories.LoginRepositoryImpl;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;
import com.chirkevich.nikola.domain.repositories.LoginRepository;
import com.chirkevich.nikola.stackoverflow.ui.login_page.LoginPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.IO_SCHEDULER;
import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class LoginPageModule {

    @Provides
    LoginRepository loginRepository(@Named(IO_SCHEDULER) Scheduler scheduler,
                                    AuthentificateService authentificateService,
                                    AccountManagerWrapper accountManagerWrapper) {
        return new LoginRepositoryImpl(scheduler, authentificateService, accountManagerWrapper);
    }

    @Provides
    AccountManagerWrapper accountManagerWrapper(Context context) {
        return new AccountManagerWrapper(context);
    }


    @Provides
    AnswerRemoteRepository answerRemoteRepository(@Named(IO_SCHEDULER) Scheduler scheduler,
                                                  StackOverFlowService stackOverFlowService) {
        return new AnswerRemoteRepositoryImpl(scheduler, stackOverFlowService);
    }

    @Provides
    AuthentificationInteractor provideAuthenticationInteractor(LoginRepository loginRepository                                                               ) {
        return new AuthentificationInteractor(loginRepository);
    }

    @Provides
    LoginPresenter provideStartPagePresenter(@Named(UI_SCHEDULER) Scheduler scheduler,
                                             AuthentificationInteractor authentificationInteractor) {
        return new LoginPresenter(authentificationInteractor, scheduler);
    }
}
