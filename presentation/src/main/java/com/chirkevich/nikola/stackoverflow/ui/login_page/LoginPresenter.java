package com.chirkevich.nikola.stackoverflow.ui.login_page;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.data.internet.InterceptManager;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;
import com.chirkevich.nikola.domain.buisness.user.IUserInteractor;
import com.chirkevich.nikola.domain.models.security.Token;
import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.LoadUrlListener;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginPageView> implements LoadUrlListener {


    private AuthentificationInteractorImpl authentificationInteractor;
    private IUserInteractor userInteractor;
    private InterceptManager interceptManager;
    private Scheduler scheduler;

    private Disposable loginDisposable;
    private Disposable redirectCallsDisposable;

    public LoginPresenter(
            AuthentificationInteractorImpl authentificationInteractor,
            IUserInteractor userInteractor,
            InterceptManager interceptManager,
            Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.userInteractor = userInteractor;
        this.interceptManager = interceptManager;
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        subsribeOnRedirectCalls();

        login();
    }


    @Override
    public void onLoadToken(Token token) {
        onAuthenticate(token);
    }

    @Override
    public void onErrorLoadToken(String message) {

    }


    @Override
    public void onDestroy() {
        if (redirectCallsDisposable != null)
            redirectCallsDisposable.dispose();
        super.onDestroy();
    }

    private void login() {
        if (loginDisposable != null)
            loginDisposable.dispose();

        loginDisposable = authentificationInteractor.login()
                .observeOn(scheduler)
                .doOnError(this::onErrorLogin)
                .onErrorComplete()
                .subscribe();
    }

    void onRetryClick() {
        getViewState().hideRetryBtn();
        getViewState().showWebView();
        login();
    }

    private void onErrorLogin(Throwable throwable) {
        getViewState().hideWebView();
        getViewState().showRetryBtn();
    }

    private void onLoadErrorAuthenticate(Throwable throwable) {
        getViewState().showErrorToast(throwable.getMessage());
    }


    private void subsribeOnRedirectCalls() {
        redirectCallsDisposable = interceptManager.getRedirectsCalls()
                .observeOn(scheduler)
                .subscribe(this::onGetUrl, this::onErrorGettingRedirectUrl);
    }


    private void onGetUrl(String redirectUrl) {
        getViewState().loadUrl(redirectUrl);
    }

    private void onErrorGettingRedirectUrl(Throwable throwable) {
        getViewState().showErrorToast(throwable.getMessage());
    }


    private void onAuthenticate(Token token) {
        authentificationInteractor.saveToken(token)
                .andThen(userInteractor.syncProfiles())
                .doOnComplete(() -> getViewState().showMainScreen())
                .subscribe();
    }

}
