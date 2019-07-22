package com.chirkevich.nikola.data.mappers.user;

import com.chirkevich.nikola.data.internet.model.user.me.BadgeCountsResponse;
import com.chirkevich.nikola.data.local.database.entities.user.BadgeCountsEntity;
import com.chirkevich.nikola.domain.models.user.BadgeCounts;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface BadgeCountsMapper {

    BadgeCounts toBagdeCount(BadgeCountsResponse badgeCountsResponse);


    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<BadgeCounts> toBadgesCountFromResponse(List<BadgeCountsResponse> badgeCounts);


    BadgeCountsEntity toEntity(BadgeCounts badgeCounts);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<BadgeCountsEntity> toEntities(List<BadgeCounts> badgeCounts);

    BadgeCounts toBadgeCountFromEntity(BadgeCountsEntity badgeCountsEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<BadgeCounts> toBadgesCountFromEntity(List<BadgeCountsEntity> badgeCountsEntities);

}
