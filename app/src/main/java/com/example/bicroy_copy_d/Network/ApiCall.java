package com.example.bicroy_copy_d.Network;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiCall {
    @GET
    Call <List<Model>> getAdds(@Url String url);
    @GET
    Call<List<Model>> get_SingleCetagoyAdds(@Url String url);
    @GET
    Call <List<CetagoryModel>> getCetagory(@Url String url);

}
