package com.ali.denemeson;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import com.ali.denemeson.R;

/**
 * Created by Ali on 4/24/2017.
 */

public class popmain extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popmain);


        DisplayMetrics dm2 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm2);

        int width=dm2.widthPixels;
        int height=dm2.heightPixels;


        getWindow().setLayout((int)(width*.8),(int)(height*.6));



    }
}