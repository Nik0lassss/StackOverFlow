package com.chirkevich.nikola.stackoverflow.ui.main_page;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MainPageView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showPage(int pageNum);

}
