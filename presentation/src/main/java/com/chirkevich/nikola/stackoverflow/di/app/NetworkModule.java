package com.chirkevich.nikola.stackoverflow.di.app;

import com.chirkevich.nikola.data.internet.RetrofitBuilder;
import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.stackoverflow.utils.InterceptorProvider;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class NetworkModule {


    public static final String AUTHENTIFICATE_BUILDER = "authentificate_builder";
    public static final String STACK_OVER_FLOW_BUILDER = "stack_over_flow_builder";

//    private RedirectCallback redirectCallback;

//    public NetworkModule(RedirectCallback redirectCallback) {
//        this.redirectCallback = redirectCallback;
//    }

    @Provides
    @Named(AUTHENTIFICATE_BUILDER)
    Retrofit provideAuthentificateRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildAuthentificateRetrofit(httpClient);
    }

    @Provides
    @Named(STACK_OVER_FLOW_BUILDER)
    Retrofit provideStackOverFlowRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildStatckOverFlowRetrofit(httpClient);
    }

    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    StackOverFlowService buildStackOverFlowService(@Named(STACK_OVER_FLOW_BUILDER) Retrofit retrofit) {
        return retrofit.create(StackOverFlowService.class);
    }

    @Provides
    @Singleton
    AuthentificateService buildAuthorizedService(@Named(AUTHENTIFICATE_BUILDER) Retrofit retrofit) {
        return retrofit.create(AuthentificateService.class);
    }

    @Provides
    Interceptor provideInterceptor() {
        return InterceptorProvider.provideInterceptor();
    }


}
