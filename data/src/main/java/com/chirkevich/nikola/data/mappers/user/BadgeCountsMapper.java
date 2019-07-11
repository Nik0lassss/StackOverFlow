package com.chirkevich.nikola.data.mappers.user;

import com.chirkevich.nikola.data.internet.model.user.me.BadgeCountsResponse;
import com.chirkevich.nikola.domain.models.user.BadgeCounts;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface BadgeCountsMapper {
    BadgeCounts toBagdeCount(BadgeCountsResponse badgeCountsResponse);


    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<BadgeCounts> toBadgesCount(List<BadgeCounts> badgeCounts);
}
