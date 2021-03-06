package com.chirkevich.nikola.stackoverflow;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.chirkevich.nikola.stackoverflow.di.app.AppComponent;
import com.chirkevich.nikola.stackoverflow.di.app.AppModule;
import com.chirkevich.nikola.stackoverflow.di.app.DaggerAppComponent;

import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPagePresenter;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.SitePagePresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import java.util.function.Supplier;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    SitePagePresenter sitePagePresenter;

    BehaviorSubject<String> bs = BehaviorSubject.create();

    @Before
    public void setUp() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();
        MainPagePresenter mainPagePresenter = appComponent.authorizedComponent().provideMainPageComponent().provideMainPagePresenter();


    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.chirkevich.nikola.stackoverflow", appContext.getPackageName());
    }

    @Test
    public void syncSitesTest() {
        nextString(1);
        Completable.complete()
                .andThen(getVal())
                .subscribe(s -> {
                    Log.d("", "");
                });
        nextString(2);
        nextString(3);

    }

    Observable<String> getVal() {
        return bs;
    }

    void nextString(int val) {

        bs.onNext("test " + val);
    }


}
