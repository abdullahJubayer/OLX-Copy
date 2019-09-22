package com.example.bicroy_copy_d.HomePage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.bicroy_copy_d.AllAddsPage.All_Adds;
import com.example.bicroy_copy_d.ChatListPage.ChatListActivity;
import com.example.bicroy_copy_d.LocationPage.LocationActivity;
import com.example.bicroy_copy_d.Activity.MyAddsList;
import com.example.bicroy_copy_d.NewAddsPage.NewAddActivity;
import com.example.bicroy_copy_d.HomePage.Adapter.HomePageProductAdapter;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.HomePage.ViewModel.HomePageViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Home_page extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ItemClickListner, View.OnClickListener {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView homeRecyclerview;
    private LinearLayoutCompat locationLayout,car_layout,bike_layout,mobile_layout;
    private TextView locationTxt;
    private HomePageViewModel homePageViewModel;
    private List<Model> adds=new ArrayList<>();
    private HomePageProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        homePageViewModel= ViewModelProviders.of(this).get(HomePageViewModel.class);
        locationLayout=findViewById(R.id.home_location_id);
        locationTxt=findViewById(R.id.home_activity_location_id);
        car_layout=findViewById(R.id.home_activity_car_id);
        bike_layout=findViewById(R.id.home_activity_bike_id);
        mobile_layout=findViewById(R.id.home_activity_MobilePhone_id);

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        homeRecyclerview=findViewById(R.id.home_recycler_view);
        homeRecyclerview.setHasFixedSize(true);
        homeRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        locationLayout.setOnClickListener(this);
        homePageViewModel.productAdapter().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                if (models != null){
                    adds.addAll(models);
                    adapter=new HomePageProductAdapter(Home_page.this,adds,Home_page.this);
                    homeRecyclerview.setAdapter(adapter);
                }
            }
        });

        locationTxt.setText(homePageViewModel.getCurrentLocation());
        car_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_page.this,All_Adds.class).putExtra("query","Car"));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_menu_id:
                break;
            case R.id.camera_menu_id:
                startActivity(new Intent(Home_page.this, NewAddActivity.class));
                break;
            case R.id.message_menu_id:
                startActivity(new Intent(Home_page.this, ChatListActivity.class));
                break;
            case R.id.my_adds_menu_id:
                startActivity(new Intent(Home_page.this, MyAddsList.class));
                break;
        }
        return true;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if (resultCode==RESULT_OK){
                if (data != null){
                    String location=data.getStringExtra("location");
                    homePageViewModel.setCurrentLocation(location);
                    locationTxt.setText(homePageViewModel.getCurrentLocation());
                }
            }
        }
    }

    @Override
    public void itemClick(int position) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_location_id:
                startActivityForResult(new Intent(Home_page.this, LocationActivity.class),1);
                break;
            case R.id.home_activity_car_id:
                startActivity(new Intent(Home_page.this, All_Adds.class).putExtra("title","Car"));
                break;
            case R.id.home_activity_bike_id:
                startActivity(new Intent(Home_page.this,All_Adds.class).putExtra("title","Bike"));
                break;
            case R.id.home_activity_MobilePhone_id:
                startActivity(new Intent(Home_page.this,All_Adds.class).putExtra("title","Mobile"));
                break;
        }
    }
}
