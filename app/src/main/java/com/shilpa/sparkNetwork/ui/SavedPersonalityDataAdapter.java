package com.shilpa.sparkNetwork.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shilpa.sparkNetwork.R;
import com.shilpa.sparkNetwork.repository.local.PersonalityData;

import java.util.List;

public class SavedPersonalityDataAdapter extends RecyclerView.Adapter<SavedPersonalityDataAdapter.SavedData> {

    private Context context;
    private List<PersonalityData> savedPersonalityDataList;
    private String question;
    private String savedOption;

    public SavedPersonalityDataAdapter(Context context, List<PersonalityData> savedPersonalityDataList) {
        this.context = context;
        this.savedPersonalityDataList = savedPersonalityDataList;
    }
    @NonNull
    @Override
    public SavedData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_data_row_item, parent, false);
        return new SavedPersonalityDataAdapter.SavedData(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedData holder, int position) {
      question = savedPersonalityDataList.get(position).getQuestion();
      savedOption = savedPersonalityDataList.get(position).getOption();
      holder.questionTextview.setText("Question : "+ question);
      holder.optionTextView.setText("Saved option : "+ savedOption);
    }

    @Override
    public int getItemCount() {
        return savedPersonalityDataList.size();
    }

    public class SavedData extends RecyclerView.ViewHolder {
        private TextView questionTextview;
        private TextView optionTextView;

        public SavedData(View view) {
            super(view);
            questionTextview = view.findViewById(R.id.saved_question);
            optionTextView = view.findViewById(R.id.saved_option);

        }
    }

}

