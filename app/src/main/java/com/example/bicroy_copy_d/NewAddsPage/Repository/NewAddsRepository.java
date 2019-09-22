package com.example.bicroy_copy_d.NewAddsPage.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.bicroy_copy_d.Network.ApiService;
import com.example.bicroy_copy_d.Network.NetworkCall;
import com.example.bicroy_copy_d.Network.ResponsCallBack;
import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;

import java.util.List;

public class NewAddsRepository {

    private ApiService apiService;

    public NewAddsRepository(){
        apiService=new NetworkCall();
    }

    public MutableLiveData<List<CetagoryModel>> getCetagory(){
        final MutableLiveData<List<CetagoryModel>> list=new MutableLiveData<>();
        apiService.getCetagory("https://us-central1-olxc-4ae72.cloudfunctions.net/getCetgory", new ResponsCallBack<List<CetagoryModel>>() {
            @Override
            public void Success(List<CetagoryModel> data) {
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
