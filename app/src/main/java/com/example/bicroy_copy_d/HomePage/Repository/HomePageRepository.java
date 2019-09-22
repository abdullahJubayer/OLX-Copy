package com.example.bicroy_copy_d.HomePage.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.Network.NetworkCall;
import com.example.bicroy_copy_d.Network.ResponsCallBack;
import com.example.bicroy_copy_d.Network.ApiService;

import java.util.List;


public class HomePageRepository {
    private ApiService apiService;

    public HomePageRepository(){
        apiService=new NetworkCall();
    }

    public MutableLiveData<List<Model>> getAdds(){
        final MutableLiveData<List<Model>> list=new MutableLiveData<>();
        apiService.getTopAdds("https://us-central1-olxc-4ae72.cloudfunctions.net/getData", new ResponsCallBack<List<Model>>() {
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
