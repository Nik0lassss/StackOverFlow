package com.chirkevich.nikola.stackoverflow.ui.main_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.di.Components;
import com.chirkevich.nikola.stackoverflow.ui.main_page.adapters.MainPageViewPagerAdapter;
import com.chirkevich.nikola.stackoverflow.ui.main_page.listeners.BottomMenuSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainPageActivity extends MvpAppCompatActivity implements MainPageView {

    @BindView(R.id.main_page_vp)
    ViewPager mainPageVp;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNv;

    private BottomMenuSelectListener bottomMenuSelectListener;
    private MainPageViewPagerAdapter mainPageViewPagerAdapter;


    @ProvidePresenter
    MainPagePresenter provideMainPagePresenter() {
        return Components.getAppComponent().authorizedComponent().provideMainPageComponent().provideMainPagePresenter();
    }

    @InjectPresenter
    MainPagePresenter mainPagePresenter;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainPageActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);
        ButterKnife.bind(this);
        setUpAdapters();
        setUpListener();
        setUpBottomNavigation();
    }

    @Override
    public void showPage(int pageNum) {
        mainPageVp.setCurrentItem(pageNum);
    }

    private void setUpAdapters() {
        mainPageViewPagerAdapter = new MainPageViewPagerAdapter(getSupportFragmentManager());
        mainPageVp.setAdapter(mainPageViewPagerAdapter);
    }

    private void setUpListener() {
        bottomMenuSelectListener = new BottomMenuSelectListener(this::onSelectBottomMenuItem);
    }

    private void setUpBottomNavigation() {
        bottomNv.setOnNavigationItemSelectedListener(bottomMenuSelectListener);
    }

    private void onSelectBottomMenuItem(MenuItem menuItem) {
        mainPagePresenter.onPageSelect(menuItem);
    }

}
