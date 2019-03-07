package com.chirkevich.nikola.stackoverflow.ui.start_page;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface StartPageView extends MvpView{


    @StateStrategyType(OneExecutionStateStrategy.class)
    void showLoginScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMainScreen();
}
