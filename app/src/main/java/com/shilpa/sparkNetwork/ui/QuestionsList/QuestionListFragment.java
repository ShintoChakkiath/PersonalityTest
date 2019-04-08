package com.shilpa.sparkNetwork.ui.QuestionsList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shilpa.sparkNetwork.R;
import com.shilpa.sparkNetwork.repository.local.PersonalityData;
import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;

import java.util.ArrayList;
import java.util.List;

public class QuestionListFragment extends Fragment {

    private TextView questionTv;
    private RadioGroup radioGroup;
    private RadioGroup mRadiogrp;
    private String question;
    private ArrayList<String> optionsList;
    private PersonalityData mPersonalityData;
    private GetPersonalityDataServerAPI mApi;

    public static QuestionListFragment newInstance(int position, Question question) {

        QuestionListFragment questionListFragment = new QuestionListFragment();
        Bundle bundle = new Bundle();

        bundle.putString("Question", question.getQuestion());

        List<String> options = question.getQuestionType().getOptions();
        bundle.putStringArrayList("Options", (ArrayList<String>) options);

        bundle.putInt("FragmentPos", position);

        questionListFragment.setArguments(bundle);
        return questionListFragment;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View swipeView = inflater.inflate(R.layout.question_list_fragment, container, false);
        questionTv = swipeView.findViewById(R.id.question);
        radioGroup = swipeView.findViewById(R.id.radiogroup);
        mPersonalityData = new PersonalityData();

        mApi = new GetPersonalityDataServerAPI();

        if (savedInstanceState == null) {

            Bundle bundle = getArguments();

            question = bundle.getString("Question");
            optionsList = bundle.getStringArrayList("Options");
        } else {
            question = savedInstanceState.getString("Question");
            optionsList = savedInstanceState.getStringArrayList("Options");
        }

        questionTv.setText(question);
        addRadioButtonOptions(swipeView, optionsList);
        return swipeView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            outState.putString("Question", bundle.getString("Question"));
            outState.putStringArrayList("Options", bundle.getStringArrayList("Options"));
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void addRadioButtonOptions(final View view, ArrayList<String> optionsList) {
        for (int row = 0; row < 1; row++) {

            mRadiogrp = new RadioGroup(getContext());
            mRadiogrp.setOrientation(LinearLayout.VERTICAL);

            for (int i = 0; i < optionsList.size(); i++) {
                RadioButton rdbtn = new RadioButton(getContext());
                rdbtn.setId(View.generateViewId());
                rdbtn.setText(optionsList.get(i));
                mRadiogrp.addView(rdbtn);
            }

            radioGroup.addView(mRadiogrp);

            mRadiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int mRadiobtnId = group.getCheckedRadioButtonId();
                    RadioButton selectedOptions = (RadioButton) view.findViewById(mRadiobtnId);
                    Log.d("Selected  value is", selectedOptions.getText().toString());
                    Toast.makeText(getContext(), "Option is saved!", Toast.LENGTH_SHORT).show();
                    mPersonalityData.setQuestion(question);
                    mPersonalityData.setOption(selectedOptions.getText().toString());
                    mApi.saveOptions(mPersonalityData);

                }
            });
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
