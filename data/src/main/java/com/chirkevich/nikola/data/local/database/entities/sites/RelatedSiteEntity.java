package com.chirkevich.nikola.data.local.database.entities.sites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "relatedSite",
        foreignKeys = {
                @ForeignKey(entity = SiteItemEntity.class,
                        parentColumns = "localId",
                        childColumns = "siteItemId",
                        onDelete = CASCADE)
        }
)

public class RelatedSiteEntity {

    @PrimaryKey(autoGenerate = true)
    private long localId;

    private long siteItemId;

    private String relation;

    private String apiSiteParameter;

    private String siteUrl;

    private String name;


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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
