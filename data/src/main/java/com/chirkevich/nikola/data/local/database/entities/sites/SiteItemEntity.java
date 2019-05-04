package com.chirkevich.nikola.data.local.database.entities.sites;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "siteItems",
        foreignKeys = {
                @ForeignKey(entity = SiteEntity.class,
                        parentColumns = "localId",
                        childColumns = "siteId",
                        onDelete = CASCADE)
        }
)

public class SiteItemEntity {
    @PrimaryKey(autoGenerate = true)
    private long localId;

    private long siteId;

    private Integer launchDate;

    private Integer openBetaDate;

    private String siteState;

    private String highResolutionIconUrl;

    private String faviconUrl;

    private String iconUrl;

    private String audience;

    private String siteUrl;

    private String apiSiteParameter;

    private String logoUrl;

    private String name;

    private String siteType;

    private String twitterAccount;

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public Integer getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Integer launchDate) {
        this.launchDate = launchDate;
    }

    public Integer getOpenBetaDate() {
        return openBetaDate;
    }

    public void setOpenBetaDate(Integer openBetaDate) {
        this.openBetaDate = openBetaDate;
    }

    public String getSiteState() {
        return siteState;
    }

    public void setSiteState(String siteState) {
        this.siteState = siteState;
    }

    public String getHighResolutionIconUrl() {
        return highResolutionIconUrl;
    }

    public void setHighResolutionIconUrl(String highResolutionIconUrl) {
        this.highResolutionIconUrl = highResolutionIconUrl;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
}
