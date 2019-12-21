package com.example.xaxaxakaton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {


    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            map =googleMap;
            LatLng SurguShip = new LatLng( 61.239918, 73.410864);
            map.addMarker(new MarkerOptions() .position(SurguShip).title("Surgu"));
            map.moveCamera(CameraUpdateFactory.newLatLng(SurguShip));
            map.setMinZoomPreference(15);
            map.setMaxZoomPreference(30);
        }


}

