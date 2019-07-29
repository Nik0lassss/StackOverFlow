package com.chirkevich.nikola.stackoverflow.ui.sites_page;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.state.LoadingState;
import com.chirkevich.nikola.domain.models.sites.state.NetworkState;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SitePageAdapter;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.listeners.RetryCallback;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.functions.Action1;

public class SitesPageFragment extends MvpAppCompatFragment implements SitePageView{


    @BindView(R.id.sites_rv)
    RecyclerView sitesRv;

    @BindView(R.id.error_msg_tv)
    TextView errorMsgTv;

    @BindView(R.id.retry_btn)
    Button retryBtn;

    @BindView(R.id.search_et)
    EditText searchEt;

    @BindView(R.id.load_pb)
    ProgressBar loadPb;

    private SitePageAdapter siteAdapter;

    private Subscription subscription;


    @ProvidePresenter
    SitePagePresenter provideSitePagePtesenter() {
        return Components.getAppComponent().authorizedComponent().provideSitePageComponent().provideSitePagePresenter();
    }


    @InjectPresenter
    SitePagePresenter sitePagePresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sites_page_layout, container, false);
        ButterKnife.bind(this, view);
        loadViews();
        showPb();
        return view;
    }


    @Override
    public void showSites(LiveData<PagedList<SiteItem>> siteItemsPagedList) {

        siteItemsPagedList.observe(this, new Observer<PagedList<SiteItem>>() {
            @Override
            public void onChanged(@Nullable PagedList<SiteItem> siteItems) {
                siteAdapter.submitList(siteItems);
                hidePb();
            }
        });


        setUpSearchEt();
    }

    @Override
    public void showLoadSitesError() {
        showErrorViews();
        hideSitesRv();
        errorMsgTv.setText(getString(R.string.error_msg));
    }

    @Override
    public void notifyRv(PagedList<SiteItem> siteItemsPagedList) {
        siteAdapter.submitList(siteItemsPagedList);
    }

    @Override
    public void showPb() {
        loadPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePb() {
        loadPb.setVisibility(View.GONE);
    }

    @Override
    public void updateLoadingState(NetworkState networkState) {
        siteAdapter.setLoadingState(networkState);
    }

    @Override
    public void onDestroyView() {
        if (subscription != null)
            subscription.unsubscribe();
        super.onDestroyView();
    }


    private void setUpSearchEt() {
        subscription = RxTextView.textChanges(searchEt).subscribe(sitePagePresenter::onSearchTextChange);
    }

    private void loadViews() {
        hideErrorVies();
        sitesRv.setLayoutManager(new LinearLayoutManager(getContext()));
        siteAdapter = new SitePageAdapter(DIFF_CALLBACK, sitePagePresenter::retry);
        sitesRv.setAdapter(siteAdapter);
    }

    private void showSitesRv() {
        sitesRv.setVisibility(View.VISIBLE);
    }

    private void hideSitesRv() {
        sitesRv.setVisibility(View.GONE);
    }

    private void showErrorViews() {
        errorMsgTv.setVisibility(View.VISIBLE);
        retryBtn.setVisibility(View.VISIBLE);
    }

    private void hideErrorVies() {
        errorMsgTv.setVisibility(View.GONE);
        retryBtn.setVisibility(View.GONE);
    }


    private static DiffUtil.ItemCallback<SiteItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<SiteItem>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(SiteItem oldConcert, SiteItem newConcert) {
                    return oldConcert.getName().equals(newConcert.getName());
                }

                @Override
                public boolean areContentsTheSame(SiteItem oldConcert,
                                                  SiteItem newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };


}
