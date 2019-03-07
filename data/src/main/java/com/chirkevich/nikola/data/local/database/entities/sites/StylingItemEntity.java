package com.chirkevich.nikola.data.local.database.entities.sites;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "stylings",
        foreignKeys = {
                @ForeignKey(entity = SiteItemEntity.class,
                        parentColumns = "localId",
                        childColumns = "siteItemId",
                        onDelete = CASCADE)
        })

public class StylingItemEntity {

    @PrimaryKey(autoGenerate = true)
    private long localId;

    private long siteItemId;

    private String tagBackgroundColor;

    private String tagForegroundColor;

    private String linkColor;

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public long getSiteItemId() {
        return siteItemId;
    }

    public void setSiteItemId(long siteItemId) {
        this.siteItemId = siteItemId;
    }

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
