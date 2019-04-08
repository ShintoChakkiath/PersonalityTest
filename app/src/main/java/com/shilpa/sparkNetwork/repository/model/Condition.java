
package com.shilpa.sparkNetwork.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("predicate")
    @Expose
    private Predicate predicate;
    @SerializedName("if_positive")
    @Expose
    private IfPositive ifPositive;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    /**
     * 
     * @param predicate
     * @param ifPositive
     */
    public Condition(Predicate predicate, IfPositive ifPositive) {
        super();
        this.predicate = predicate;
        this.ifPositive = ifPositive;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public IfPositive getIfPositive() {
        return ifPositive;
    }

    public void setIfPositive(IfPositive ifPositive) {
        this.ifPositive = ifPositive;
    }

}
