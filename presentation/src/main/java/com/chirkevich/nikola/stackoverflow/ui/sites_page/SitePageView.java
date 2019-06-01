package com.chirkevich.nikola.stackoverflow.ui.sites_page;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.chirkevich.nikola.domain.models.sites.SiteItem;

import java.util.List;

public interface SitePageView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showSites(List<SiteItem> siteItems);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showLoadSitesError();
}
