package com.example.assignment_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class viewMap extends AppCompatActivity implements OnMapReadyCallback {

    Button buttonBk;

    GoogleMap googleMaps;
    ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
    LatLng colombo= new LatLng(6.9003, 79.8530);
    LatLng jaffna= new LatLng(9.3903659, 80.4031354);
    LatLng gall= new LatLng(6.0341661, 80.2157447);
    LatLng gampaha= new LatLng(7.0920028, 79.9911138);
    LatLng kottawa= new LatLng(6.8411963, 79.9663284);

    String[] name = {"Colombo branch","Jaffna branch", "Gall branch", "Gampaha branch", "Kottawa branch" };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(colombo);
        arrayList.add(jaffna);
        arrayList.add(gall);
        arrayList.add(gampaha);
        arrayList.add(kottawa);



        buttonBk = (Button) findViewById(R.id.button_bk);
        buttonBk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(viewMap.this, MainActivity.class);
                startActivity(intent);
                finish();
            }




        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMaps = googleMap;

        for (int i = 0; i < arrayList.size(); i++) {
            googleMaps.addMarker(new MarkerOptions().position(arrayList.get(i)).title(name[i]));
        }
        LatLng lanka = new LatLng(7.8731, 80.7718);
        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(lanka,8);
        googleMaps.animateCamera(cameraUpdate);

    }

}