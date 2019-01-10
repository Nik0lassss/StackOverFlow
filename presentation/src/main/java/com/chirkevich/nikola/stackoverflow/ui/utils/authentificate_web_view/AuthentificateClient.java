package com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AuthentificateClient extends WebViewClient {

    private LoadUrlListener loadUrlListener;
    private String code = "code";

    public AuthentificateClient(LoadUrlListener loadUrlListener) {
        this.loadUrlListener = loadUrlListener;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.contains(code)) {
            String token = url.substring(url.lastIndexOf("code") + 5);
            loadUrlListener.onLoadToken(token);
            return true;
        }
        return false;
    }

}
