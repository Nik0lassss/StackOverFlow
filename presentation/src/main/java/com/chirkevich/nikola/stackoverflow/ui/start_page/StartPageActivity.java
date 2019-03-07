package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.login_page.LoginActivity;
import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StartPageActivity extends MvpAppCompatActivity implements StartPageView {

    @BindView(R.id.login)
    Button loginBtn;

    @BindView(R.id.without_login)
    Button withoutLoginBtn;


    @ProvidePresenter
    StartPagePresenter providePresenter() {
        return Components.getUnAuthorizedComponent(null).provideStartPageComponent().provideStartPagePresenter();
    }


    @InjectPresenter
    StartPagePresenter startPagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_layout);
        ButterKnife.bind(this);
        initClickListeners();
    }

    @Override
    public void showLoginScreen() {
        startActivity(LoginActivity.getIntent(this));
    }

    @Override
    public void showMainScreen() {
        startActivity(MainPageActivity.getIntent(this));
    }

    private void initClickListeners() {
        loginBtn.setOnClickListener(startPagePresenter::onLoginClick);
        withoutLoginBtn.setOnClickListener(startPagePresenter::onShowMainScreenClick);
    }


}
