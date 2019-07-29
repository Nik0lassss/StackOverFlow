package com.chirkevich.nikola.stackoverflow.ui.sites_page;


import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.buisness.user.IUserInteractor;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.state.LoadingState;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageDataSource;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.listeners.RetryCallback;
import com.chirkevich.nikola.stackoverflow.utils.SiteDataSourceFilter;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

@InjectViewState
public class SitePagePresenter extends MvpPresenter<SitePageView> implements RetryCallback {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    private SitePageInteractor sitePageInteractor;
    private IUserInteractor userInteractor;
    private LiveData<PagedList<SiteItem>> siteItemsPagedList;
    private SiteDataSourceFilter siteDataSourceFilter;
    private Scheduler scheduler;

    public SitePagePresenter(SitePageInteractor sitePageInteractor,
                             IUserInteractor userInteractor,
                             LiveData<PagedList<SiteItem>> siteItemsPagedList,
                             SiteDataSourceFilter siteDataSourceFilter,
                             Scheduler scheduler) {
        this.sitePageInteractor = sitePageInteractor;
        this.userInteractor = userInteractor;
        this.siteItemsPagedList = siteItemsPagedList;
        this.siteDataSourceFilter = siteDataSourceFilter;
        this.scheduler = scheduler;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showSites(siteItemsPagedList);
//        getViewState().updateLoadingState(LoadingState.LOADING);
//        getViewState().updateLoadingState(LoadingState.LOADED);
        sitePageInteractor.getLoadingState().observeOn(scheduler).subscribe(loadingState -> getViewState().updateLoadingState(loadingState), t -> {
            Log.d("", "");
        });
    }


    public void onSearchTextChange(CharSequence charSequence) {
        siteDataSourceFilter.setText(charSequence.toString());

        if (siteItemsPagedList.getValue() != null)
            siteItemsPagedList.getValue().getDataSource().invalidate();
    }


    private void onLoadSitesError(Throwable t) {
        getViewState().showLoadSitesError();
    }

    @Override
    public void retry() {
        if (siteItemsPagedList.getValue() != null) {
            SitePageDataSource sitePageDataSource = (SitePageDataSource) siteItemsPagedList.getValue().getDataSource();
            sitePageDataSource.retryFailed();
        }
    }
}
