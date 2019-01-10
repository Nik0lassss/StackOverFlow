package com.chirkevich.nikola.stackoverflow.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.Authenticator;

public class AutheticatatorService extends Service {

    private Authenticator authenticator;

    @Override
    public void onCreate() {
        authenticator = new Authenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
