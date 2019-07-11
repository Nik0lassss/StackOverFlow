
package com.chirkevich.nikola.data.internet.model.user.me;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BadgeCountsResponse {

    @SerializedName("bronze")
    @Expose
    private Integer bronze;
    @SerializedName("silver")
    @Expose
    private Integer silver;
    @SerializedName("gold")
    @Expose
    private Integer gold;

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

}
