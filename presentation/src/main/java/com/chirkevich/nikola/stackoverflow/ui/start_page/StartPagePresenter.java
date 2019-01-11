package com.chirkevich.nikola.stackoverflow.ui.start_page;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractor;
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
    private AuthentificationInteractor authentificationInteractor;

    public StartPagePresenter(
            AuthentificationInteractor authentificationInteractor,
            Scheduler scheduler) {
        this.authentificationInteractor = authentificationInteractor;
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
//        answerRemoteRepository.getAnswers(null,
//                null,
//                null,
//                null,
//                "desc",
//                "activity",
//                null,
//                null,
//                "stackoverflow")
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSuccess(this::onLoadAnswers)
//                .doOnError(this::onLoadAnswersError)
//                .subscribe();

        authentificationInteractor.login()
                .subscribe();
//        loginRepository.login("12838", "read_inbox", "https://com.chirkevich.nikola.assistant", null)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();
    }

    public void onAuthenticate(String token) {
        authentificationInteractor.saveToken(token)
                .andThen(authentificationInteractor.getToken())
                .doOnSuccess(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("","");
                    }
                })
                .subscribe();
    }

    public void onLoadErrorAuthenticate(Throwable throwable) {
        Log.d("", "");
    }

    public void onLoadAnswersError(Throwable throwable) {
        Log.d("", "");
    }

    private void onLoadAnswers(Items items) {
        Log.d("", "");
    }

}
