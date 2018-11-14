package com.chirkevich.nikola.domain.repositories;

import io.reactivex.Single;

public interface LoginRepository {

    Single<String> login(String clientId,
                         String scopes,
                         String redirectUri,
                         String state);
}
