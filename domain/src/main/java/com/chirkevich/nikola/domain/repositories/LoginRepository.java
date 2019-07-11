package com.chirkevich.nikola.domain.repositories;

import com.chirkevich.nikola.domain.models.security.Token;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface LoginRepository {

    Completable login(String clientId,
                      String scopes,
                      String redirectUri,
                      String state);

    Completable saveToken(Token token);

    Single<Token> getToken();
}
