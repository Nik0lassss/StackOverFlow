package com.chirkevich.nikola.stackoverflow.ui.sites_page;


import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

@InjectViewState
public class SitePagePresenter extends MvpPresenter<SitePageView> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SitePageInteractor sitePageInteractor;

    private Scheduler scheduler;

    public SitePagePresenter(SitePageInteractor sitePageInteractor, Scheduler scheduler) {
        this.sitePageInteractor = sitePageInteractor;
        this.scheduler = scheduler;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        compositeDisposable.add(sitePageInteractor.getSites(1, 20)
                .observeOn(scheduler)
                .subscribe(this::onLoadSites, this::onLoadSitesError));
    }

    private void onLoadSites(Sites sites) {
        getViewState().showSites(sites.getItems());
    }

    private void onLoadSitesError(Throwable t) {
        getViewState().showLoadSitesError();
    }

    class MyPositionalDataSource extends PageKeyedDataSource<Integer, SiteItem> {


        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {

        }

        @Override
        public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

        }

        @Override
        public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {

        }
    }
}
