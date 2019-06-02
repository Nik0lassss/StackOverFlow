package com.chirkevich.nikola.stackoverflow.ui.sites_page;


import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageDataSource;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

@InjectViewState
public class SitePagePresenter extends MvpPresenter<SitePageView> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SitePageInteractor sitePageInteractor;
    private PagedList<SiteItem> siteItemsPagedList;
    private Scheduler scheduler;

    public SitePagePresenter(SitePageInteractor sitePageInteractor,
                             PagedList<SiteItem> siteItemsPagedList,
                             Scheduler scheduler) {
        this.sitePageInteractor = sitePageInteractor;
        this.siteItemsPagedList = siteItemsPagedList;
        this.scheduler = scheduler;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showSites(siteItemsPagedList);
    }


    private void onLoadSitesError(Throwable t) {
        getViewState().showLoadSitesError();
    }
}
