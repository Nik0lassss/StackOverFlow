package com.chirkevich.nikola.data;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.internet.model.answer.AnswerItemsRemoteResponse;
import com.chirkevich.nikola.data.internet.model.sites.SitesResponse;
import com.chirkevich.nikola.data.internet.model.user.me.ProfileResponseEnvelop;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.functions.Consumer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static String URL = "http://api.stackexchange.com/2.2/";
    public static String AUTHENTIFICATE_URL = "https://stackoverflow.com/";


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.chirkevich.nikola.data.test", appContext.getPackageName());
    }

    @Test
    public void testGetAnswers() throws Exception {
        StackOverFlowService stackOverFlowService = buildService(buildRetrofit(URL));
        stackOverFlowService.getAnswers(null,
                null,
                null,
                null,
                "desc",
                "activity",
                null,
                null,
                "stackoverflow")
                .subscribe(this::onGetAnswers, this::onLoadError);
    }

    @Test
    public void testGetSites() throws Exception {
        StackOverFlowService stackOverFlowService = buildService(buildRetrofit(URL));
        stackOverFlowService.getSites(1, 2).doOnSuccess(new Consumer<SitesResponse>() {
            @Override
            public void accept(SitesResponse site) throws Exception {
                assertNotNull(site);
            }
        })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        assertNull(throwable);
                    }
                }).subscribe();
    }


    @Test
    public void getProfile() throws Exception {
        StackOverFlowService stackOverFlowService = buildService(buildRetrofit(URL));
        stackOverFlowService.me("desc", "reputation","stackoverflow", "MRBwP1Dx8nE0d0txAZxJqg))").doOnError(t -> {
            Log.d("", "");
        }).doOnSuccess(new Consumer<ProfileResponseEnvelop>() {
            @Override
            public void accept(ProfileResponseEnvelop profileResponse) throws Exception {
                Log.d("", "");
            }
        }).subscribe();
    }

//    @Test
//    public void authenticate() throws Exception {
//        StackOverFlowService stackOverFlowService = buildService(buildRetrofit(AUTHENTIFICATE_URL));
//        stackOverFlowService.authentificate("12838", "read_inbox", "https://com.chirkevich.nikola.assistant", null)
//                .subscribe(this::onAuthenticate, this::onLoadErrorAuthenticate);
//    }

    public void onAuthenticate(String string) {
        Log.d("", "");
    }

    public void onLoadErrorAuthenticate(Throwable throwable) {
        Log.d("", "");
    }


    private void onGetAnswers(AnswerItemsRemoteResponse answerItemsRemote) {
        assertNotNull(answerItemsRemote);
    }

    private void onLoadError(Throwable t) {
        assertNull(t);
    }

    private StackOverFlowService buildService(Retrofit retrofit) {
        return retrofit.create(StackOverFlowService.class);
    }

    private Retrofit buildRetrofit(String url) {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
//        httpClient.addInterceptor(logging);
//        httpClient.addNetworkInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Response response = chain.proceed(chain.request());
//                return null;
//            }
//        });

        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
