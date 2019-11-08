package com.mixapplications.architecturepatternsexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
//import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.mixapplications.architecturepatternsexample.R;
import com.mixapplications.architecturepatternsexample.databinding.ActivityMainBinding;
import com.mixapplications.architecturepatternsexample.models.NumbersModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumbersViewInterface {

    ActivityMainBinding binding;
    NumbersModel numbers;
    NumbersViewModel numbersViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numbersViewModel = ViewModelProviders.of(this).get(NumbersViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setNumbersViewModel(numbersViewModel);
        binding.btnSum.setOnClickListener(this);
        binding.btnSub.setOnClickListener(this);
        numbers = new NumbersModel();
        /*numbersViewModel.numbersMutableLiveData.observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {
                binding.txtResult.setText(String.valueOf(aFloat)); //disabled because using xml Binding (MVVM & LiveData & DataBinding)
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSum:
                //MVC
                //binding.txtResult.setText(numbers.getFirstNumber() + numbers.getSecondNumber()); //disabled because using xml Binding (MVVM & LiveData & DataBinding)
                numbersViewModel.numbersMutableLiveData.postValue(numbers.getFirstNumber() + numbers.getSecondNumber());
                break;
            case R.id.btnSub:
                //MVP
                new NumbersPresenter().subNumbers(this);
                break;
        }
    }

    @Override
    public void onSubListener(float result) {
        //binding.btnSub.setText(result); //disabled because using xml Binding (MVVM & LiveData & DataBinding)
        numbersViewModel.numbersMutableLiveData.postValue(result);
    }
}
