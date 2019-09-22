package com.example.bicroy_copy_d.NewAddsPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.bicroy_copy_d.Activity.New_adds_Details_1;
import com.example.bicroy_copy_d.NewAddsPage.Adapter.NewAddsRecyclerAdapter;
import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;
import com.example.bicroy_copy_d.NewAddsPage.ViewModel.NewAddsViewModel;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;

import java.util.ArrayList;
import java.util.List;

public class NewAddActivity extends AppCompatActivity implements ItemClickListner {

    private RecyclerView newAddRecyclerView;
    private NewAddsRecyclerAdapter addsRecyclerAdapter;
    private NewAddsViewModel viewModel;
    private List<CetagoryModel> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add);

        Toolbar myToolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        newAddRecyclerView=findViewById(R.id.new_add_recycler_view);
        viewModel= ViewModelProviders.of(this).get(NewAddsViewModel.class);
        newAddRecyclerView.setHasFixedSize(true);
        newAddRecyclerView.setLayoutManager(new GridLayoutManager(NewAddActivity.this,2));
        viewModel.getCetagoryItem().observe(this, new Observer<List<CetagoryModel>>() {
            @Override
            public void onChanged(List<CetagoryModel> cetagoryModels) {
                if (cetagoryModels !=null){
                    data.addAll(cetagoryModels);
                    addsRecyclerAdapter=new NewAddsRecyclerAdapter(NewAddActivity.this,NewAddActivity.this,data);
                    newAddRecyclerView.setAdapter(addsRecyclerAdapter);
                }
            }
        });



    }

    @Override
    public void itemClick(int position) {
        startActivity(new Intent(NewAddActivity.this, New_adds_Details_1.class));
    }
}
