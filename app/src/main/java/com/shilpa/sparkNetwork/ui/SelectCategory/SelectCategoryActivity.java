package com.shilpa.sparkNetwork.ui.SelectCategory;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.shilpa.sparkNetwork.R;
import com.shilpa.sparkNetwork.repository.local.PersonalityData;
import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;
import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;
import com.shilpa.sparkNetwork.ui.SavedPersonalityDataList;

import java.util.ArrayList;
import java.util.List;

public class SelectCategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SelectCategoryViewModel selectCategoryViewModel;
    private SelectCategoryViewModelFactory selectCategoryViewModelFactory;
    private SelectCategoryAdapter selectCategoryAdapter;
    private List<String> categoriesList;
    private GetPersonalityDataServerAPI mApi;
    private LiveData<List<PersonalityData>> personalityDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        recyclerView = findViewById(R.id.select_category_rv);
        mApi = new GetPersonalityDataServerAPI();
      //  personalityDataList = new ArrayList<>();

        selectCategoryViewModelFactory = new SelectCategoryViewModelFactory(getApplication(), mApi);
        selectCategoryViewModel = ViewModelProviders.of(SelectCategoryActivity.this, selectCategoryViewModelFactory).get(SelectCategoryViewModel.class);

        selectCategoryViewModel.getCategory().observe(SelectCategoryActivity.this, new Observer<SparkNetworkData>() {

            @Override
            public void onChanged(@Nullable SparkNetworkData sparkNetworkData) {
                categoriesList = sparkNetworkData.getCategories();
                if (categoriesList.size() > 0)
                    loadCategory(categoriesList, sparkNetworkData.getQuestions());

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                personalityDataList =  mApi.retrieveData();
                personalityDataList.observeForever(new Observer<List<PersonalityData>>() {
                    @Override
                    public void onChanged(@Nullable List<PersonalityData> personalityData) {
                        if(personalityData != null) {
                            Intent intent = new Intent(SelectCategoryActivity.this, SavedPersonalityDataList.class);
                            intent.putParcelableArrayListExtra("RetrievedData",(ArrayList) personalityData);
                            startActivity(intent);

//                            Toast.makeText(SelectCategoryActivity.this, personalityData.size(), Toast.LENGTH_SHORT).show();
//                            Snackbar.make(view, String.valueOf(personalityDataList.toString()) + "is saved.", Snackbar.LENGTH_LONG);
                        } else {
                            Snackbar.make(view, "No data is Saved", Snackbar.LENGTH_LONG);
                        }
                    }
                });
            }
        });
    }


    private void loadCategory(List<String> categories, List<Question> questionList) {
        //Pass to adapter
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        selectCategoryAdapter = new SelectCategoryAdapter(getApplicationContext(), categories, questionList);
        recyclerView.setAdapter(selectCategoryAdapter);
    }


}
