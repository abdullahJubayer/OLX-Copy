package com.example.bicroy_copy_d.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bicroy_copy_d.AllAddsPage.Adapter.All_adds_recycler_adapter;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;

import java.util.ArrayList;

public class MyAddsList extends AppCompatActivity implements ItemClickListner {

    RecyclerView my_adds_recycler_view;
    ArrayList<Model> list=new ArrayList<>();
    All_adds_recycler_adapter adds_recycler_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_adds_list);

        my_adds_recycler_view=findViewById(R.id.myAdds_recycler_view);
        my_adds_recycler_view.setHasFixedSize(true);
        my_adds_recycler_view.setLayoutManager(new LinearLayoutManager(this));



    }


    @Override
    public void itemClick(int position) {

    }
}
