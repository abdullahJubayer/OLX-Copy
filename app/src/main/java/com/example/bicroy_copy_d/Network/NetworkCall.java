package com.example.bicroy_copy_d.Network;

import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;
import com.example.bicroy_copy_d.RetrofitClient.RetrofitClient;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements ApiService {

    private ApiCall call;
    public NetworkCall(){
        call=RetrofitClient.getInstance().create(ApiCall.class);
    }
    @Override
    public void getTopAdds(String url, final ResponsCallBack<List<Model>> callBack) {
        call.getAdds(url).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                callBack.Success(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

    }

    @Override
    public void getSingleCetagoryAdds(String url, String name, final ResponsCallBack<List<Model>> callBack) {
        call.get_SingleCetagoyAdds(url).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                callBack.Success(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getCetagory(String url, final ResponsCallBack<List<CetagoryModel>> callBack) {
        call.getCetagory(url).enqueue(new Callback<List<CetagoryModel>>() {
            @Override
            public void onResponse(Call<List<CetagoryModel>> call, Response<List<CetagoryModel>> response) {
                callBack.Success(response.body());
            }

            @Override
            public void onFailure(Call<List<CetagoryModel>> call, Throwable t) {

            }
        });
    }
}
