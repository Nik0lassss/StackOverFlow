package com.chirkevich.nikola.stackoverflow.di.app;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;


import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {SchedulerModule.class, AppModule.class})
@Singleton
public interface AppComponent {

    AuthorizedComponent authorizedComponent(NetworkModule networkModule);
}
