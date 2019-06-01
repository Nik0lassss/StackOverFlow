package com.chirkevich.nikola.stackoverflow.di.app;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;


import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {SchedulerModule.class, AppModule.class, DbModule.class, NetworkModule.class})
@Singleton
public interface AppComponent {
    AuthorizedComponent authorizedComponent();

    UnAuthorizedComponent unAuthorizedComponent();

}
