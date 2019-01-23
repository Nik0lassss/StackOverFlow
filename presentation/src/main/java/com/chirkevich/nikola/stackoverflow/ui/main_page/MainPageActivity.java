package com.chirkevich.nikola.stackoverflow.ui.main_page;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;

public class MainPageActivity extends MvpAppCompatActivity {

    @ProvidePresenter
    MainPagePresenter provideMainPagePresenter() {
        return Components.getAppComponent().authorizedComponent().provideMainPageComponent().provideMainPagePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);
    }
}
