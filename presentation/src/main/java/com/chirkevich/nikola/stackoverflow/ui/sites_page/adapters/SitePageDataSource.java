package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.chirkevich.nikola.domain.buisness.site_page.SitePageInteractor;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.stackoverflow.utils.SiteDataSourceFilter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class SitePageDataSource extends PageKeyedDataSource<Integer, SiteItem> {

    private SitePageInteractor sitePageInteractor;
    private SiteDataSourceFilter siteDataSourceFilter;


    public SitePageDataSource(SitePageInteractor sitePageInteractor, SiteDataSourceFilter siteDataSourceFilter) {
        this.sitePageInteractor = sitePageInteractor;
        this.siteDataSourceFilter = siteDataSourceFilter;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, SiteItem> callback) {

        int currentPage = 1;
        int nextPage = currentPage + 1;
        sitePageInteractor.getSites(currentPage, params.requestedLoadSize)
                .doOnSuccess(site -> callback.onResult(site.getItems(), null, nextPage))
                .subscribe();
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SiteItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SiteItem> callback) {
        int currentPage = params.key;
        int nextPage = currentPage + 1;
        sitePageInteractor.getSites(currentPage, params.requestedLoadSize)
                .doOnSuccess(site -> callback.onResult(site.getItems(), nextPage))
                .subscribe();
    }
}
