package com.chirkevich.nikola.data.mappers.user;

import com.chirkevich.nikola.data.internet.model.user.me.ProfileResponse;
import com.chirkevich.nikola.domain.models.user.Profile;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface UserMapper {
    Profile toProfile(ProfileResponse profileResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Profile> toProfiles(List<ProfileResponse> profileResponses);
}
