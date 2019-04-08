package com.shilpa.sparkNetwork;

import android.app.Application;

import com.shilpa.sparkNetwork.repository.local.PersonalityDatabase;

public class PersonalityDataApp extends Application {
    private static PersonalityDataApp app;
    PersonalityDatabase personalityDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        personalityDatabase = PersonalityDatabase.getInstance(getApplicationContext());
    }

    public PersonalityDatabase getDataBase()
    {
        return personalityDatabase;
    }

    public static PersonalityDataApp getApp() {
        return app;
    }
}
