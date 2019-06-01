package com.chirkevich.nikola.stackoverflow.di.app;


import android.content.Context;
import android.support.annotation.NonNull;

import com.chirkevich.nikola.data.local.database.AppDatabase;
import com.chirkevich.nikola.data.local.database.DatabaseManager;
import com.chirkevich.nikola.data.local.database.dao.site.SiteDao;
import com.chirkevich.nikola.data.local.database.dao.site.SiteDataSource;
import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDao;
import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDataSource;
import com.chirkevich.nikola.stackoverflow.di.app.SchedulerModule;
import com.chirkevich.nikola.stackoverflow.di.app.authorized.AuthorizedScope;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;


@Module
public class DbModule {

    @Provides
    @NonNull
    @Singleton
    DatabaseManager provideDatabaseManager
            (Context context) {
        return new DatabaseManager(context);
    }

    @Provides
    @NonNull
    @Singleton
    AppDatabase provideAppDatabase(DatabaseManager databaseManager) {
        return databaseManager.getAppDatabase();
    }

    @Provides
    @NonNull
    @Singleton
    SiteItemDao provideSiteItemDao(AppDatabase appDatabase) {
        return appDatabase.siteItemDao();
    }

    @Provides
    @NonNull
    @Singleton
    SiteDao provideSiteDao(AppDatabase appDatabase) {
        return appDatabase.siteDao();
    }

    @Provides
    @NonNull
    @Singleton
    SiteItemDataSource provideSiteItemDataSource(SiteItemDao siteItemDao) {
        return new SiteItemDataSource(siteItemDao);
    }

    @Provides
    @NonNull
    @Singleton
    SiteDataSource provideSiteDataSource(SiteDao siteDao) {
        return new SiteDataSource(siteDao);
    }


}
