package com.example.bicroy_copy_d.AllAddsPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bicroy_copy_d.AllAddsPage.Adapter.All_adds_recycler_adapter;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;
import com.example.bicroy_copy_d.AllAddsPage.ViewModel.All_adds_ViewModel;

import java.util.ArrayList;
import java.util.List;

public class All_Adds extends AppCompatActivity implements ItemClickListner {

    private RecyclerView my_adds_recycler_view;
    private ArrayList<Model> list=new ArrayList<>();
    private All_adds_ViewModel all_adds_viewModel;
    private All_adds_recycler_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__adds);

        Toolbar toolbar=findViewById(R.id.my_toolBar);
        String title=getIntent().getStringExtra("query");
        if (title != null){
            toolbar.setTitle(title);
        }

        all_adds_viewModel= ViewModelProviders.of(this).get(All_adds_ViewModel.class);
        my_adds_recycler_view=findViewById(R.id.AllAdds_recycler_view);
        my_adds_recycler_view.setHasFixedSize(true);
        my_adds_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        if (title != null){
            if (title.equals("Car")){
                setAdapter("Car");
            }
            else if (title.equals("Bike")){
                setAdapter("Bike");
            }
            else if (title.equals("Mobile")){
                setAdapter("Mobile");
            }
        }
    }

    private void setAdapter(String query){
        all_adds_viewModel.getAllAddsAdapter(query).observe(All_Adds.this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                if (models != null){
                    list.addAll(models);
                    adapter=new All_adds_recycler_adapter(All_Adds.this,list,All_Adds.this);
                    my_adds_recycler_view.setAdapter(adapter);
                }
            }
        });

    }


    @Override
    public void itemClick(int position) {

    }
}
