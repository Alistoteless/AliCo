package com.ali.denemeson;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.ali.denemeson.R;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Ali on 4/24/2017.
 */

public class pop2 extends Activity {

    TextView baslik,txtp,txtp2,txtp3,txtp4,txtp5,txtp6,txtp7,txtp8,txtp9,txtp10,txtp11,txtp12,txtp13,txtp14;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        Bundle b = getIntent().getExtras();
        String name1=b.getString("name");
        double alfa1 = b.getDouble("alfa");
        double beta1 = b.getDouble("beta");
        double gama1 = b.getDouble("gama");
        double sigma1 = b.getDouble("sigma");
        double epsilon1 = b.getDouble("epsilon");
        double betaç1 = b.getDouble("beta_ç");
        double gamaç1 = b.getDouble("gama_ç");
        double sigmaç1 = b.getDouble("sigma_ç");
        double epsilonç1 = b.getDouble("epsilon_ç");
        double c1 = b.getDouble("c");
        double f1 = b.getDouble("f");
        double ekare1 = b.getDouble("ekare");
        double eüskare1 = b.getDouble("eüskare");


        baslik = (TextView) findViewById(R.id.baslik);
        txtp = (TextView) findViewById(R.id.txtp);
        txtp2 = (TextView) findViewById(R.id.txtp2);
        txtp3 = (TextView) findViewById(R.id.txtp3);
        txtp4 = (TextView) findViewById(R.id.txtp4);
        txtp5 = (TextView) findViewById(R.id.txtp5);
        txtp6 = (TextView) findViewById(R.id.txtp6);
        txtp7 = (TextView) findViewById(R.id.txtp7);
        txtp8 = (TextView) findViewById(R.id.txtp8);
        txtp9 = (TextView) findViewById(R.id.txtp9);
        txtp10 = (TextView) findViewById(R.id.txtp10);
        txtp11 = (TextView) findViewById(R.id.txtp11);
        txtp12 = (TextView) findViewById(R.id.txtp12);
        txtp13 = (TextView) findViewById(R.id.txtp13);
        txtp14 = (TextView) findViewById(R.id.txtp14);



        baslik.setText(name1+" elipsoidinin parametreleri");

        txtp2.setText("Basıklık (1/f) = "+f1);
        txtp3.setText("K.EğrilikYarıçapı(c)="+c1);
        txtp4.setText("e2="+ekare1);
        txtp5.setText("e'2="+eüskare1);

        txtp6.setText("alfa="+alfa1);
        txtp7.setText("beta="+beta1);
        txtp8.setText("gama="+gama1);
        txtp9.setText("sigma="+sigma1);
        txtp10.setText("epsilon="+epsilon1);

        txtp11.setText("beta çizgili="+betaç1);
        txtp12.setText("gama çizgili="+gamaç1);
        txtp13.setText("sigma çizgili="+sigmaç1);
        txtp14.setText("epsilon çizgili="+epsilonç1);

    }




}
