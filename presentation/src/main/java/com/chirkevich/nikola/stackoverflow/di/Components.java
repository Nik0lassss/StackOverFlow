package com.chirkevich.nikola.stackoverflow.di;

import android.content.Context;

import com.chirkevich.nikola.stackoverflow.di.app.AppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.AppModule;
import com.chirkevich.nikola.stackoverflow.di.app.DaggerAppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.UnAuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.NetworkModule;
import com.chirkevich.nikola.stackoverflow.ui.login_page.RedirectCallback;

public class Components {

    private static AppComponent appComponent;

    public static void init(Context appContext) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static UnAuthorizedComponent getUnAuthorizedComponent() {
        return getAppComponent().unAuthorizedComponent();
    }

    public static AuthorizedComponent getAuthorizedComponent() {
        return getAppComponent().authorizedComponent();
    }
}
