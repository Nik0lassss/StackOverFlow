package com.chirkevich.nikola.stackoverflow.di.app.login_page;


import android.content.Context;

import com.chirkevich.nikola.data.internet.InterceptManager;
import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.local.account.AccountManagerWrapper;
import com.chirkevich.nikola.data.local.preferences.UserPreferences;
import com.chirkevich.nikola.data.repositories.LoginRepositoryImpl;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
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
    LoginRepository loginRepository(
            AuthentificateService authentificateService,
            AccountManagerWrapper accountManagerWrapper,
            UserPreferences userPreferences,
            @Named(IO_SCHEDULER) Scheduler scheduler) {
        return new LoginRepositoryImpl(authentificateService, accountManagerWrapper, userPreferences, scheduler);
    }

    @Provides
    AccountManagerWrapper accountManagerWrapper(Context context) {
        return new AccountManagerWrapper(context);
    }


    @Provides
    AuthentificationInteractor provideAuthenticationInteractor(LoginRepository loginRepository) {
        return new AuthentificationInteractor(loginRepository);
    }

    @Provides
    LoginPresenter provideStartPagePresenter(@Named(UI_SCHEDULER) Scheduler scheduler,
                                             InterceptManager interceptManager,
                                             AuthentificationInteractor authentificationInteractor) {
        return new LoginPresenter(authentificationInteractor, interceptManager, scheduler);
    }
}
