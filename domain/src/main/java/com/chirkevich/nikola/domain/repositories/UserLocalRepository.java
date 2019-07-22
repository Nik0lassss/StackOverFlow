package com.chirkevich.nikola.domain.repositories;

import com.chirkevich.nikola.domain.models.user.Profile;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserLocalRepository {

    Completable saveProfiles(List<Profile> profileList);

    Single<List<Profile>> getProfiles();
}
