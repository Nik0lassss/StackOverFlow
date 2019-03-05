package com.chirkevich.nikola.stackoverflow.di.app.authorized;

import com.chirkevich.nikola.data.internet.RetrofitBuilder;
import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.stackoverflow.di.app.unauthorized.UnAuthorizedScope;
import com.chirkevich.nikola.stackoverflow.ui.login_page.RedirectCallback;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class NetworkModule {


    public static final String AUTHENTIFICATE_BUILDER = "authentificate_builder";
    public static final String STACK_OVER_FLOW_BUILDER = "stack_over_flow_builder";

    private RedirectCallback redirectCallback;

    public NetworkModule(RedirectCallback redirectCallback) {
        this.redirectCallback = redirectCallback;
    }

    @Provides
    @UnAuthorizedScope
    @Named(AUTHENTIFICATE_BUILDER)
    Retrofit provideAuthentificateRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildAuthentificateRetrofit(httpClient);
    }

    @Provides
    @UnAuthorizedScope
    @Named(STACK_OVER_FLOW_BUILDER)
    Retrofit provideStackOverFlowRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildStatckOverFlowRetrofit(httpClient);
    }

    @Provides
    @UnAuthorizedScope
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @UnAuthorizedScope
    StackOverFlowService buildStackOverFlowService(@Named(STACK_OVER_FLOW_BUILDER) Retrofit retrofit) {
        return retrofit.create(StackOverFlowService.class);
    }

    @Provides
    @UnAuthorizedScope
    AuthentificateService buildAuthorizedService(@Named(AUTHENTIFICATE_BUILDER) Retrofit retrofit) {
        return retrofit.create(AuthentificateService.class);
    }

    @Provides
    @UnAuthorizedScope
    Interceptor provideInterceptor() {
        return chain -> {
            String redirectUrl = chain.request().url().toString();
            redirectCallback.onGetUrl(redirectUrl);
//            Response response = chain.proceed(chain.request());
            return chain.proceed(chain.request());
        };
    }
}
