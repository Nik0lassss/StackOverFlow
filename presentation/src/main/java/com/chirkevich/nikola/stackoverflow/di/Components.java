package com.chirkevich.nikola.stackoverflow.di;

import android.content.Context;

import com.chirkevich.nikola.stackoverflow.di.app.AppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.DaggerAppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;
import com.chirkevich.nikola.stackoverflow.ui.start_page.RedirectCallback;

public class Components {

    private static AppComponent appComponent;

    public static void init(Context appContext) {
        appComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static AuthorizedComponent getAuthorizedComponent(RedirectCallback redirectCallback) {
       return getAppComponent().authorizedComponent(new NetworkModule(redirectCallback));
    }
}
