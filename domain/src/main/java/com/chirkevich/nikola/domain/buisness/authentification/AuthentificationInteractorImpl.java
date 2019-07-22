package com.chirkevich.nikola.domain.buisness.authentification;

import com.chirkevich.nikola.domain.models.exceptions.TokenNotFoundException;
import com.chirkevich.nikola.domain.models.security.Token;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;

public class AuthentificationInteractorImpl implements AuthentificationInteractor {

    private String clientId = "12838";
    private String scopes = "read_inbox";
    private String redirectUri = "https://com.chirkevich.nikola.assistant";
    private LoginRepository loginRepository;

    private BehaviorSubject<Boolean> isLoggedSubject = BehaviorSubject.create();

    public AuthentificationInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Completable login() {
        return loginRepository.login(clientId,
                scopes,
                redirectUri,
                null);
    }

    @Override
    public Completable saveToken(Token token) {
        return loginRepository.saveToken(token)
                .doOnComplete(this::setLodded);
    }

    @Override
    public Single<Token> getToken() {
        return loginRepository.getToken();
    }

    @Override
    public Observable<Boolean> isLogged() {
        try {
            if (isLoggedSubject.getValue() == null && hasAccessToken())
                isLoggedSubject.onNext(true);
        } catch (TokenNotFoundException e) {
            isLoggedSubject.onNext(false);
        }

        return isLoggedSubject;
    }

    @Override
    public void setLodded() {
        isLoggedSubject.onNext(true);
    }

    @Override
    public void setLoggedOut() {
        isLoggedSubject.onNext(false);
    }

    private boolean hasAccessToken() {
        return getAccessTokenSync() != null;
    }

    private Token getAccessTokenSync() {
        return loginRepository.getToken().blockingGet();
    }
}
