package com.chirkevich.nikola.stackoverflow.ui.sites_page;

import android.arch.paging.PagedList;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageDataSource;

import java.util.List;

public interface SitePageView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showSites(PagedList<SiteItem> siteItemsPagedList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showLoadSitesError();
}
