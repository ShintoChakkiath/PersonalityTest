package com.shilpa.sparkNetwork;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.shilpa.sparkNetwork.repository.model.Question;
import com.shilpa.sparkNetwork.repository.model.SparkNetworkData;
import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;
import com.shilpa.sparkNetwork.ui.QuestionsList.QuestionListViewModel;
import com.shilpa.sparkNetwork.ui.SelectCategory.SelectCategoryViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class SelectCategoryActivityViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private GetPersonalityDataServerAPI mAPI;

    @Mock
    private Application mApp;

    private SelectCategoryViewModel mViewModel;
    private QuestionListViewModel questionListViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mViewModel = new SelectCategoryViewModel(mApp, mAPI);
        questionListViewModel = new QuestionListViewModel(mApp,mAPI);
    }

    @Test
    public void selectCategory_whenEmptyResult() {

        MutableLiveData<SparkNetworkData> sparkNetworkDataMutableLiveData = new MutableLiveData<>();
        sparkNetworkDataMutableLiveData.setValue(new SparkNetworkData());

        when(mAPI.getSparkNetworkData()).thenReturn(sparkNetworkDataMutableLiveData);

        assertNotNull(mViewModel.getCategory());
        assertNotNull(questionListViewModel.getQuestionsList());
    }

    @Test
    public void selectCategory_whenValidResult()
    {
        MutableLiveData<SparkNetworkData> sparkNetworkDataMutableLiveData = new MutableLiveData<>();
        SparkNetworkData sparkNetworkData = new SparkNetworkData();

        List<String> categories = new ArrayList<>();

        categories.add("hard_fact");
        categories.add("passion");
        categories.add("lifestyle");
        sparkNetworkData.setCategories(categories);

        List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setCategory("hard_fact");
        question.setQuestion("What is your gender");
        questions.add(question);

        sparkNetworkData.setQuestions(questions);

        sparkNetworkDataMutableLiveData.setValue(sparkNetworkData);

        when(mAPI.getSparkNetworkData()).thenReturn(sparkNetworkDataMutableLiveData);

        assertNotNull(mViewModel.getCategory());
        assertNotNull(questionListViewModel.getQuestionsList());

    }

    @After
    public void tearDown() throws Exception {
    }
}