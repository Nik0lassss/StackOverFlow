package com.chirkevich.nikola.stackoverflow.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.main_page.MainPageActivity;
import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPageActivity;
import com.chirkevich.nikola.stackoverflow.ui.start_page.StartPagePresenter;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {


    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return Components.getAppComponent().unAuthorizedComponent().provideSplashScreenComponent().provideSplashScreenPresenter();
    }

    @InjectPresenter
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        Intent intent = new Intent(this, MainPageActivity.class).addFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
//        Completable.complete()
//                .delay(1, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnComplete(() -> startActivity(intent))
//                .subscribe();

    }

    @Override
    public void goToMainScreen() {
        startActivity(MainPageActivity.getIntent(this)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK));
    }

    @Override
    public void goToStartPageActitivty() {
        startActivity(StartPageActivity.getIntent(this)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK));
    }
}
