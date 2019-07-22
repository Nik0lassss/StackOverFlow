package com.chirkevich.nikola.stackoverflow.ui.login_page;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface LoginPageView extends MvpView {

    String RETRY_BTN_TAG = "retry_btn";
    String WEB_VIEW_TAG = "web_view_btn";

    @StateStrategyType(AddToEndSingleStrategy.class)
    void loadUrl(String redirectUrl);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMainScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showErrorToast(String msg);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = WEB_VIEW_TAG)
    void hideWebView();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = WEB_VIEW_TAG)
    void showWebView();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = RETRY_BTN_TAG)
    void showRetryBtn();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = RETRY_BTN_TAG)
    void hideRetryBtn();
}
