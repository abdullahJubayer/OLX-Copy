package com.example.bicroy_copy_d.LocationPage.ViewModel;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class LocationActivityViewModel extends AndroidViewModel {

    private static final String name[] = {"Dhaka", "Barishal", "Chittagong", "Sylhet", "Rajshahi"};
    private FusedLocationProviderClient fusedLocationClient;
    private ArrayAdapter<String> adapter;
    private String city="Location";

    public LocationActivityViewModel(@NonNull Application application) {
        super(application);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(application);
    }

    public ArrayAdapter<String> getLocationNameAdapter() {
        adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, name);
        return adapter;
    }

    public String getMyCurrentLocation(Context context) {
        if (ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            return null;
        } else {
            return getLocation(context);
        }
    }

    private String getLocation(Context context) {

        fusedLocationClient.getLastLocation().addOnSuccessListener((Activity) context, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    city=getAddress(location);
                }
                else {
                    city="Location";
                }
            }
        });

        return city;
    }

    private String getAddress(Location location) {
        Geocoder geocoder=new Geocoder(getApplication(), Locale.getDefault());
        try {
            ArrayList<Address> data = (ArrayList<Address>) geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String city="";
            if (data != null && data.size()>0){
                if (data.get(0).getAdminArea() != null){
                    city=data.get(0).getAdminArea();
                }
            }
            if (city.equals("")){
                return "Location";
            }else {
                return city;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Location";
        }
    }
}
