package com.example.xaxaxakaton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    Button[] button;
    GoogleMap map;
    EditText editText;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        str = "";
        button = new Button[3];
        markers = new Marker[3][7];
        button[0] = (Button) findViewById(R.id.button);
        button[1] = (Button) findViewById(R.id.button3);
        button[2] = (Button) findViewById(R.id.button4);
        editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                str = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int ii, int i1, int i2) {
                for(int i = 0; i < 3; i++) for(int j = 0; j < 7; j++){
                    if(charSequence.toString().equals(markers[i][j].getTitle())){
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(markers[i][j].getPosition(), 25));

                        for(int  k = 0; k < 3; k++){
                            if(i == k){
                                button[k].setBackgroundColor(Color.BLUE);
                                button[k].setTextColor(Color.WHITE);
                            }
                            else{
                                button[k].setBackgroundColor(Color.WHITE);
                                button[k].setTextColor(Color.BLACK);
                            }
                            for(int l = 0; l < 6; l++) {
                                if (k == i) {
                                    markers[k][l].setVisible(true);
                                    continue;
                                }
                                markers[k][l].setVisible(false);
                            }
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        /*for(int i = 0; i < 3; i++) for(int j = 0; j < 7; j++){
            if(editText.getText().toString() == markers[i][j].getTitle()){
                map.moveCamera(CameraUpdateFactory.newLatLng(markers[i][j].getPosition()));
            }
        }*/

        button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button[1].setBackgroundColor(Color.WHITE);
                button[1].setTextColor(Color.BLACK);
                button[0].setBackgroundColor(Color.BLUE);
                button[0].setTextColor(Color.WHITE);
                button[2].setBackgroundColor(Color.WHITE);
                button[2].setTextColor(Color.BLACK);
                for(int i = 0; i < 6; i++){
                    markers[0][i].setVisible(true);
                }
                for(int  i = 1; i < 3; i++) for(int j = 0; j < 6; j++){
                    markers[i][j].setVisible(false);
                }
            }
        });

        button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button[0].setBackgroundColor(Color.WHITE);
                button[0].setTextColor(Color.BLACK);
                button[1].setBackgroundColor(Color.BLUE);
                button[1].setTextColor(Color.WHITE);
                button[2].setBackgroundColor(Color.WHITE);
                button[2].setTextColor(Color.BLACK);
                for(int i = 0; i < 6; i++){
                    markers[1][i].setVisible(true);
                }
                for(int  i = 0; i < 3; i++) for(int j = 0; j < 6; j++){
                    if(i == 1) break;
                    markers[i][j].setVisible(false);
                }
            }
        });
        button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button[0].setBackgroundColor(Color.WHITE);
                button[0].setTextColor(Color.BLACK);
                button[2].setBackgroundColor(Color.BLUE);
                button[2].setTextColor(Color.WHITE);
                button[1].setBackgroundColor(Color.WHITE);
                button[1].setTextColor(Color.BLACK);
                for(int i = 0; i < 6; i++){
                    markers[2][i].setVisible(true);
                }
                for(int  i = 0; i < 3; i++) for(int j = 0; j < 6; j++){
                    if(i == 2) break;
                    markers[i][j].setVisible(false);
                }
            }
        });
    }

    public Marker NewMap(GoogleMap map ,double CoardX, double CoardY, String name){
        LatLng newMarker = new LatLng(CoardX, CoardY);
        return map.addMarker(new MarkerOptions().position(newMarker).title(name));
    }

    private Marker[][] markers;

        @Override
        public void onMapReady(GoogleMap googleMap) {
            map =googleMap;
            LatLng SurguShip = new LatLng( 61.239918, 73.410864);
            map.addMarker(new MarkerOptions() .position(SurguShip).title("Surgu"));
            map.moveCamera(CameraUpdateFactory.newLatLng(SurguShip));
            map.setMinZoomPreference(15);
            map.setMaxZoomPreference(30);
            markers[0][0] = NewMap(map, 61.240214, 73.410560, "121");
            markers[0][1] = NewMap(map, 61.240439, 73.410597, "119");
            markers[0][2] = NewMap(map, 61.240415, 73.410578, "124");
            markers[0][3] = NewMap(map, 61.240378, 73.410688, "125");
            markers[0][4] = NewMap(map, 61.240277, 73.410699, "120");
            markers[0][5] = NewMap(map, 61.240238, 73.410645, "122");
            markers[0][6] = NewMap(map, 61.24019, 73.410743, "123");
            markers[1][0] = NewMap(map, 61.240275, 73.410685, "221");
            markers[1][1] = NewMap(map, 61.240283, 73.410547, "219");
            markers[1][2] = NewMap(map, 61.240208, 73.410553, "224");
            markers[1][3] = NewMap(map, 61.240327, 73.410699, "Паспортный стол 89222535913 83462762971 Перерыв: 12:00-13:00 Выходной: Суббота, Воскресенье");
            markers[1][4] = NewMap(map, 61.240209, 73.410785, "220");
            markers[1][5] = NewMap(map, 61.240452, 73.410598, "222");
            markers[1][6] = NewMap(map, 61.240463, 73.410604, "223");
            markers[2][0] = NewMap(map, 61.240233, 73.410766, "345");
            markers[2][1] = NewMap(map, 61.240140, 73.410766, "344");
            markers[2][2] = NewMap(map, 61.240200, 73.410630, "343");
            markers[2][3] = NewMap(map, 61.240302, 73.410694, "342");
            markers[2][4] = NewMap(map, 61.240267, 73.410697, "341");
            markers[2][5] = NewMap(map, 61.240320, 73.410679, "340");
            markers[2][6] = NewMap(map, 61.240353, 73.410669, "339");

            for(int j = 0; j < 3; j++) for(int i = 0; i < 7; i++){
                markers[j][i].setVisible(false);
            }
        }


}

