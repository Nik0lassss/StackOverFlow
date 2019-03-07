package com.chirkevich.nikola.stackoverflow.ui.main_page.listeners;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class BottomMenuSelectListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private OnSelectBottomMenuListener onSelectBottomMenuListener;

    public BottomMenuSelectListener(OnSelectBottomMenuListener onSelectBottomMenuListener) {
        this.onSelectBottomMenuListener = onSelectBottomMenuListener;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        onSelectBottomMenuListener.onSelectBottomMenu(item);
        return true;
    }

    public interface OnSelectBottomMenuListener {
        void onSelectBottomMenu(MenuItem menuItem);
    }
}
