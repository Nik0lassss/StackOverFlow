package com.chirkevich.nikola.stackoverflow.ui.main_page;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chirkevich.nikola.domain.buisness.synchronization.SynchronizationInteractor;
import com.chirkevich.nikola.stackoverflow.R;


@InjectViewState
public class MainPagePresenter extends MvpPresenter<MainPageView> {

    private SynchronizationInteractor synchronizationInteractor;

    public MainPagePresenter(SynchronizationInteractor synchronizationInteractor) {
        this.synchronizationInteractor = synchronizationInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onPageSelect(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_sites:
                getViewState().showPage(0);
                break;
            case R.id.action_favorites:
                break;
            case R.id.action_schedules:
                break;
        }
    }
}
