package com.chirkevich.nikola.domain.buisness.authentification;

import com.chirkevich.nikola.domain.models.security.Token;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface AuthentificationInteractor {

    Completable login();

    Completable saveToken(Token token);

    Single<Token> getToken();

    Observable<Boolean> isLogged();

    void setLodded();

    void setLoggedOut();

}
