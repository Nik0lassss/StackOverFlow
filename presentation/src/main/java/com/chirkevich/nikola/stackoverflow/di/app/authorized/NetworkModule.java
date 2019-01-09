package com.chirkevich.nikola.stackoverflow.di.app.authorized;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.chirkevich.nikola.data.internet.RetrofitBuilder;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.stackoverflow.ui.start_page.RedirectCallback;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    public static String URL = "http://api.stackexchange.com/2.2/";
    public static String AUTHENTIFICATE_URL = "https://stackoverflow.com/";

    private RedirectCallback redirectCallback;

    public NetworkModule(RedirectCallback redirectCallback) {
        this.redirectCallback = redirectCallback;
    }

    @Provides
    @AuthorizedScope
    Retrofit provideRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildRetrofit(httpClient);
    }

    @Provides
    @AuthorizedScope
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @AuthorizedScope
    StackOverFlowService buildService(Retrofit retrofit) {
        return retrofit.create(StackOverFlowService.class);
    }

    @Provides
    @AuthorizedScope
    Interceptor provideInterceptor() {
        return chain -> {
            String redirectUrl = chain.request().url().toString();
            redirectCallback.onGetUrl(redirectUrl);
//            Response response = chain.proceed(chain.request());
            return chain.proceed(chain.request());
        };
    }
}
