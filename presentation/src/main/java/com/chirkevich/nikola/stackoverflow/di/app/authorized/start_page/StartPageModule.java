package com.chirkevich.nikola.stackoverflow.di.app.authorized.start_page;


import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.repositories.AnswerRepositoryImpl;
import com.chirkevich.nikola.data.repositories.LoginRepositoryImpl;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;
import com.chirkevich.nikola.domain.repositories.LoginRepository;
import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.IO_SCHEDULER;
import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class StartPageModule {

    @Provides
    LoginRepository loginRepository(@Named(IO_SCHEDULER) Scheduler scheduler,
                                    AuthentificateService authentificateService) {
        return new LoginRepositoryImpl(scheduler, authentificateService);
    }

    @Provides
    AnswerRemoteRepository answerRemoteRepository(@Named(IO_SCHEDULER) Scheduler scheduler,
                                                  StackOverFlowService stackOverFlowService) {
        return new AnswerRepositoryImpl(scheduler, stackOverFlowService);
    }

    @Provides
    StartPagePresenter provideStartPagePresenter(@Named(UI_SCHEDULER) Scheduler scheduler,
                                                 LoginRepository loginRepository,
                                                 AnswerRemoteRepository answerRemoteRepository) {
        return new StartPagePresenter(scheduler, loginRepository, answerRemoteRepository);
    }
}
