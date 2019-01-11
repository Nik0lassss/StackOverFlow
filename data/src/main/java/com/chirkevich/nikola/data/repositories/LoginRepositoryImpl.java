package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.local.account.AccountManagerWrapper;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginRepositoryImpl implements LoginRepository {

    private AuthentificateService authentificateService;
    private AccountManagerWrapper accountManagerWrapper;
    private Scheduler scheduler;

    public LoginRepositoryImpl(Scheduler scheduler,
                               AuthentificateService authentificateService,
                               AccountManagerWrapper accountManagerWrapper) {
        this.authentificateService = authentificateService;
        this.accountManagerWrapper = accountManagerWrapper;
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
    public Completable saveToken(String token) {
        return Completable.fromRunnable(() -> accountManagerWrapper.putToken(token));
    }

    @Override
    public Single<String> getToken() {
        return Single.fromCallable(() -> accountManagerWrapper.getToken());
    }
}
