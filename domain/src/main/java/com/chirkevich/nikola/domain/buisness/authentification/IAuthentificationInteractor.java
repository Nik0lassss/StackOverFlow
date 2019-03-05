package com.chirkevich.nikola.domain.buisness.authentification;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IAuthentificationInteractor {

    Completable login();
    Completable saveToken(String token);
    Single<String> getToken();
}
