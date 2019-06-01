package com.chirkevich.nikola.stackoverflow.ui.login_page;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface LoginPageView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void loadUrl(String redirectUrl);
}
