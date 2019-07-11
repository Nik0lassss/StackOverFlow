package com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chirkevich.nikola.domain.models.security.Token;

public class AuthentificateClient extends WebViewClient {

    private LoadUrlListener loadUrlListener;
    private String accessTokenKey = "access_token";
    private String expires = "expires";

    public AuthentificateClient(LoadUrlListener loadUrlListener) {
        this.loadUrlListener = loadUrlListener;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.contains(accessTokenKey)) {
            String accessToken = url.substring(url.indexOf(accessTokenKey) + 13, url.indexOf('&' + expires));
            Integer expire = Integer.valueOf(url.substring(url.indexOf(expires) + 8));
            loadUrlListener.onLoadToken(new Token(accessToken, expire));
            return true;
        }
        return false;
    }

}
