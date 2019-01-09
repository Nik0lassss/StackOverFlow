package com.chirkevich.nikola.stackoverflow.di.app;


import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class SchedulerModule {

    public static final String IO_SCHEDULER = "io_scheduler";
    public static final String UI_SCHEDULER = "ui_scheduler";
    public static final String DB_SCHEDULER = "db_scheduler";
    public static final String FILE_SCHEDULER = "file_scheduler";
    public static final String SIGNATURE_SCHEDULER = "signature_scheduler";

    @Provides
    @NonNull
    @Named(IO_SCHEDULER)
    @Singleton
    Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @NonNull
    @Named(UI_SCHEDULER)
    @Singleton
    Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @NonNull
    @Named(DB_SCHEDULER)
    @Singleton
    Scheduler provideDBScheduler() {
        return Schedulers.from(Executors.newSingleThreadExecutor());
    }

    @Provides
    @NonNull
    @Named(FILE_SCHEDULER)
    @Singleton
    Scheduler provideFileScheduler() {
        return Schedulers.from(Executors.newSingleThreadExecutor());
    }

}
