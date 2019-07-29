package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.state.LoadingState;
import com.chirkevich.nikola.domain.models.sites.state.NetworkState;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.listeners.RetryCallback;

public class SitePageAdapter extends PagedListAdapter<SiteItem, RecyclerView.ViewHolder> {

    private NetworkState networkState;
    private RetryCallback retryCallback;

    public SitePageAdapter(@NonNull DiffUtil.ItemCallback<SiteItem> diffCallback, RetryCallback retryCallback) {
        super(diffCallback);
        this.retryCallback = retryCallback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case R.layout.site_item:
                return new SiteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.site_item, parent, false));
            case R.layout.network_state_item:
                return new NetworkStateViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.network_state_item, parent, false), retryCallback);
            default:
                throw new IllegalStateException();


        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SiteViewHolder)
            ((SiteViewHolder) holder).bind(getItem(position));

        if (holder instanceof NetworkStateViewHolder)
            ((NetworkStateViewHolder) holder).bind(networkState);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (hasExtraRow() && position == getItemCount() - 1) {
            return R.layout.network_state_item;
        } else return R.layout.site_item;
    }

    public void setLoadingState(NetworkState newNetworkState) {
        NetworkState prevState = networkState;
        boolean hadExtraRow = hasExtraRow();
        networkState = newNetworkState;
        boolean hasExtraRow = hasExtraRow();
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (hasExtraRow && prevState != networkState) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    private boolean hasExtraRow() {
        return networkState != null && networkState.getLoadingState() != LoadingState.LOADED;
    }
}
