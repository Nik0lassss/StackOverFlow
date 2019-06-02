package com.chirkevich.nikola.stackoverflow.ui.sites_page;


import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
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
import com.chirkevich.nikola.stackoverflow.utils.SiteDataSourceFilter;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

@InjectViewState
public class SitePagePresenter extends MvpPresenter<SitePageView> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SitePageInteractor sitePageInteractor;
    private LiveData<PagedList<SiteItem>> siteItemsPagedList;
    private SiteDataSourceFilter siteDataSourceFilter;
    private Scheduler scheduler;

    public SitePagePresenter(SitePageInteractor sitePageInteractor,
                             LiveData<PagedList<SiteItem>> siteItemsPagedList,
                             SiteDataSourceFilter siteDataSourceFilter,
                             Scheduler scheduler) {
        this.sitePageInteractor = sitePageInteractor;
        this.siteItemsPagedList = siteItemsPagedList;
        this.siteDataSourceFilter = siteDataSourceFilter;
        this.scheduler = scheduler;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showSites(siteItemsPagedList);
    }

    public void onSearchTextChange(CharSequence charSequence) {
        siteDataSourceFilter.setText(charSequence.toString());

        if (siteItemsPagedList.getValue() != null)
             siteItemsPagedList.getValue().getDataSource().invalidate();
    }

    private void onLoadSitesError(Throwable t) {
        getViewState().showLoadSitesError();
    }
}
