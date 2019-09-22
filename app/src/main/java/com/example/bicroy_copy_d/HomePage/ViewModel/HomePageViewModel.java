package com.example.bicroy_copy_d.HomePage.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.HomePage.Repository.HomePageRepository;

import java.util.List;

public class HomePageViewModel extends AndroidViewModel {
    private HomePageRepository repository;
    private String currentLocation;
    private Application application;
    private MutableLiveData<List<Model>> adds;


    public HomePageViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        repository=new HomePageRepository();
    }
    public MutableLiveData<List<Model>> productAdapter(){
        if (adds==null) {
            adds = repository.getAdds();
        }
            return adds;
    }

    public String getCurrentLocation() {
        if (currentLocation == null){
            currentLocation="Dhaka";
        }
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

}
