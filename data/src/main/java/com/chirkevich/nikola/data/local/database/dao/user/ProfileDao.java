package com.chirkevich.nikola.data.local.database.dao.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.chirkevich.nikola.data.local.database.entities.user.ProfileEntity;
import com.chirkevich.nikola.domain.models.user.Profile;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProfileDao {

    @Insert
    long insertProfile(ProfileEntity profileEntity);

    @Query("SELECT * FROM Profiles")
    List<ProfileEntity> getProfiles();

    @Query("SELECT * FROM Profiles WHERE localId=:localId")
    List<ProfileEntity> getProfiles(Integer localId);

}
