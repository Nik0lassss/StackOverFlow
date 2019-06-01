package com.chirkevich.nikola.stackoverflow.ui.login_page;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.stackoverflow.utils.InterceptorProvider;

import io.reactivex.Scheduler;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginPageView> implements RedirectCallback {

    private Scheduler scheduler;
    private AuthentificationInteractor authentificationInteractor;

    public LoginPresenter(
            AuthentificationInteractor authentificationInteractor,
            Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        InterceptorProvider.setCallback(this);
        authentificationInteractor.login()
                .subscribe();
    }

    public void onAuthenticate(String token) {
        authentificationInteractor.saveToken(token)
                .subscribe();
    }

    public void onLoadErrorAuthenticate(Throwable throwable) {

    }

    @Override
    public void onGetUrl(String redirectUrl) {
        getViewState().loadUrl(redirectUrl);
    }

    @Override
    public void onDestroy() {
        InterceptorProvider.releaseCallback();
        super.onDestroy();
    }
}
