package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class StartPagePresenter extends MvpPresenter<StartPageView> {

    public StartPagePresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onLoginClick(View view) {
        getViewState().showLoginScreen();
    }

    public void onShowMainScreenClick(View view) {
        getViewState().showMainScreen();
    }


}
