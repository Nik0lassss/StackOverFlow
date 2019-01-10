package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginRepositoryImpl implements LoginRepository {

    private AuthentificateService authentificateService;
    private Scheduler scheduler;

    public LoginRepositoryImpl(Scheduler scheduler,
                               AuthentificateService authentificateService) {
        this.authentificateService = authentificateService;
        this.scheduler = scheduler;
    }

    @Override
    public Single<String> login(String clientId,
                                String scopes,
                                String redirectUri,
                                String state) {
        return authentificateService.authentificate(clientId, scopes, redirectUri, state)
                .subscribeOn(scheduler);
    }
}
