package com.chirkevich.nikola.data.internet.client;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthentificateService {

    @POST("oauth/dialog")
    Completable authentificate(@Query("client_id") String clientId,
                               @Query("scope") String scopes,
                               @Query("redirect_uri") String redirectUri,
                               @Query("state") String state);


}
