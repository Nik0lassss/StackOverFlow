package com.chirkevich.nikola.domain.buisness.user;

import com.chirkevich.nikola.domain.models.user.Profile;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IUserInteractor {

    Single<List<Profile>> loadProfile();

    Completable saveProfiles(List<Profile> profiles);

    Single<List<Profile>> getProfiles();

    Single<List<Profile>> syncAndGetProfiles();

    Completable syncProfiles();

}
