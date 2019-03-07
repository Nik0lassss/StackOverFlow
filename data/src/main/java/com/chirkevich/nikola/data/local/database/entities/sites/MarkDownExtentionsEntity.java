package com.chirkevich.nikola.data.local.database.entities.sites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "markDownExtensions",
        foreignKeys = {
                @ForeignKey(entity = SiteItemEntity.class,
                        parentColumns = "localId",
                        childColumns = "siteItemId",
                        onDelete = CASCADE)
        }
)
public class MarkDownExtentionsEntity {

    @PrimaryKey(autoGenerate = true)
    private long localId;

    private long siteItemId;

    private String markDownExtentions;

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public String getMarkDownExtentions() {
        return markDownExtentions;
    }

    public void setMarkDownExtentions(String markDownExtentions) {
        this.markDownExtentions = markDownExtentions;
    }

    public long getSiteItemId() {
        return siteItemId;
    }

    public void setSiteItemId(long siteItemId) {
        this.siteItemId = siteItemId;
    }
}
