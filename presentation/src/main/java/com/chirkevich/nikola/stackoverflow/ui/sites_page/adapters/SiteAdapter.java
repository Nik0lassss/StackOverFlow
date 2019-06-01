package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.R;

import java.util.ArrayList;
import java.util.List;

public class SiteAdapter extends RecyclerView.Adapter<SiteViewHolder> {

    private List<SiteItem> siteItems;


    public SiteAdapter() {
        siteItems = new ArrayList<>();
    }

    public SiteAdapter(List<SiteItem> siteItems) {
        this.siteItems = siteItems;
    }

    @NonNull
    @Override
    public SiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SiteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.site_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SiteViewHolder holder, int position) {
        holder.bind(siteItems.get(position));
    }

    @Override
    public int getItemCount() {
        return siteItems.size();
    }

    public void loadItems(List<SiteItem> siteItems) {
        this.siteItems = siteItems;
    }
}
