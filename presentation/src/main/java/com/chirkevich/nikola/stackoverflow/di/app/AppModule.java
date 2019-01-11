package com.chirkevich.nikola.stackoverflow.di.app;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @NonNull
    Context provideAppContext() {
        return appContext;
    }
}
