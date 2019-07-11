package com.chirkevich.nikola.stackoverflow.utils;

import com.chirkevich.nikola.stackoverflow.ui.login_page.RedirectCallback;

import okhttp3.Interceptor;

public class InterceptorProvider {

    private static RedirectCallback redirectCallback;


    public static Interceptor provideInterceptor() {
        return chain -> {
            String redirectUrl = chain.request().url().toString();
            if (redirectCallback != null)
                redirectCallback.onGetUrl(redirectUrl);
//            Response response = chain.proceed(chain.request());
            return chain.proceed(chain.request());
        };
    }

    public static void releaseCallback() {
        redirectCallback = null;
    }

    public static void setCallback(RedirectCallback redirectCallback) {
        InterceptorProvider.redirectCallback = redirectCallback;
    }


}
