package com.chirkevich.nikola.stackoverflow.di;

import android.content.Context;

import com.chirkevich.nikola.stackoverflow.di.app.AppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.AppModule;
import com.chirkevich.nikola.stackoverflow.di.app.AuthorizedNetworkComponent;
import com.chirkevich.nikola.stackoverflow.di.app.DaggerAppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.UnAuthorizedComponent;
import com.chirkevich.nikola.stackoverflow.di.app.NetworkModule;
import com.chirkevich.nikola.stackoverflow.ui.login_page.RedirectCallback;

public class Components {

    private static Components instance;

    private static AppComponent appComponent;

    private AuthorizedNetworkComponent authorizedNetworkComponent;

    public static void init(Context appContext) {
        instance = new Components(appContext);

        //dcdc
        //feature asdasdasdasd

    }

    public static AppComponent getAppComponent() {

        return appComponent;
    }

    public static UnAuthorizedComponent getUnAuthorizedComponent() {
        //test
        return getAppComponent().unAuthorizedComponent();

    }

    public static AuthorizedNetworkComponent getAuthorizedNetworkComponent() {
        return getInstance().buildAuthorizedComponent();
    }

    public static void destroygetAuthorizedNetworkComponent() {
        getInstance().authorizedNetworkComponent = null;
    }

    private Components(Context appContext) {
        appComponent = buildAppComponent(appContext);
    }

    private static Components getInstance() {
        if (instance == null) {
            throw new IllegalStateException("components must be init first");
        }
        return instance;
    }

    private AppComponent buildAppComponent(Context appContext) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();
    }

    private AuthorizedNetworkComponent buildAuthorizedComponent() {
        if (authorizedNetworkComponent == null) {
            authorizedNetworkComponent = getAppComponent().authorizedNetworkComponent();
        }
        return authorizedNetworkComponent;
    }

}
