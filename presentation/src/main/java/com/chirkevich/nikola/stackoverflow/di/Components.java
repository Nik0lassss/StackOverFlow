package com.chirkevich.nikola.stackoverflow.di;

import android.content.Context;

import com.chirkevich.nikola.stackoverflow.di.app.AppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.DaggerAppComponent;

public class Components {

    private static AppComponent appComponent;

    public static void init(Context appContext){
        appComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
