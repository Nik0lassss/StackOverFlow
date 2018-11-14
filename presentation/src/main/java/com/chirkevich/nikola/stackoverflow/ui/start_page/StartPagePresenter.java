package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class StartPagePresenter extends MvpPresenter<StartPageView> {

    private LoginRepository loginRepository;

    public StartPagePresenter(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loginRepository.login("12838", "read_inbox", "https://com.chirkevich.nikola.assistant", null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onAuthenticate, this::onLoadErrorAuthenticate);
    }

    public void onAuthenticate(String string) {
        Log.d("", "");
    }

    public void onLoadErrorAuthenticate(Throwable throwable) {
        Log.d("", "");
    }

}
