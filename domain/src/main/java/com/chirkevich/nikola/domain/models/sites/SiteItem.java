
package com.chirkevich.nikola.domain.models.sites;


import java.util.List;

public class SiteItem {

    private List<String> aliases = null;

    private Styling styling;


    private List<RelatedSite> relatedSites = null;

    private List<String> markdownExtensions = null;

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

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public Styling getStyling() {
        return styling;
    }

    public void setStyling(Styling styling) {
        this.styling = styling;
    }

    public List<RelatedSite> getRelatedSites() {
        return relatedSites;
    }

    public void setRelatedSites(List<RelatedSite> relatedSites) {
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
