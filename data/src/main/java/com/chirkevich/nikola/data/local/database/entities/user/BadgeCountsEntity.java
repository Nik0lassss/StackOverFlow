
package com.chirkevich.nikola.data.local.database.entities.user;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "BadgeCounts",
        foreignKeys = {@ForeignKey(entity = ProfileEntity.class,
                parentColumns = "localId",
                childColumns = "localId",
                onDelete = CASCADE)})
public class BadgeCountsEntity {

    @PrimaryKey(autoGenerate = true)
    private long localId;

    private long profileId;

    private Integer bronze;

    private Integer silver;

    private Integer gold;

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

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
