package com.chirkevich.nikola.data.local.database.dao.user;

import com.chirkevich.nikola.data.local.database.entities.user.BadgeCountsEntity;
import com.chirkevich.nikola.data.mappers.user.BadgeCountsMapper;
import com.chirkevich.nikola.domain.models.user.BadgeCounts;

import org.mapstruct.factory.Mappers;

import java.util.List;

public class BadgeDataSource {

    private BadgeDao badgeDao;

    private BadgeCountsMapper badgeCountsMapper = Mappers.getMapper(BadgeCountsMapper.class);

    public BadgeDataSource(BadgeDao badgeDao) {
        this.badgeDao = badgeDao;
    }

    List<BadgeCounts> getAllBadges() {
        return badgeCountsMapper.toBadgesCountFromEntity(badgeDao.getBadgeEntities());
    }

    List<BadgeCounts> getBadges(Integer profileId) {
        return badgeCountsMapper.toBadgesCountFromEntity(badgeDao.getBadgeEntities(profileId));
    }

    BadgeCounts getBadge(long profileId) {
        return badgeCountsMapper.toBadgeCountFromEntity(badgeDao.getBadgeEntitie(profileId));
    }

    void insertBadge(BadgeCounts badgeCounts, long profileId) {
        BadgeCountsEntity badgeCountsEntity = badgeCountsMapper.toEntity(badgeCounts);
        badgeCountsEntity.setProfileId(profileId);
        badgeDao.insert(badgeCountsEntity);
    }
}
