package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;

public class StartPageActivity extends MvpAppCompatActivity implements StartPageView, RedirectCallback {

    private WebView webView;
    private String code= "code";

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
        webView = (WebView) findViewById(R.id.web_view);

        setUpWebView();

    }

    @Override
    public void onGetUrl(String redirectUrl) {
        new Handler(Looper.getMainLooper()).post(() -> {
            webView.loadUrl(redirectUrl);
        });
    }

    private void setUpWebView()
    {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.contains(code)) {
                    String token = url.substring(url.lastIndexOf("code") + 5);
                    return true;
                }
                return false;
            }
        });
    }
}
