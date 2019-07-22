package com.chirkevich.nikola.data.mappers.user;

import com.chirkevich.nikola.data.internet.model.user.me.ProfileResponse;
import com.chirkevich.nikola.data.internet.model.user.me.ProfileResponseEnvelop;
import com.chirkevich.nikola.data.local.database.entities.user.ProfileEntity;
import com.chirkevich.nikola.domain.models.user.Profile;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(uses = BadgeCountsMapper.class)
public interface UserMapper {
    Profile toProfile(ProfileResponse profileResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Profile> toProfiles(List<ProfileResponse> profileResponses);

    @Mappings({
            @Mapping(target = "badgeCounts", ignore = true)
    })
    Profile toProfileFromEntity(ProfileEntity profileEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Profile> toProfileEntityFromListEntities(List<ProfileEntity> profileEntities);


    ProfileEntity toEntityFromPresentation(Profile profile);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<ProfileEntity> toEntityFromPresentation(List<Profile> profiles);
}
