package com.chirkevich.nikola.stackoverflow.di.app;

import android.content.Context;

import com.chirkevich.nikola.data.local.preferences.UserPreferences;
import com.chirkevich.nikola.domain.repositories.UserRemoteRepository;

import dagger.Module;
import dagger.Provides;


@Module
public class UserModule {

    @Provides
    UserPreferences userPreferences(Context context) {
        return new UserPreferences(context);
    }
}
