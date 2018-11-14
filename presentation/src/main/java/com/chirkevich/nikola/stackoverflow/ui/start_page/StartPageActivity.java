package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.NetworkModule;

public class StartPageActivity extends MvpAppCompatActivity implements StartPageView {

    @ProvidePresenter
    StartPagePresenter provideStartPagePresenter() {
        return Components.getAppComponent().authorizedComponent().provideStartPageComponent().provideStartPagePresenter();
    }

    @InjectPresenter
    StartPagePresenter startPagePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_layout);
    }
}
