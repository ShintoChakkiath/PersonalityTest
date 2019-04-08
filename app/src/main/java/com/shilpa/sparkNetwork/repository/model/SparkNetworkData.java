
package com.shilpa.sparkNetwork.repository.model;

import android.arch.persistence.room.Entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "sparkNetworkData")
public class SparkNetworkData {

    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SparkNetworkData() {
    }

    /**
     * 
     * @param questions
     * @param categories
     */
    public SparkNetworkData(List<String> categories, List<Question> questions) {
        super();
        this.categories = categories;
        this.questions = questions;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
