package com.shilpa.sparkNetwork.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shilpa.sparkNetwork.repository.local.PersonalityData;

import java.util.List;

public class SavedPersonalityDataList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent != null)
        {
            List<PersonalityData> personalityDataList = intent.getParcelableArrayListExtra("RetrievedData");
            for(int i = 0 ; i < personalityDataList.size(); i++)
            {
                String question = personalityDataList.get(i).getQuestion();
                String option = personalityDataList.get(i).getOption();
            }

        }
    }
}
