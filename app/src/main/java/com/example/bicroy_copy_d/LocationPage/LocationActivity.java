package com.example.bicroy_copy_d.LocationPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bicroy_copy_d.HomePage.Home_page;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.LocationPage.ViewModel.LocationActivityViewModel;

public class LocationActivity extends AppCompatActivity {

    private ListView listView;
    private ImageView myCurrentLocatio_icon;
    private LocationActivityViewModel viewModel;
    private TextView myLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        viewModel= ViewModelProviders.of(this).get(LocationActivityViewModel.class);
        myCurrentLocatio_icon = findViewById(R.id.location_icon);
        listView = findViewById(R.id.location_list_view);
        myLocation=findViewById(R.id.location_text);

        listView.setAdapter(viewModel.getLocationNameAdapter());
        myCurrentLocatio_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location=viewModel.getMyCurrentLocation(LocationActivity.this);
                if (location != null){
                    myLocation.setText(location);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(LocationActivity.this, Home_page.class);
                intent.putExtra("location",viewModel.getLocationNameAdapter().getItem(i));
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
