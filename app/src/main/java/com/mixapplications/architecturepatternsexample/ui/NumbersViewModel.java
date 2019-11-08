package com.mixapplications.architecturepatternsexample.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mixapplications.architecturepatternsexample.models.NumbersModel;

public class NumbersViewModel extends ViewModel {
    public MutableLiveData<Float> numbersMutableLiveData = new MutableLiveData<>();
    private NumbersModel numbersModel = new NumbersModel();
    public float getFirstNumber(){
        return numbersModel.getFirstNumber();
    }
    public float getSecondNumber(){
        return numbersModel.getSecondNumber();
    }

    public void getDivResult(){
        numbersMutableLiveData.setValue(getFirstNumber() / getSecondNumber());
    }
}
