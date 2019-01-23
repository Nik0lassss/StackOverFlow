package com.chirkevich.nikola.stackoverflow.ui.start_page;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;

import io.reactivex.Scheduler;

@InjectViewState
public class StartPagePresenter extends MvpPresenter<StartPageView> {

    private Scheduler scheduler;
    private AuthentificationInteractor authentificationInteractor;

    public StartPagePresenter(
            AuthentificationInteractor authentificationInteractor,
            Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        authentificationInteractor.login()
                .subscribe();
    }

    public void onAuthenticate(String token) {
        authentificationInteractor.saveToken(token)
                .subscribe();
    }

    public void onLoadErrorAuthenticate(Throwable throwable) {

    }
}
