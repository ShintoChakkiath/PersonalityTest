package com.shilpa.sparkNetwork.repository.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.repository.model.QuestionType;

import java.util.List;

@Entity(tableName = "personalityData")
public class PersonalityData implements Parcelable {

    //private String categories;
    @NonNull
    @PrimaryKey
    private String question;

    private String option;

    public PersonalityData()
    {

    }
    public PersonalityData(@NonNull String question, String option) {
        this.question = question;
        this.option = option;
    }

    //private String questionType;

   // private QuestionType questionType;
   // private List<String> options;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String questions) {
        this.question = questions;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option);

    }
    public PersonalityData(Parcel in)
    {
        question = in.readString();
        option = in.readString();
    }
    public static final Parcelable.Creator<PersonalityData> CREATOR = new Parcelable.Creator<PersonalityData>(){

        @Override
        public PersonalityData createFromParcel(Parcel parcel) {
            return new PersonalityData(parcel);
        }

        @Override
        public PersonalityData[] newArray(int size) {
            return new PersonalityData[0];
        }
    };
}
