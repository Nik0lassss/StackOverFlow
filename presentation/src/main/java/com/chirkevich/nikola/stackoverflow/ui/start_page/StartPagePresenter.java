package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.util.Log;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.stackoverflow.di.Components;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class StartPagePresenter extends MvpPresenter<StartPageView> {

    private AuthentificationInteractor authentificationInteractor;
    private Scheduler scheduler;


    public StartPagePresenter(AuthentificationInteractor authentificationInteractor, Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.scheduler = scheduler;
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


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
