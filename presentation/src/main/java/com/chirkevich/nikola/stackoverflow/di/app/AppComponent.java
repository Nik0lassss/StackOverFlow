package com.chirkevich.nikola.stackoverflow.di.app;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.synchronization.SynchronizationModule;


import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {SchedulerModule.class, AppModule.class, DbModule.class, NetworkModule.class, UserModule.class, SynchronizationModule.class, AppPreferencesModule.class})
@Singleton
public interface AppComponent {

    AuthorizedNetworkComponent authorizedNetworkComponent();

    AuthorizedComponent authorizedComponent();

    UnAuthorizedComponent unAuthorizedComponent();

}
