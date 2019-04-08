package com.shilpa.sparkNetwork.repository.local;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PersonalityDataLocalAPI {

    private final PersonalityDataDao mPersonalityDataDao;
    private MutableLiveData<PersonalityData> mData;
    private MutableLiveData<List<PersonalityData>> mRetrievedList;

    private Executor databaseExecutor;

    public PersonalityDataLocalAPI(@NonNull PersonalityDataDao personalityDataDao, MutableLiveData<PersonalityData> data) {
        mPersonalityDataDao = personalityDataDao;
        mData = data;
        mRetrievedList = new MutableLiveData<List<PersonalityData>>();
        databaseExecutor = Executors.newSingleThreadExecutor();
    }


    public void saveOptionToDatabase(final PersonalityData personalityData) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mPersonalityDataDao.insert(personalityData);
            }
        };
        databaseExecutor.execute(runnable);
    }

    public LiveData<List<PersonalityData>> retrievePersonalityDataFromDatabase() {
       Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<PersonalityData> mPersonalityDataList = mPersonalityDataDao.getPersonalityData();

                if(mPersonalityDataList!=null) {
                    mRetrievedList.postValue(mPersonalityDataList);
                }
            }
        };

        databaseExecutor.execute(runnable);
        return mRetrievedList;

    }



}
