package com.chirkevich.nikola.domain.buisness.authentification;

import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AuthentificationInteractor implements IAuthentificationInteractor {

    private String clientId = "12838";
    private String scopes = "read_inbox";
    private String redirectUri = "https://com.chirkevich.nikola.assistant";
    private LoginRepository loginRepository;

    public AuthentificationInteractor(LoginRepository loginRepository) {
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
    public Completable saveToken(String token) {
        return loginRepository.saveToken(token);
    }

    @Override
    public Single<String> getToken() {
        return loginRepository.getToken();
    }
}
