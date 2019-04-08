package com.shilpa.sparkNetwork;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.shilpa.sparkNetwork.repository.local.PersonalityData;
import com.shilpa.sparkNetwork.repository.local.PersonalityDataDao;
import com.shilpa.sparkNetwork.repository.local.PersonalityDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LocalDatabaseTest {

    private PersonalityDataDao mDao;
    private PersonalityDatabase mDb;
    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getContext();
        mDb = Room.inMemoryDatabaseBuilder(context, PersonalityDatabase.class).build();

        mDao = mDb.personalityDataDao();
    }

    @Test
    public void write_and_read_one_personalityData(){
        PersonalityData mData = new PersonalityData();
        mData.setQuestion("What is your gender?");
        mData.setOption("male");
        mDao.insert(mData);

        List <PersonalityData> data2 = new ArrayList<>();
        data2 =  mDao.getPersonalityData();

        assertEquals(mData.getQuestion(),data2.get(0).getQuestion());

    }

    @Test
    public void write_and_read_more_than_one_personalityData(){

        PersonalityData data1 = new PersonalityData();
        data1.setQuestion("What is your gender?");
        data1.setOption("male");
        mDao.insert(data1);


        PersonalityData data2 = new PersonalityData();
        data2.setQuestion("How imp is your partner's gender?");
        data2.setOption("importnt");
        mDao.insert(data2);


        PersonalityData data3 = new PersonalityData();
        data3.setQuestion("How imp is age of your partner?");
        data3.setOption("not imp");
        mDao.insert(data3);


        PersonalityData data4 = new PersonalityData();
        data4.setQuestion("What is Martial status?");
        data4.setOption("married");
        mDao.insert(data4);


        List <PersonalityData> retrievedData = new ArrayList<>();
        retrievedData =  mDao.getPersonalityData();

        assertEquals(data1.getQuestion(),retrievedData.get(0).getQuestion());
        assertEquals(data1.getOption(),retrievedData.get(0).getOption());

        assertEquals(data2.getQuestion(),retrievedData.get(1).getQuestion());
        assertEquals(data2.getOption(),retrievedData.get(1).getOption());

        assertEquals(data3.getQuestion(),retrievedData.get(2).getQuestion());
        assertEquals(data3.getOption(),retrievedData.get(2).getOption());

        assertEquals(data4.getQuestion(),retrievedData.get(3).getQuestion());
        assertEquals(data4.getOption(),retrievedData.get(3).getOption());

    }
    @After
    public void tearDown() throws Exception {
        mDb.close();
    }
}