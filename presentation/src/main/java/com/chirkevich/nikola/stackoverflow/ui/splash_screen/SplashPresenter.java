package com.chirkevich.nikola.stackoverflow.ui.splash_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private final static int DELAY = 700;

    private AuthentificationInteractor authentificationInteractor;
    private Disposable isLoggedDisposable;
    private Scheduler scheduler;

    public SplashPresenter(AuthentificationInteractorImpl authentificationInteractor, Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.scheduler = scheduler;
    }

    @Override
    public void attachView(SplashView view) {
        super.attachView(view);
        if (isLoggedDisposable != null)
            isLoggedDisposable.dispose();

        isLoggedDisposable = authentificationInteractor.isLogged()
                .delay(DELAY, TimeUnit.MILLISECONDS)
                .observeOn(scheduler)
                .subscribe(this::onGetIsLogged);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isLoggedDisposable.dispose();
    }

    private void onGetIsLogged(Boolean isLogged) {
        manageView(isLogged);
    }

    private void manageView(Boolean isLogged) {
        if (isLogged)
            getViewState().goToMainScreen();
        else getViewState().goToStartPageActitivty();
    }
}
