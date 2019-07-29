package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chirkevich.nikola.domain.models.sites.state.NetworkState;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.listeners.RetryCallback;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.wrappers.NetworkStateItemWrapper;

public class NetworkStateViewHolder extends RecyclerView.ViewHolder {

    private NetworkStateItemWrapper networkStateItemWrapper;

    public NetworkStateViewHolder(View itemView, RetryCallback retryCallback) {
        super(itemView);
        networkStateItemWrapper = new NetworkStateItemWrapper(itemView, retryCallback);
    }

    public void bind(NetworkState networkState) {
        networkStateItemWrapper.bind(networkState);
    }
}
