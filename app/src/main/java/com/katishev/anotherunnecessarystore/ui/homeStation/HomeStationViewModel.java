package com.katishev.anotherunnecessarystore.ui.homeStation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeStationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeStationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}