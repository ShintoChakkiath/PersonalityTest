package com.shilpa.sparkNetwork.ui.SelectCategory;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shilpa.sparkNetwork.R;
import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.ui.QuestionsList.QuestionsListActivity;

import java.util.List;

public class SelectCategoryAdapter extends RecyclerView.Adapter<SelectCategoryAdapter.CategoryName> {

    private Context context;
    private List<String> categoryNamelist;
    private List<Question> questionList;
    private String categoryName;

    public SelectCategoryAdapter(Context context, List<String> categoryList, List<Question> questionList) {
        this.context = context;
        this.categoryNamelist = categoryList;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public CategoryName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_category_row_view, parent, false);
        return new SelectCategoryAdapter.CategoryName(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryName holder, final int position) {
        categoryName = categoryNamelist.get(position);
        holder.CategoryNametextView.setText(categoryName);

    }

    @Override
    public int getItemCount() {
        return categoryNamelist.size();
    }

    public class CategoryName extends RecyclerView.ViewHolder {
        public TextView CategoryNametextView;

        public CategoryName(View view) {
            super(view);
            CategoryNametextView = view.findViewById(R.id.category_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, QuestionsListActivity.class);
                    intent.putExtra("CategoryName", categoryNamelist.get(getAdapterPosition()));

                    context.startActivity(intent);
                }
            });

        }
    }

}

