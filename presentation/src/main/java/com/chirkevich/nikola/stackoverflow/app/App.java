package com.chirkevich.nikola.stackoverflow.app;

import android.app.Application;

import com.chirkevich.nikola.stackoverflow.di.Components;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Components.init(getApplicationContext());
    }
}
