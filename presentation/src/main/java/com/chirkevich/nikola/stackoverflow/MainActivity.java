package com.chirkevich.nikola.stackoverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


public class MainActivity extends AppCompatActivity {

    public static String URL = "http://api.stackexchange.com/2.2/";
    public static String AUTHENTIFICATE_URL = "https://stackoverflow.com/";

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        webView = (WebView) findViewById(R.id.web_view);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webView.addJavascriptInterface(new JavaScriptInterface(), "PhoneCallback");
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//                if(url.contains("code"))
//                {
//                    Log.d("","");
//                    return true;
//                }
//                return false;
//            }
//        });

//        StackOverFlowService stackOverFlowService = buildService(buildRetrofit(AUTHENTIFICATE_URL));
//        stackOverFlowService.authentificate("12838",
//                "read_inbox",
//                "https://com.chirkevich.nikola.assistant",
//                null)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::onAuthenticate, this::onLoadErrorAuthenticate);
    }


//    private Retrofit buildRetrofit(String url) {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//// set your desired log level
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//// add your other interceptors …
//// add logging as last interceptor
//        httpClient.addInterceptor(logging);
//        httpClient.addNetworkInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//
//
//                new Handler(Looper.getMainLooper()).post(() -> {
//
//                    webView.loadUrl(chain.request().url().toString());
//
//                });
//                Response response = chain.proceed(chain.request());
////                new Handler(Looper.getMainLooper()).post(() -> {
////                    try {
////                        webView.loadData(response.body().string(), "text/html", " charset=UTF-8");
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                });
//
//                return null;
//            }
//        });

//        return new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(httpClient.build())
//                .build();
//
//    }


//    private StackOverFlowService buildService(Retrofit retrofit) {
//        return retrofit.create(StackOverFlowService.class);
//    }
//
//    public void onAuthenticate(String string) {
//        Log.d("", "");
//    }
//
//    public void onLoadErrorAuthenticate(Throwable throwable) {
//        Log.d("", "");
//    }
//
//    private class JavaScriptInterface {
//
//        @JavascriptInterface
//        public void onPhoneConfirmed(String phone) {
////            phoneNumber = phone;
//        }
//    }

}
