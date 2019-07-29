package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractorImpl;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.utils.SiteDataSourceFilter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class SitePageDataSource extends PageKeyedDataSource<Integer, SiteItem> {

    private SitePageInteractorImpl sitePageInteractor;
    private SiteDataSourceFilter siteDataSourceFilter;
    private Single<List<SiteItem>> retry;
    private Retrible retrible;


    public SitePageDataSource(SitePageInteractorImpl sitePageInteractor, SiteDataSourceFilter siteDataSourceFilter) {
        this.sitePageInteractor = sitePageInteractor;
        this.siteDataSourceFilter = siteDataSourceFilter;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, SiteItem> callback) {

        int currentPage = 0;
        int nextPage = currentPage + params.requestedLoadSize;
        retry = sitePageInteractor.getSites(currentPage, params.requestedLoadSize, siteDataSourceFilter.getText())
                .doOnSuccess(sites -> callback.onResult(sites, null, nextPage));
        retry.subscribe();
//        sitePageInteractor.getSites(currentPage, params.requestedLoadSize)
//                .doOnSuccess(sites -> callback.onResult(sites, null, nextPage))
//                .subscribe();

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SiteItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SiteItem> callback) {
        int currentPage = params.key;
        int nextPage = currentPage + params.requestedLoadSize;
//        retrible = new Retry(sitePageInteractor, currentPage, nextPage, params, callback);
//        retrible.load();
        retry = sitePageInteractor.getSites(currentPage, params.requestedLoadSize, siteDataSourceFilter.getText())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(sites -> callback.onResult(sites, nextPage));
//
        retry.subscribe();
//        sitePageInteractor.getSites(currentPage, params.requestedLoadSize)
//                .doOnSuccess(sites -> callback.onResult(sites, nextPage))
//                .subscribe();
    }

    interface Retrible {
        void load();
    }

    class Retry implements Retrible {
        SitePageInteractor sitePageInteractor;
        int currentPage;
        int nextPage;
        LoadParams<Integer> params;
        @NonNull
        LoadCallback<Integer, SiteItem> callback;

        public Retry(SitePageInteractor sitePageInteractor, int currentPage, int nextPage, LoadParams<Integer> params, @NonNull LoadCallback<Integer, SiteItem> callback) {
            this.sitePageInteractor = sitePageInteractor;
            this.currentPage = currentPage;
            this.nextPage = nextPage;
            this.params = params;
            this.callback = callback;
        }

        @Override
        public void load() {
//            sitePageInteractor.getSites(currentPage, params.requestedLoadSize).doOnSuccess(sites -> callback.onResult(sites, nextPage)).subscribe();
        }
    }

    public void retryFailed() {
//        retrible.load();
        retry.subscribe();
    }
}
