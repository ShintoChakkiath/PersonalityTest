package com.shilpa.sparkNetwork.ui;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.shilpa.sparkNetwork.R;
import com.shilpa.sparkNetwork.repository.local.PersonalityData;

import java.util.List;

public class SavedPersonalityDataActivity extends AppCompatActivity {
    private RecyclerView savedDataRv;
    private SavedPersonalityDataAdapter savedPersonalityDataAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_data);

        savedDataRv = findViewById(R.id.saved_data_rv);
        Intent intent = getIntent();
        if (intent != null) {
            List<PersonalityData> personalityDataList = intent.getParcelableArrayListExtra("RetrievedData");
            loadSavedData(personalityDataList);

        }
    }

    private void loadSavedData(List<PersonalityData> personalityDataList) {

        if (!personalityDataList.isEmpty() && personalityDataList != null) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            savedDataRv.setLayoutManager(mLayoutManager);
            savedDataRv.setItemAnimator(new DefaultItemAnimator());
            savedPersonalityDataAdapter = new SavedPersonalityDataAdapter(getApplicationContext(), personalityDataList);
            savedDataRv.setAdapter(savedPersonalityDataAdapter);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"NO DATA IS SAVED !!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
