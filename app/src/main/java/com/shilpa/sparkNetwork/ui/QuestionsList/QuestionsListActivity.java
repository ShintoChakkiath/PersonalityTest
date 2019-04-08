package com.shilpa.sparkNetwork.ui.QuestionsList;

import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.shilpa.sparkNetwork.R;
import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListActivity extends AppCompatActivity{

    ViewPager mViewPager;
    private QuestionsPageAdapter questionsPageAdapter;
    private QuestionListViewModel mViewModel;
    private QuestionListViewModelFactory questionListViewModelFactory;
    private String  category = null;
    private Fragment fragment;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        init();

        category = getIntent().getExtras().getString("CategoryName");

        mViewPager = findViewById(R.id.question_list_view_pager);


        questionListViewModelFactory = new QuestionListViewModelFactory(getApplication());
        mViewModel = ViewModelProviders.of(QuestionsListActivity.this, questionListViewModelFactory).get(QuestionListViewModel.class);

        mViewModel.getQuestionsList().observe(QuestionsListActivity.this, new Observer<SparkNetworkData>() {
            @Override
            public void onChanged(@Nullable SparkNetworkData sparkNetworkData) {

                if (sparkNetworkData.getQuestions().size()>0)
                    loadQuestions(sparkNetworkData.getQuestions(),position);

            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("current_item", 0);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("current_item", mViewPager.getCurrentItem());
    }

    private void init() {

        Toolbar actionbar = findViewById(R.id.toolbar);
        setSupportActionBar(actionbar);
        actionbar.setTitle(R.string.app_name);
        actionbar.setTitleTextColor(Color.WHITE);

    }

    private void loadQuestions(List<Question> questions, int position) {

        List<Question> categorisedQuestions = new ArrayList<Question>();

        for(Question question : questions)
        {
            if(category.equals(question.getCategory()))
            {
              categorisedQuestions.add(question);
            }
        }

        questionsPageAdapter = new QuestionsPageAdapter(getSupportFragmentManager(),categorisedQuestions.size()
                ,categorisedQuestions);
          mViewPager.setAdapter(questionsPageAdapter);
          Log.e("Hello", String.valueOf(position));
        mViewPager.setCurrentItem(position);
    }



}



