package com.chirkevich.nikola.data.local.database.dao.site;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.chirkevich.nikola.data.local.database.entities.sites.SiteItemEntity;
import com.chirkevich.nikola.domain.models.sites.SiteItem;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface SiteItemDao {

    @Query("SELECT * FROM SITEITEMS")
    Single<List<SiteItemEntity>> getItems();

}
