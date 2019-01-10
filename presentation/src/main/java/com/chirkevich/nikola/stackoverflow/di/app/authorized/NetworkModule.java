package com.chirkevich.nikola.stackoverflow.di.app.authorized;

import com.chirkevich.nikola.data.internet.RetrofitBuilder;
import com.chirkevich.nikola.data.internet.client.AuthentificateService;
import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.stackoverflow.ui.start_page.RedirectCallback;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    public static String URL = "http://api.stackexchange.com/2.2/";
    public static String AUTHENTIFICATE_URL = "https://stackoverflow.com/";

    public static final String AUTHENTIFICATE_BUILDER ="authentificate_builder";
    public static final String STACK_OVER_FLOW_BUILDER ="stack_over_flow_builder";

    private RedirectCallback redirectCallback;

    public NetworkModule(RedirectCallback redirectCallback) {
        this.redirectCallback = redirectCallback;
    }

    @Provides
    @AuthorizedScope
    @Named(AUTHENTIFICATE_BUILDER)
    Retrofit provideAuthentificateRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildAuthentificateRetrofit(httpClient);
    }

    @Provides
    @AuthorizedScope
    @Named(STACK_OVER_FLOW_BUILDER)
    Retrofit provideStackOverFlowRetrofit(OkHttpClient.Builder httpClient, Interceptor interceptor) {
        httpClient.addNetworkInterceptor(interceptor);
        return RetrofitBuilder.buildStatckOverFlowRetrofit(httpClient);
    }

    @Provides
    @AuthorizedScope
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @AuthorizedScope
    StackOverFlowService buildStackOverFlowService(@Named(STACK_OVER_FLOW_BUILDER) Retrofit retrofit) {
        return retrofit.create(StackOverFlowService.class);
    }

    @Provides
    @AuthorizedScope
    AuthentificateService buildAuthorizedService(@Named(AUTHENTIFICATE_BUILDER) Retrofit retrofit) {
        return retrofit.create(AuthentificateService.class);
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
