package com.chirkevich.nikola.stackoverflow.di.app;

import android.content.Context;

import com.chirkevich.nikola.data.local.preferences.AppPreferences;
import com.chirkevich.nikola.data.repositories.AppPreferencesRepositoryImpl;
import com.chirkevich.nikola.domain.repositories.AppPreferencesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppPreferencesModule {

    @Provides
    @Singleton
    AppPreferences provideAppPreferences(Context context) {
        return new AppPreferences(context);
    }


    @Provides
    @Singleton
    AppPreferencesRepository provideAppPreferencesRepository(AppPreferences appPreferences) {
        return new AppPreferencesRepositoryImpl(appPreferences);
    }
}
