package com.chirkevich.nikola.domain.repositories;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface LoginRepository {

    Completable login(String clientId,
                      String scopes,
                      String redirectUri,
                      String state);

    Completable saveToken(String token);

    Single<String> getToken();
}
