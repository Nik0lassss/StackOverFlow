package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.wrappers.SiteItemWrapper;

public class SiteViewHolder extends RecyclerView.ViewHolder {
    private SiteItemWrapper siteItemWrapper;

    public SiteViewHolder(View itemView) {
        super(itemView);
        siteItemWrapper = new SiteItemWrapper(itemView);
    }

    public void bind(SiteItem siteItem) {
        siteItemWrapper.bind(siteItem);
    }
}
