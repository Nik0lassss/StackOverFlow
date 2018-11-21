package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import org.mapstruct.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import retrofit2.http.Query;

public class LoginRepositoryImpl implements LoginRepository {

    private StackOverFlowService stackOverFlowService;

    public LoginRepositoryImpl(Scheduler scheduler,
                               StackOverFlowService stackOverFlowService) {
        this.stackOverFlowService = stackOverFlowService;
    }

    @Override
    public Single<String> login(String clientId,
                                String scopes,
                                String redirectUri,
                                String state) {
        return stackOverFlowService.authentificate(clientId, scopes, redirectUri, state);
    }
}
