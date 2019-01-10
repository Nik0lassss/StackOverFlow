package com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view;

import android.webkit.WebViewClient;

public class WebViewAuthentificateWrapper {
    public static WebViewClient buildClient(LoadUrlListener loadUrlListener) {
        return new AuthentificateClient(loadUrlListener);
    }
}
