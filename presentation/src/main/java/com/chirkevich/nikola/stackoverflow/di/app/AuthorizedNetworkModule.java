package com.chirkevich.nikola.stackoverflow.di.app;


import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.repositories.UserRemoteRepositoryImpl;
import com.chirkevich.nikola.domain.repositories.UserRemoteRepository;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule.IO_SCHEDULER;

@Module
@AuthorizedNetworkScope
public class AuthorizedNetworkModule {



}
