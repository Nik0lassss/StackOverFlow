package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.internet.model.user.me.ProfileResponseEnvelop;
import com.chirkevich.nikola.data.mappers.user.UserMapper;
import com.chirkevich.nikola.domain.models.user.Profile;
import com.chirkevich.nikola.domain.repositories.UserRemoteRepository;

import org.mapstruct.factory.Mappers;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class UserRemoteRepositoryImpl implements UserRemoteRepository {

    private StackOverFlowService stackOverFlowService;
    private Scheduler scheduler;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    public UserRemoteRepositoryImpl(StackOverFlowService stackOverFlowService, Scheduler scheduler) {
        this.stackOverFlowService = stackOverFlowService;
        this.scheduler = scheduler;
    }

    @Override
    public Single<List<Profile>> getProfile(String accessToken, String key) {
        return stackOverFlowService.me("desc", "reputation", "stackoverflow", accessToken, key)
                .subscribeOn(scheduler)
                .map(ProfileResponseEnvelop::getItems)
                .map(userMapper::toProfiles);
    }
}
