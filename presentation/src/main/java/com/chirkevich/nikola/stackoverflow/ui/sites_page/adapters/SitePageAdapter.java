package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.R;

public class SitePageAdapter extends PagedListAdapter<SiteItem, SiteViewHolder> {

    public SitePageAdapter(@NonNull DiffUtil.ItemCallback<SiteItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SiteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.site_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SiteViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
