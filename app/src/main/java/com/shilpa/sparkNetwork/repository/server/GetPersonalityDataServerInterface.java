package com.shilpa.sparkNetwork.repository.server;

import android.arch.lifecycle.LiveData;

import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;

import java.util.List;

public interface GetPersonalityDataServerInterface {
    LiveData<SparkNetworkData> getSparkNetworkData();
}
