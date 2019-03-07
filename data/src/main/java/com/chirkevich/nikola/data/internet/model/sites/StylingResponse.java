
package com.chirkevich.nikola.data.internet.model.sites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StylingResponse {

    @SerializedName("tag_background_color")
    @Expose
    private String tagBackgroundColor;
    @SerializedName("tag_foreground_color")
    @Expose
    private String tagForegroundColor;
    @SerializedName("link_color")
    @Expose
    private String linkColor;

    public String getTagBackgroundColor() {
        return tagBackgroundColor;
    }

    public void setTagBackgroundColor(String tagBackgroundColor) {
        this.tagBackgroundColor = tagBackgroundColor;
    }

    public String getTagForegroundColor() {
        return tagForegroundColor;
    }

    public void setTagForegroundColor(String tagForegroundColor) {
        this.tagForegroundColor = tagForegroundColor;
    }

    public String getLinkColor() {
        return linkColor;
    }

    public void setLinkColor(String linkColor) {
        this.linkColor = linkColor;
    }

}
