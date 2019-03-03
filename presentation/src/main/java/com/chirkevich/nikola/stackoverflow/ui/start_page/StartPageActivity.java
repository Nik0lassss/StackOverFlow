package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;

import butterknife.BindView;

public class StartPageActivity extends MvpAppCompatActivity implements StartPageView {

    @BindView(R.id.login)
    Button loginBtn;

    @BindView(R.id.without_login)
    Button withoutLoginBtn;


    @ProvidePresenter
    StartPagePresenter providePresenter() {
        return Components.getUnAuthorizedComponent(null).provideStartPageComponent().provideStartPagePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_layout);
    }
}
