
package com.shilpa.sparkNetwork.repository.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "Options")
public class QuestionType {
    @PrimaryKey
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    @SerializedName("condition")
    @Expose
    private Condition condition;

    /**
     * No args constructor for use in serialization
     * 
     */
    public QuestionType() {
    }

    /**
     * 
     * @param condition
     * @param type
     * @param options
     */
    public QuestionType(String type, List<String> options, Condition condition) {
        super();
        this.type = type;
        this.options = options;
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
