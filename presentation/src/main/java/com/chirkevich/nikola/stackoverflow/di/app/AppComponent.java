package com.chirkevich.nikola.stackoverflow.di.app;


import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;

import dagger.Component;

@Component(modules = SchedulerModule.class)
public interface AppComponent {

    AuthorizedComponent authorizedComponent();
}
