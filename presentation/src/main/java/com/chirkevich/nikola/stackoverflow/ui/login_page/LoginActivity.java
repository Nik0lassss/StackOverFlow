package com.chirkevich.nikola.stackoverflow.ui.login_page;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.LoadUrlListener;
import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.WebViewAuthentificateWrapper;


public class LoginActivity extends MvpAppCompatActivity implements LoginPageView, RedirectCallback, LoadUrlListener {

    private WebView webView;


    @ProvidePresenter
    LoginPresenter provideStartPagePresenter() {
        return Components.getUnAuthorizedComponent(this).provideLoginPageComponent().provideLoginPresenter();
    }

    @InjectPresenter
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_layout);
        webView = findViewById(R.id.web_view);

        setUpWebView();


    }

    @Override
    public void onGetUrl(String redirectUrl) {
        new Handler(Looper.getMainLooper()).post(() -> {
            webView.loadUrl(redirectUrl);
        });
    }

    private void setUpWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(WebViewAuthentificateWrapper.buildClient(this));
    }

    @Override
    public void onLoadToken(String token) {
        loginPresenter.onAuthenticate(token);
    }

    @Override
    public void onErrorLoadToken(String message) {

    }
}
