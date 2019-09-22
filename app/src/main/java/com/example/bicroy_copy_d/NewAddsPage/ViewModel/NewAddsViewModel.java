package com.example.bicroy_copy_d.NewAddsPage.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;
import com.example.bicroy_copy_d.NewAddsPage.Repository.NewAddsRepository;

import java.util.List;

public class NewAddsViewModel  extends AndroidViewModel {

    private MutableLiveData<List<CetagoryModel>> data;
    private NewAddsRepository repository;

    public NewAddsViewModel(@NonNull Application application) {
        super(application);
        repository=new NewAddsRepository();
    }

    public MutableLiveData<List<CetagoryModel>> getCetagoryItem(){
        if (data == null){
            data=repository.getCetagory();
        }

        return data;
    }
}
