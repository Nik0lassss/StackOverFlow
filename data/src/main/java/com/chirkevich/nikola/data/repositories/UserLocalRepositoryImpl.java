package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.local.database.dao.user.ProfileDataSource;
import com.chirkevich.nikola.domain.models.user.Profile;
import com.chirkevich.nikola.domain.repositories.UserLocalRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

public class UserLocalRepositoryImpl implements UserLocalRepository {


    private ProfileDataSource profileDataSource;
    private Scheduler scheduler;

    public UserLocalRepositoryImpl(ProfileDataSource profileDataSource, Scheduler scheduler) {
        this.profileDataSource = profileDataSource;
        this.scheduler = scheduler;
    }

    @Override
    public Completable saveProfiles(List<Profile> profileList) {
        return Completable.fromRunnable(() -> profileDataSource.insertProfiles(profileList))
                .subscribeOn(scheduler);
    }

    @Override
    public Single<List<Profile>> getProfiles() {
        return Single.fromCallable(() -> profileDataSource.getAllProfiles())
                .subscribeOn(scheduler);
    }
}
