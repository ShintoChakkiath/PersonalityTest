package com.shilpa.sparkNetwork.ui.QuestionsList;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;
import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;

public class QuestionListViewModel extends AndroidViewModel {

    GetPersonalityDataServerAPI mApi;

    public QuestionListViewModel(@NonNull Application application, GetPersonalityDataServerAPI api) {
        super(application);
        mApi = api;
    }
    public LiveData<SparkNetworkData> getQuestionsList()
    {
        return mApi.getSparkNetworkData();
    }


}
