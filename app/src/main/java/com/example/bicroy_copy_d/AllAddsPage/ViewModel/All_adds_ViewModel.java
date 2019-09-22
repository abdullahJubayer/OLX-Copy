package com.example.bicroy_copy_d.AllAddsPage.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.AllAddsPage.Repository.All_Adds_Repository;

import java.util.List;

public class All_adds_ViewModel extends AndroidViewModel {

    private MutableLiveData<List<Model>> allAddsData;
    private static All_Adds_Repository repository;

    public All_adds_ViewModel(@NonNull Application application) {
        super(application);
        repository=new All_Adds_Repository();
    }

    public MutableLiveData<List<Model>> getAllAddsAdapter(String query){
        if (allAddsData ==null){
            allAddsData =repository.getSingleCetagory(query);
        }
        return allAddsData;
    }
}
