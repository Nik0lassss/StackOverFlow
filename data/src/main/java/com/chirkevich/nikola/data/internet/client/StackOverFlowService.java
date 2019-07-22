package com.chirkevich.nikola.data.internet.client;

import com.chirkevich.nikola.data.internet.model.answer.AnswerItemsRemoteResponse;
import com.chirkevich.nikola.data.internet.model.sites.SitesResponse;
import com.chirkevich.nikola.data.internet.model.user.me.ProfileResponseEnvelop;

import java.util.Date;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Колян on 21.07.2018.
 */

public interface StackOverFlowService {

    @GET("answers")
    Single<AnswerItemsRemoteResponse> getAnswers(@Query("page") Integer page,
                                                 @Query("todate") Date todate,
                                                 @Query("max") Date max,
                                                 @Query("pagsize") Integer pagesize,
                                                 @Query("order") String order,
                                                 @Query("sort") String sort,
                                                 @Query("fromdate") Date fromdate,
                                                 @Query("min") Date min,
                                                 @Query("site") String site);

    @GET("sites")
    Single<SitesResponse> getSites(@Query("page") Integer page,
                                   @Query("pagesize") Integer pageSize);

    @GET("sites")
    Single<SitesResponse> getSites();

    @GET("me")
    Single<ProfileResponseEnvelop> me(@Query("order") String order,
                                      @Query("sort") String sort,
                                      @Query("site") String site,
                                      @Query(encoded = true, value = "access_token") String access_token,
                                      @Query(encoded = true, value = "key") String key);
}
