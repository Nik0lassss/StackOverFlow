package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.accounts.Account;
import android.accounts.AccountManager;
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


public class StartPageActivity extends MvpAppCompatActivity implements StartPageView, RedirectCallback, LoadUrlListener {

    private WebView webView;


    @ProvidePresenter
    StartPagePresenter provideStartPagePresenter() {
        return Components.getAuthorizedComponent(this).provideStartPageComponent().provideStartPagePresenter();
    }

    @InjectPresenter
    StartPagePresenter startPagePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_layout);
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
        startPagePresenter.onAuthenticate(token);
    }

    @Override
    public void onErrorLoadToken(String message) {

    }
}
