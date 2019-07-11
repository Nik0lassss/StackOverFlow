package com.chirkevich.nikola.stackoverflow.ui.login_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPageActivity;
import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.LoadUrlListener;
import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.WebViewAuthentificateWrapper;
import com.chirkevich.nikola.stackoverflow.utils.InterceptorProvider;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class LoginActivity extends MvpAppCompatActivity implements LoginPageView {

    private WebView webView;


    @ProvidePresenter
    LoginPresenter provideStartPagePresenter() {
        return Components.getUnAuthorizedComponent().provideLoginPageComponent().provideLoginPresenter();
    }

    @InjectPresenter
    LoginPresenter loginPresenter;


    public static Intent getIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_layout);
        webView = findViewById(R.id.web_view);

        setUpWebView();
    }

    @Override
    public void loadUrl(String redirectUrl) {
        new Handler(Looper.getMainLooper()).post(() -> {
            webView.loadUrl(redirectUrl);
        });
    }

    @Override
    public void showMainScreen() {
        startActivity(MainPageActivity.getIntent(this)
                .addFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK));
    }

    @Override
    public void showErrorToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    private void setUpWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(WebViewAuthentificateWrapper.buildClient(loginPresenter));
    }

}
