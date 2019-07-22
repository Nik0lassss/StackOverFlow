package com.chirkevich.nikola.stackoverflow.ui.splash_screen;

import android.view.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SplashView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToStartPageActitivty();
}
