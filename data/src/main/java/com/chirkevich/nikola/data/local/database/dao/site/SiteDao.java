package com.chirkevich.nikola.data.local.database.dao.site;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.chirkevich.nikola.data.local.database.entities.sites.SiteEntity;
import com.chirkevich.nikola.domain.models.sites.Sites;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface SiteDao {

    @Query("SELECT  * FROM SITES")
    Single<List<SiteEntity>> getSites();

    @Insert
    void save(SiteEntity sites);
}
