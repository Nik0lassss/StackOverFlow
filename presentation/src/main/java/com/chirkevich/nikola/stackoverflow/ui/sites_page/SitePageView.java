package com.chirkevich.nikola.stackoverflow.ui.sites_page;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.chirkevich.nikola.domain.models.sites.SiteItem;

public interface SitePageView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showSites(LiveData<PagedList<SiteItem>> siteItemsPagedList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showLoadSitesError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void notifyRv(PagedList<SiteItem> siteItemsPagedList);
}
