package com.chirkevich.nikola.data.internet.model.answer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Колян on 22.07.2018.
 */

public class ItemsRemote {

    @SerializedName("items")
    @Expose
    private List<AnswerRemote> answerRemotes = null;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    private Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private Integer quotaRemaining;

    public List<AnswerRemote> getAnswerRemotes() {
        return answerRemotes;
    }

    public void setAnswerRemotes(List<AnswerRemote> answerRemotes) {
        this.answerRemotes = answerRemotes;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

}
