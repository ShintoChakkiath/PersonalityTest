package com.shilpa.sparkNetwork.repository.server;

import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("sparknetworks/coding_exercises_options/master/personality_test/database/personality_test.json")
    Call<SparkNetworkData>getPersonalityData();
}
