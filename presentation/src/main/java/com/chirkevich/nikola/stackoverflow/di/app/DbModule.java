package com.chirkevich.nikola.stackoverflow.di.app;


import android.content.Context;
import android.support.annotation.NonNull;

import com.chirkevich.nikola.data.local.database.AppDatabase;
import com.chirkevich.nikola.data.local.database.DatabaseManager;

import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDao;
import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDataSource;
import com.chirkevich.nikola.data.local.database.dao.user.BadgeDao;
import com.chirkevich.nikola.data.local.database.dao.user.BadgeDataSource;
import com.chirkevich.nikola.data.local.database.dao.user.ProfileDao;
import com.chirkevich.nikola.data.local.database.dao.user.ProfileDataSource;
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
    SiteItemDataSource provideSiteItemDataSource(SiteItemDao siteItemDao, AppDatabase appDatabase) {
        return new SiteItemDataSource(siteItemDao,appDatabase);
    }


    @Provides
    @NonNull
    @Singleton
    BadgeDao provideBadgeDao(AppDatabase appDatabase) {
        return appDatabase.badgeDao();
    }

    @Provides
    @NonNull
    @Singleton
    BadgeDataSource provideBadgeDataSource(BadgeDao badgeDao) {
        return new BadgeDataSource(badgeDao);
    }

    @Provides
    @NonNull
    @Singleton
    ProfileDao provideProfileDao(AppDatabase appDatabase) {
        return appDatabase.profileDao();
    }


    @Provides
    @NonNull
    @Singleton
    ProfileDataSource profileProfileDataSource(ProfileDao profileDao, BadgeDataSource badgeDataSource) {
        return new ProfileDataSource(profileDao, badgeDataSource);
    }

}
