package com.shilpa.sparkNetwork.ui.SelectCategory;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;
import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;

public class SelectCategoryViewModel extends AndroidViewModel {

    GetPersonalityDataServerAPI api;

    public SelectCategoryViewModel(@NonNull Application application, GetPersonalityDataServerAPI mapi) {
        super(application);
        this.api = mapi;
    }

    public LiveData<SparkNetworkData> getCategory()
    {
        return this.api.getSparkNetworkData();
    }
}
