package com.chirkevich.nikola.data.local.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseManager {

    private static final String DB_NAME = "app_database";

    private AppDatabase appDatabase;

    public DatabaseManager(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
