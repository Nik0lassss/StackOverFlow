package com.chirkevich.nikola.data.internet;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitBuilder {
    public static String URL = "http://api.stackexchange.com/2.2/";
    public static String AUTHENTIFICATE_URL = "https://stackoverflow.com/";


    public static Retrofit buildRetrofit(OkHttpClient.Builder httpClient)
    {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
