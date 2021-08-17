package com.dotaustere.photoeditorpro.ui.rate_photo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rate photo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}