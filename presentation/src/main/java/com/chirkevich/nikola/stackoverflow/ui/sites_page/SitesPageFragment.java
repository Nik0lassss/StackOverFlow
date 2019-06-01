package com.chirkevich.nikola.stackoverflow.ui.sites_page;

import android.arch.lifecycle.ViewModel;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PositionalDataSource;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.SiteAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Component;

public class SitesPageFragment extends MvpAppCompatFragment implements SitePageView {


    @BindView(R.id.sites_rv)
    RecyclerView sitesRv;

    @BindView(R.id.error_msg_tv)
    TextView errorMsgTv;

    @BindView(R.id.retry_btn)
    Button retryBtn;

    private SiteAdapter siteAdapter;


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
        return view;
    }


    @Override
    public void showSites(List<SiteItem> siteItems) {
        showSitesRv();
        siteAdapter.loadItems(siteItems);
        siteAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadSitesError() {
        showErrorViews();
        hideSitesRv();
        errorMsgTv.setText(getString(R.string.error_msg));
    }

    private void loadViews() {
        hideErrorVies();
        sitesRv.setLayoutManager(new LinearLayoutManager(getContext()));
        siteAdapter = new SiteAdapter();
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



}
