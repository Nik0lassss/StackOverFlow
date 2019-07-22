package com.chirkevich.nikola.data.local.database.dao.user;

import com.chirkevich.nikola.data.local.database.entities.user.ProfileEntity;
import com.chirkevich.nikola.data.mappers.user.UserMapper;
import com.chirkevich.nikola.domain.models.user.BadgeCounts;
import com.chirkevich.nikola.domain.models.user.Profile;

import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class ProfileDataSource {

    private ProfileDao profileDao;
    private BadgeDataSource badgeDataSource;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public ProfileDataSource(ProfileDao profileDao,
                             BadgeDataSource badgeDataSource) {
        this.profileDao = profileDao;
        this.badgeDataSource = badgeDataSource;
    }

    public List<Profile> getAllProfiles()
    {
        List<ProfileEntity> profileEntities = profileDao.getProfiles();
        List<Profile> profiles = new ArrayList<>();
        for (ProfileEntity profileEntity : profileEntities) {
            BadgeCounts badgeCount = badgeDataSource.getBadge(profileEntity.getLocalId());
            Profile profile = userMapper.toProfileFromEntity(profileEntity);
            profile.setBadgeCounts(badgeCount);
            profiles.add(profile);
        }

        return profiles;
    }

    public List<Profile> getProfiles(Integer profileId) {
        List<ProfileEntity> profileEntities = profileDao.getProfiles(profileId);
        List<Profile> profiles = new ArrayList<>();
        for (ProfileEntity profileEntity : profileEntities) {
            BadgeCounts badgeCount = badgeDataSource.getBadge(profileEntity.getLocalId());
            Profile profile = userMapper.toProfileFromEntity(profileEntity);
            profile.setBadgeCounts(badgeCount);
            profiles.add(profile);
        }

        return profiles;
    }

    public void insertProfiles(List<Profile> profiles) {
        for (Profile profile : profiles) {
            ProfileEntity profileEntity = userMapper.toEntityFromPresentation(profile);
            long localId = profileDao.insertProfile(profileEntity);
            if (localId == -1) {
                throw new IllegalStateException("can't insert profile: " + profile.getAccountId());
            }
            badgeDataSource.insertBadge(profile.getBadgeCounts(), localId);
        }
    }


}
