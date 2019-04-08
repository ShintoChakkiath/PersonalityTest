package com.shilpa.sparkNetwork.repository.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonalityDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PersonalityData personalityData);

    @Query("SELECT * FROM personalityData")
    List<PersonalityData> getPersonalityData();

}
