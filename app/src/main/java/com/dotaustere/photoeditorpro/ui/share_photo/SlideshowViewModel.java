package com.dotaustere.photoeditorpro.ui.share_photo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share photo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}