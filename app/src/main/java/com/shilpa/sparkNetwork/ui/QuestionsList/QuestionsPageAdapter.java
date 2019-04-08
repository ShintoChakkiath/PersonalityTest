package com.shilpa.sparkNetwork.ui.QuestionsList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.shilpa.sparkNetwork.repository.model.Question;

import java.util.List;

public class QuestionsPageAdapter extends FragmentStatePagerAdapter {

    private int mQuestionCount;
    private List<Question> mQuestionsList;

    public QuestionsPageAdapter(FragmentManager fm, int questionsCount, List<Question> categorisedQuestions) {
        super(fm);
        mQuestionCount = questionsCount;
        mQuestionsList = categorisedQuestions;
    }

    @Override
    public Fragment getItem(int position) {

        QuestionListFragment questionListFragment = new QuestionListFragment();
        return questionListFragment.newInstance(position, mQuestionsList.get(position));
    }

    @Override
    public int getCount() {
        return mQuestionCount;
    }
}
