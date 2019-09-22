package com.example.bicroy_copy_d.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bicroy_copy_d.LocationPage.LocationActivity;
import com.example.bicroy_copy_d.R;

public class New_adds_Details_2 extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_adds__details_2);

        textView=findViewById(R.id.new_adds_details_2_locationBTN);
        button=findViewById(R.id.new_adds_details_2_imageBTN);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(New_adds_Details_2.this, LocationActivity.class),1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if (resultCode==RESULT_OK){
                if (data != null){
                    String location=data.getStringExtra("location");
                    textView.setText(location);
                }
            }
        }
    }
}
