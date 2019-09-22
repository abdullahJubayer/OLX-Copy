package com.example.bicroy_copy_d.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bicroy_copy_d.R;

public class New_adds_Details_1 extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_adds__details_1);

        button=findViewById(R.id.new_adds_details_nextBTN);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(New_adds_Details_1.this,New_adds_Details_2.class));
            }
        });
    }
}
