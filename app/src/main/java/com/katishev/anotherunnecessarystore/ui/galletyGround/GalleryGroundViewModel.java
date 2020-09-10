package com.katishev.anotherunnecessarystore.ui.galletyGround;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryGroundViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryGroundViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}