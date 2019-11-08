package com.mixapplications.architecturepatternsexample.ui;

import com.mixapplications.architecturepatternsexample.models.NumbersModel;

public class NumbersPresenter {
    public void subNumbers(NumbersViewInterface view){
        NumbersModel model = new NumbersModel();
     view.onSubListener(model.getFirstNumber() - model.getSecondNumber());
    }
}
