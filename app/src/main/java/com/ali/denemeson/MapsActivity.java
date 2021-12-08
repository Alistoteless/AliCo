package com.ali.denemeson;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;

import com.ali.denemeson.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in lat lang and move the camera
        double enlem = this.getIntent().getDoubleExtra("lat", 0);
        double boylam = this.getIntent().getDoubleExtra("lng", 0);
        final LatLng pst = new LatLng(enlem, boylam);
        Marker mrk = mMap.addMarker(new MarkerOptions()
                .position(pst)
                .title("Noktanız")
                .snippet("Enlem:" + enlem + ",Boylam:" + boylam));
        CameraUpdate updatePosition = CameraUpdateFactory.newLatLng(pst);
        CameraUpdate updateZoom = CameraUpdateFactory.zoomTo(9);
        googleMap.moveCamera(updatePosition);
        googleMap.animateCamera(updateZoom);





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
