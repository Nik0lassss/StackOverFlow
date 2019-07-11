package com.chirkevich.nikola.stackoverflow.ui.login_page;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.data.internet.InterceptManager;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
import com.chirkevich.nikola.domain.models.security.Token;
import com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view.LoadUrlListener;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginPageView> implements LoadUrlListener {


    private AuthentificationInteractor authentificationInteractor;
    private InterceptManager interceptManager;
    private Scheduler scheduler;

    private Disposable redirectCallsDisposable;

    public LoginPresenter(
            AuthentificationInteractor authentificationInteractor,
            InterceptManager interceptManager,
            Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.interceptManager = interceptManager;
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        subsribeOnRedirectCalls();
        authentificationInteractor.login()
                .subscribe();
    }


    @Override
    public void onLoadToken(Token token) {
        onAuthenticate(token);
    }

    @Override
    public void onErrorLoadToken(String message) {

    }


    public void onLoadErrorAuthenticate(Throwable throwable) {
        getViewState().showErrorToast(throwable.getMessage());
    }


    @Override
    public void onDestroy() {
        if (redirectCallsDisposable != null)
            redirectCallsDisposable.dispose();
        super.onDestroy();
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
                .doOnComplete(() -> getViewState().showMainScreen())
                .subscribe();
    }

}
