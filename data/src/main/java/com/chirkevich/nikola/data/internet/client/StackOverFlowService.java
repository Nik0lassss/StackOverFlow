package com.chirkevich.nikola.data.internet.client;

import com.chirkevich.nikola.data.internet.model.answer.ItemsRemote;

import java.util.Date;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Колян on 21.07.2018.
 */

public interface StackOverFlowService {
//    @GET("answers")
//    Single<ItemsRemote> getAnswers(@Query("page") Integer page,
//                                   @Query("todate") Date todate,
//                                   @Query("max") Date max,
//                                   @Query("pagsize") Integer pagesize,
//                                   @Query("order") String order,
//                                   @Query("sort") String sort,
//                                   @Query("fromdate") Date fromdate,
//                                   @Query("min") Date min,
//                                   @Query("site") String site);

    @GET("answers")
    Single<ItemsRemote> getAnswers(@Query("page") Integer page,
                                 @Query("todate") Date todate,
                                 @Query("max") Date max,
                                 @Query("pagsize") Integer pagesize,
                                 @Query("order") String order,
                                 @Query("sort") String sort,
                                 @Query("fromdate") Date fromdate,
                                 @Query("min") Date min,
                                 @Query("site") String site);



}
