package com.shilpa.sparkNetwork.ui.QuestionsList;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;

public class QuestionListViewModelFactory implements ViewModelProvider.Factory {

    private final Application mApp;
    private GetPersonalityDataServerAPI mApi;

    public QuestionListViewModelFactory(Application app) {
        mApp = app;
        mApi = new GetPersonalityDataServerAPI();
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(QuestionListViewModel.class)) {
            return (T) new QuestionListViewModel(mApp,mApi);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
