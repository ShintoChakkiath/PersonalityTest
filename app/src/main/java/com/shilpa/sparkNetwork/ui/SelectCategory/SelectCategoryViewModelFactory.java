package com.shilpa.sparkNetwork.ui.SelectCategory;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.shilpa.sparkNetwork.repository.server.GetPersonalityDataServerAPI;


public class SelectCategoryViewModelFactory implements ViewModelProvider.Factory {

    private final Application mApp;
    private GetPersonalityDataServerAPI mApi;

    public SelectCategoryViewModelFactory(Application app, GetPersonalityDataServerAPI api) {
        mApp = app;
        this.mApi = api;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SelectCategoryViewModel.class)) {
            return (T) new SelectCategoryViewModel(mApp, mApi);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
