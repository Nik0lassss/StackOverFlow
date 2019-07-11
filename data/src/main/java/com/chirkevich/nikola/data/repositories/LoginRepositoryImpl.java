package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.local.account.AccountManagerWrapper;
import com.chirkevich.nikola.data.local.preferences.UserPreferences;
import com.chirkevich.nikola.domain.models.security.Token;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginRepositoryImpl implements LoginRepository {


    private AuthentificateService authentificateService;
    private AccountManagerWrapper accountManagerWrapper;
    private UserPreferences userPreferences;
    private Scheduler scheduler;

    public LoginRepositoryImpl(AuthentificateService authentificateService,
                               AccountManagerWrapper accountManagerWrapper,
                               UserPreferences userPreferences,
                               Scheduler scheduler) {
        this.authentificateService = authentificateService;
        this.accountManagerWrapper = accountManagerWrapper;
        this.userPreferences = userPreferences;
        this.scheduler = scheduler;
    }

    @Override
    public Completable login(String clientId,
                             String scopes,
                             String redirectUri,
                             String state) {
        return authentificateService.authentificate(clientId, scopes, redirectUri, state)
                .subscribeOn(scheduler);
    }

    @Override
    public Completable saveToken(Token token) {
        return Completable.fromRunnable(() -> {
            accountManagerWrapper.putAccessToken(token.getAccessToken());
            userPreferences.setTokenExpired(token.getExpire());
        });
    }

    @Override
    public Single<Token> getToken() {
        return Single.fromCallable(() -> new Token(accountManagerWrapper.getAccessToken(), userPreferences.getTokenExpired()));
    }
}
