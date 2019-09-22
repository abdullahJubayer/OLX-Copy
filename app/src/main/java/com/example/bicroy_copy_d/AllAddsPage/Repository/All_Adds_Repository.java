package com.example.bicroy_copy_d.AllAddsPage.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.Network.ApiService;
import com.example.bicroy_copy_d.Network.NetworkCall;
import com.example.bicroy_copy_d.Network.ResponsCallBack;

import java.util.List;


public class All_Adds_Repository {

    private List<Model> allAddsList;
    private ApiService apiService;

    public All_Adds_Repository() {
        apiService = new NetworkCall();
    }

    public MutableLiveData<List<Model>> getSingleCetagory(String queryString) {

        final MutableLiveData<List<Model>> list = new MutableLiveData<>();
        apiService.getSingleCetagoryAdds("https://us-central1-olxc-4ae72.cloudfunctions.net/getData", "name", new ResponsCallBack<List<Model>>() {
            @Override
            public void Success(List<Model> data) {
                list.setValue(data);
            }

            @Override
            public void Failed(Throwable t) {
                list.setValue(null);
            }
        });
        return list;
    }
}
