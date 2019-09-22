package com.example.bicroy_copy_d.Network;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;

import java.util.List;

public interface ApiService {
     void getTopAdds(String url, ResponsCallBack<List<Model>> callBack);
     void getSingleCetagoryAdds(String url,String name,ResponsCallBack<List<Model>> callBack);
     void getCetagory(String url, ResponsCallBack<List<CetagoryModel>> callBack);
}
