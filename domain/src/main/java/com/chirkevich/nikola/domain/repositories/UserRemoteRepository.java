package com.chirkevich.nikola.domain.repositories;


import com.chirkevich.nikola.domain.models.user.Profile;

import java.util.List;

import io.reactivex.Single;

public interface UserRemoteRepository {

    Single<List<Profile>> getProfile(String accessToken, String key);
}
