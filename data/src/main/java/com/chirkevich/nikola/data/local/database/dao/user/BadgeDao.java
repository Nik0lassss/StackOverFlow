package com.chirkevich.nikola.data.local.database.dao.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.chirkevich.nikola.data.local.database.entities.user.BadgeCountsEntity;
import com.chirkevich.nikola.domain.models.user.BadgeCounts;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface BadgeDao {

    @Insert
    void insert(BadgeCountsEntity badgeCountsEntity);

    @Query("SELECT * FROM BADGECOUNTS")
    List<BadgeCountsEntity> getBadgeEntities();

    @Query("SELECT * FROM BADGECOUNTS WHERE profileId=:profileId")
    List<BadgeCountsEntity> getBadgeEntities(Integer profileId);

    @Query("SELECT * FROM BADGECOUNTS WHERE profileId=:profileId")
    BadgeCountsEntity getBadgeEntitie(long profileId);
}
