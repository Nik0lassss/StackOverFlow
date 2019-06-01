
package com.chirkevich.nikola.domain.models.sites;


import java.util.List;

public class Sites {


    private List<SiteItem> items;

    private Boolean hasMore;

    private Integer quotaMax;

    private Integer quotaRemaining;

    public List<SiteItem> getItems() {
        return items;
    }

    public void setItems(List<SiteItem> items) {
        this.items = items;
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
