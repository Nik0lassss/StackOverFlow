package com.chirkevich.nikola.data.local.database.dao.site;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.chirkevich.nikola.data.local.database.entities.sites.SiteItemEntity;
import com.chirkevich.nikola.domain.models.sites.SiteItem;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface SiteItemDao {

    @Query("SELECT  * FROM SITEITEMS")
    List<SiteItemEntity> getSites();

    @Insert
    void save(SiteItemEntity sites);

    @Transaction
    @Query("DELETE FROM SITEITEMS")
    void delete();
}
