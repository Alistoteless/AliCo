package com.ali.denemeson;

import android.Manifest;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ali.denemeson.R;

public class MainActivity extends AbsRuntimePermission {

    private static final int REQUEST_PERMISSION = 10;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageButton donustur = (ImageButton) findViewById(R.id.donustur);
        donustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sayfa1.class);
                startActivity(intent);
            }
        });

        ImageButton olustur = (ImageButton) findViewById(R.id.olustur);
        olustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sayfa2.class);
                startActivity(intent);
            }
        });


        ImageButton gmap = (ImageButton) findViewById(R.id.gmap);
        gmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                intent.putExtra("lat", 38.0262812);
                intent.putExtra("lng", 32.5112952);

                startActivity(intent);
            }
        });


        ImageButton popmain = (ImageButton) findViewById(R.id.popmain);
        popmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent int2 = new Intent(MainActivity.this, popmain.class);
                startActivity(int2);
            }
        });


        ImageButton hakkında = (ImageButton) findViewById(R.id.hakk);
        hakkında.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inth = new Intent(MainActivity.this, sayfa3.class);
                startActivity(inth);
            }
        });



        requestAppPermissions(new String[]{

                        Manifest.permission.WRITE_EXTERNAL_STORAGE,

                        //Manifest.permission.ACCESS_COARSE_LOCATION,


        },
                R.string.msg,REQUEST_PERMISSION);



    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        if (requestCode == REQUEST_PERMISSION) {
            Toast.makeText(getApplicationContext(), "İzinler verildi.", Toast.LENGTH_SHORT).show();
        }
    }

}
