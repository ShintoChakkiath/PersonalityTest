package com.shilpa.sparkNetwork.repository.server;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;

import com.shilpa.sparkNetwork.PersonalityDataApp;
import com.shilpa.sparkNetwork.repository.local.PersonalityData;
import com.shilpa.sparkNetwork.repository.local.PersonalityDataLocalAPI;
import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPersonalityDataServerAPI implements GetPersonalityDataServerInterface {

    private MutableLiveData<SparkNetworkData> sparkNetworkData;
    private PersonalityDataLocalAPI localAPI;
    private MutableLiveData<PersonalityData> data;
    private MutableLiveData<List<PersonalityData>> mPersonalityDataList;

    public GetPersonalityDataServerAPI() {
        this.sparkNetworkData = new MutableLiveData<SparkNetworkData>();
    }

    @Override
    public LiveData<SparkNetworkData> getSparkNetworkData() {

        final ApiInterface apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        if (apiService != null) {

            apiService.getPersonalityData().enqueue(new Callback<SparkNetworkData>() {
                @Override
                public void onResponse(Call<SparkNetworkData> call, Response<SparkNetworkData> response) {
                    if (isResponseValid(response)) {
                        sparkNetworkData.postValue(response.body());
                    }

                }

                @Override
                public void onFailure(Call<SparkNetworkData> call, Throwable t) {
                    Log.d("GetPersonalityTestData", "OnFailure");
                }
            });
        }
        return sparkNetworkData;
    }

    private boolean isResponseValid(Response<SparkNetworkData> response) {
        if (response.isSuccessful()) {
            if (response.body() != null)
                return true;
        }
        return false;
    }

    public void saveOptions(PersonalityData personalityData) {
        data = new MutableLiveData<>();
        localAPI = new PersonalityDataLocalAPI(PersonalityDataApp.getApp().getDataBase().personalityDataDao(), data);
        localAPI.saveOptionToDatabase(personalityData);
    }

    public LiveData<List<PersonalityData>> retrieveData() {
        mPersonalityDataList = new MutableLiveData<>();
        localAPI = new PersonalityDataLocalAPI(PersonalityDataApp.getApp().getDataBase().personalityDataDao(), data);
        LiveData<List<PersonalityData>> retrievedData = localAPI.retrievePersonalityDataFromDatabase();
        retrievedData.observeForever(new Observer<List<PersonalityData>>() {
            @Override
            public void onChanged(@Nullable List<PersonalityData> personalityData) {
                mPersonalityDataList.postValue(personalityData);
            }
        });
        return mPersonalityDataList;
    }

}
