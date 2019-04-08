
package com.shilpa.sparkNetwork.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Range {

    @SerializedName("from")
    @Expose
    private int from;
    @SerializedName("to")
    @Expose
    private int to;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Range() {
    }

    /**
     * 
     * @param to
     * @param from
     */
    public Range(int from, int to) {
        super();
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

}
