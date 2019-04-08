package com.shilpa.sparkNetwork.repository.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.repository.model.QuestionType;
import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;

@Database(entities = {PersonalityData.class},version = 1)
public abstract class PersonalityDatabase extends RoomDatabase {

    private static volatile PersonalityDatabase INSTANCE;

    public static final String DATABASE_NAME = "personalityDB.db";

    public abstract PersonalityDataDao personalityDataDao();

    public static PersonalityDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (PersonalityDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PersonalityDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
