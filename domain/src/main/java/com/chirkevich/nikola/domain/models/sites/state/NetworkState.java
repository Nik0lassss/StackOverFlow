package com.chirkevich.nikola.domain.models.sites.state;

import java.util.Objects;

public class NetworkState {

    private LoadingState loadingState;
    private String msg;

    public NetworkState(LoadingState loadingState, String msg) {
        this.loadingState = loadingState;
        this.msg = msg;
    }

    public NetworkState(LoadingState loadingState) {
        this.loadingState = loadingState;
    }

    public LoadingState getLoadingState() {
        return loadingState;
    }

    public void setLoadingState(LoadingState loadingState) {
        this.loadingState = loadingState;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkState that = (NetworkState) o;
        return getLoadingState() == that.getLoadingState() &&
                Objects.equals(getMsg(), that.getMsg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoadingState(), getMsg());
    }
}
