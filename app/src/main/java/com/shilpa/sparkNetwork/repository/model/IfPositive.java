
package com.shilpa.sparkNetwork.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IfPositive {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("question_type")
    @Expose
    private QuestionType_ questionType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IfPositive() {
    }

    /**
     * 
     * @param category
     * @param questionType
     * @param question
     */
    public IfPositive(String question, String category, QuestionType_ questionType) {
        super();
        this.question = question;
        this.category = category;
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public QuestionType_ getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType_ questionType) {
        this.questionType = questionType;
    }

}
