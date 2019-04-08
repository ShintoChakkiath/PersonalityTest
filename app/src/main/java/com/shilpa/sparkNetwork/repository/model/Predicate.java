
package com.shilpa.sparkNetwork.repository.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Predicate {

    @SerializedName("exactEquals")
    @Expose
    private List<String> exactEquals = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Predicate() {
    }

    /**
     * 
     * @param exactEquals
     */
    public Predicate(List<String> exactEquals) {
        super();
        this.exactEquals = exactEquals;
    }

    public List<String> getExactEquals() {
        return exactEquals;
    }

    public void setExactEquals(List<String> exactEquals) {
        this.exactEquals = exactEquals;
    }

}
