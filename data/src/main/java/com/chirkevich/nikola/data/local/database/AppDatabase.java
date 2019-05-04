package com.chirkevich.nikola.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.chirkevich.nikola.data.local.database.dao.site.SiteDao;
import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDao;
import com.chirkevich.nikola.data.local.database.entities.sites.SiteEntity;
import com.chirkevich.nikola.data.local.database.entities.sites.SiteItemEntity;

@Database(entities = {SiteEntity.class, SiteItemEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SiteDao siteDao();

    public abstract SiteItemDao siteItemDao();

}
