package com.chirkevich.nikola.stackoverflow.di.app.authorized.start_page;


import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.repositories.LoginRepositoryImpl;
import com.chirkevich.nikola.domain.repositories.LoginRepository;
import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class StartPageModule {

    @Provides
    LoginRepository loginRepository(StackOverFlowService stackOverFlowService) {
        return new LoginRepositoryImpl(stackOverFlowService);
    }

    @Provides
    StartPagePresenter provideStartPagePresenter(LoginRepository loginRepository) {
        return new StartPagePresenter(loginRepository);
    }
}
