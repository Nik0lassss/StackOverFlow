
package com.chirkevich.nikola.data.internet.model.sites;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteItemResponse {

    @SerializedName("aliases")
    @Expose
    private List<String> aliases = null;
    @SerializedName("styling")
    @Expose
    private StylingResponse styling;
    @SerializedName("related_sites")
    @Expose
    private List<RelatedSiteResponse> relatedSites = null;
    @SerializedName("markdown_extensions")
    @Expose
    private List<String> markdownExtensions = null;
    @SerializedName("launch_date")
    @Expose
    private Integer launchDate;
    @SerializedName("open_beta_date")
    @Expose
    private Integer openBetaDate;
    @SerializedName("site_state")
    @Expose
    private String siteState;
    @SerializedName("high_resolution_icon_url")
    @Expose
    private String highResolutionIconUrl;
    @SerializedName("favicon_url")
    @Expose
    private String faviconUrl;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("audience")
    @Expose
    private String audience;
    @SerializedName("site_url")
    @Expose
    private String siteUrl;
    @SerializedName("api_site_parameter")
    @Expose
    private String apiSiteParameter;
    @SerializedName("logo_url")
    @Expose
    private String logoUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("site_type")
    @Expose
    private String siteType;
    @SerializedName("twitter_account")
    @Expose
    private String twitterAccount;

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public StylingResponse getStyling() {
        return styling;
    }

    public void setStyling(StylingResponse styling) {
        this.styling = styling;
    }

    public List<RelatedSiteResponse> getRelatedSites() {
        return relatedSites;
    }

    public void setRelatedSites(List<RelatedSiteResponse> relatedSites) {
        this.relatedSites = relatedSites;
    }

    public List<String> getMarkdownExtensions() {
        return markdownExtensions;
    }

    public void setMarkdownExtensions(List<String> markdownExtensions) {
        this.markdownExtensions = markdownExtensions;
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
