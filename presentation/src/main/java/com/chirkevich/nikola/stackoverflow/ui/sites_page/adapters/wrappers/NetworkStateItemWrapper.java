package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.wrappers;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chirkevich.nikola.domain.models.sites.state.LoadingState;
import com.chirkevich.nikola.domain.models.sites.state.NetworkState;
import com.chirkevich.nikola.stackoverflow.R;
import com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.listeners.RetryCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NetworkStateItemWrapper {

    @BindView(R.id.error_msg)
    TextView errorMsgTv;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.retry_btn)
    Button retryBtn;

    private RetryCallback retryCallback;

    public NetworkStateItemWrapper(View view, RetryCallback retryCallback) {
        ButterKnife.bind(this, view);
        this.retryCallback = retryCallback;
        initRetryBtn();
    }

    public void bind(NetworkState networkState) {

        progressBar.setVisibility(toVisibility(networkState.getLoadingState() == LoadingState.LOADING));
        retryBtn.setVisibility(toVisibility(networkState.getLoadingState() == LoadingState.FAILED));
        errorMsgTv.setVisibility(toVisibility(networkState.getMsg() != null));
        errorMsgTv.setText(networkState.getMsg());
    }

    private void initRetryBtn() {
        retryBtn.setOnClickListener(l -> retryCallback.retry());
    }

    private int toVisibility(boolean constraint) {
        if (constraint)
            return View.VISIBLE;
        else return View.GONE;
    }
}
