package com.chirkevich.nikola.domain.buisness.authentification;

import com.chirkevich.nikola.domain.models.security.Token;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IAuthentificationInteractor {

    Completable login();

    Completable saveToken(Token token);

    Single<Token> getToken();
}
