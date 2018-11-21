package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.models.Items;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;
import com.chirkevich.nikola.domain.repositories.LoginRepository;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class StartPagePresenter extends MvpPresenter<StartPageView> {

    private Scheduler scheduler;
    private LoginRepository loginRepository;
    private AnswerRemoteRepository answerRemoteRepository;

    public StartPagePresenter(
            Scheduler scheduler,
            LoginRepository loginRepository,
            AnswerRemoteRepository answerRemoteRepository) {
        this.scheduler = scheduler;
        this.loginRepository = loginRepository;
        this.answerRemoteRepository = answerRemoteRepository;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        answerRemoteRepository.getAnswers(null,
                null,
                null,
                null,
                "desc",
                "activity",
                null,
                null,
                "stackoverflow")
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(this::onLoadAnswers)
                .doOnError(this::onLoadAnswersError)
                .subscribe();

//        loginRepository.login("12838", "read_inbox", "https://com.chirkevich.nikola.assistant", null)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::onAuthenticate, this::onLoadErrorAuthenticate);
    }

    public void onAuthenticate(String string) {
        Log.d("", "");
    }

    public void onLoadErrorAuthenticate(Throwable throwable) {
        Log.d("", "");
    }
    public void onLoadAnswersError(Throwable throwable) {
        Log.d("", "");
    }

    private void onLoadAnswers(Items items)
    {
        Log.d("","");
    }

}
