package nathaniel.com.immedia;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //Set global variable here
    private GoogleMap mMap;
    private Button btnMap;
    private Button btnSatellite;
    private Button btnHybrid;
    private boolean mapReady=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get the id of a map button and set the value when it is clicked
        btnMap = (Button)findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }
        });

        //Get the id of the settellite button and set the value when it is clicked
        btnSatellite = (Button)findViewById(R.id.btnSatelite);
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        //Get the id of the hybrid button and set the value when it is clicked

        btnHybrid = (Button)findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        //Get the id of the map fragment Async
        MapFragment mapFragment1 = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;

        // Add a marker in johannesburg and move the camera
        LatLng johannesburg = new LatLng(-26.195246, 28.034088);
        CameraPosition target = CameraPosition.builder().target(johannesburg).zoom(14).build();
        mMap.addMarker(new MarkerOptions().position(johannesburg).title("Johannesburg")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.immedia)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(johannesburg));
        //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000,null);

    }
}
