package com.chirkevich.nikola.data.local.database.entities.sites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "aliases",
        foreignKeys = {
                @ForeignKey(entity = SiteItemEntity.class,
                        parentColumns = "localId",
                        childColumns = "siteItemId",
                        onDelete = CASCADE
                )
        }
)

public class SiteAliasesEntity {

    @PrimaryKey(autoGenerate = true)
    private long localId;

    private long siteItemId;

    private String alias;

}
