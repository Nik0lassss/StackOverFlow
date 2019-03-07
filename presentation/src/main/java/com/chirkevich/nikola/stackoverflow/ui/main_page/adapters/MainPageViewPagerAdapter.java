package com.chirkevich.nikola.stackoverflow.ui.main_page.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chirkevich.nikola.stackoverflow.ui.sites_page.SitesPageFragment;

public class MainPageViewPagerAdapter extends FragmentStatePagerAdapter {

    private int NUM_PAGES = 3;


    public MainPageViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SitesPageFragment();
            default:
                return new SitesPageFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
