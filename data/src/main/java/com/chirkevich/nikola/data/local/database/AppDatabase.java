package com.chirkevich.nikola.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDao;
import com.chirkevich.nikola.data.local.database.dao.user.BadgeDao;
import com.chirkevich.nikola.data.local.database.dao.user.ProfileDao;

import com.chirkevich.nikola.data.local.database.entities.sites.SiteItemEntity;
import com.chirkevich.nikola.data.local.database.entities.user.BadgeCountsEntity;
import com.chirkevich.nikola.data.local.database.entities.user.ProfileEntity;

@Database(entities = {
        SiteItemEntity.class,
        ProfileEntity.class,
        BadgeCountsEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SiteItemDao siteItemDao();

    public abstract ProfileDao profileDao();

    public abstract BadgeDao badgeDao();

}
