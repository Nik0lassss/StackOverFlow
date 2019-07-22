package com.chirkevich.nikola.stackoverflow.di.app.synchronization;

import android.content.Context;

import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.local.account.AccountManagerWrapper;
import com.chirkevich.nikola.data.local.database.dao.user.ProfileDataSource;
import com.chirkevich.nikola.data.local.preferences.UserPreferences;
import com.chirkevich.nikola.data.repositories.LoginRepositoryImpl;
import com.chirkevich.nikola.data.repositories.UserLocalRepositoryImpl;
import com.chirkevich.nikola.data.repositories.UserRemoteRepositoryImpl;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;
import com.chirkevich.nikola.domain.buisness.user.IUserInteractor;
import com.chirkevich.nikola.domain.buisness.user.UserInteractor;
import com.chirkevich.nikola.domain.repositories.LoginRepository;
import com.chirkevich.nikola.domain.repositories.UserLocalRepository;
import com.chirkevich.nikola.domain.repositories.UserRemoteRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.IO_SCHEDULER;

@Module
public class SynchronizationModule {

    @Provides
    @Singleton
    IUserInteractor userInteractor(UserRemoteRepository userRemoteRepository,
                                   UserLocalRepository userLocalRepository,
                                   AuthentificationInteractorImpl authentificationInteractor) {
        return new UserInteractor(userRemoteRepository, userLocalRepository, authentificationInteractor);
    }


    @Provides
    @Singleton
    UserRemoteRepository provideUserRemoteRepository(StackOverFlowService stackOverFlowService, @Named(IO_SCHEDULER) Scheduler scheduler) {
        return new UserRemoteRepositoryImpl(stackOverFlowService, scheduler);
    }

    @Provides
    @Singleton
    UserLocalRepository provideUserLocalRepository(ProfileDataSource profileDataSource, @Named(IO_SCHEDULER) Scheduler scheduler) {
        return new UserLocalRepositoryImpl(profileDataSource, scheduler);
    }

    @Provides
    @Singleton
    AuthentificationInteractorImpl provideAuthenticationInteractor(LoginRepository loginRepository) {
        return new AuthentificationInteractorImpl(loginRepository);
    }

    @Provides
    @Singleton
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


}
