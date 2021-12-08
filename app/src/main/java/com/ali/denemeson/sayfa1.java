package com.ali.denemeson;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.denemeson.R;

import java.math.BigDecimal;

import static android.R.id.list;
import static com.ali.denemeson.R.id.btnmap2;


public class sayfa1 extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<String> adapter;
    TextView so1,so2,so3;
    Spinner sp1,sp2,spd1, spd2;
    EditText x,y,z,x2,x3,y2,y3,dilim;
    Button btn,btn2;
    ImageButton btnmap,btnmap2,paro,infow;
    Object _globalString1, _globalString2, _globalString3,item;
    RadioButton rd1, rd2;
    RadioGroup rdg;
    int kalan,dilim3;


    double gx,gy,gz,gxson,gyson,sonuc,sonuc2,sonuc3,gx2,gy2,gx3,gy3,N,ekare,a,b,c,
            eüskare,e1,f,n,alfa,beta,gama,sigma,epsilon,beta_ç,gama_ç,sigma_ç,ro,epsilon_ç,fief,t,etakare,a1,a2,a3,a4,a5,
            b1,b2,b3,b4,b5,G,deltafi,boylamsifir,dom,l,x1,y1,p,r,teta,enl,boyl,f2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa1);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //uygulama başladığında klavye gelmesin


        sp1 = (Spinner) findViewById(R.id.sp1);
        ArrayAdapter adapters = ArrayAdapter.createFromResource(this, R.array.Sistemler, android.R.layout.simple_spinner_dropdown_item);
        adapters.setDropDownViewResource(R.layout.spiner_item);
        sp1.setAdapter(adapters);

        sp2 = (Spinner) findViewById(R.id.sp2);
        final ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.Sistemler2, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.spiner_item);

        final ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.Sistemler3, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.spiner_item);

        final ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.Sistemler4, android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(R.layout.spiner_item);


        spd1 = (Spinner) findViewById(R.id.spd1);
        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.dilim1, android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(R.layout.spiner_item);


        spd1.setAdapter(adapter5);
        spd1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                _globalString3 = parent.getItemAtPosition(position);

              /*  if (parent.getItemIdAtPosition(position) == 0) {

                    Toast.makeText(sayfa1.this, "Dilim Orta Meridyeni -180 ile +180 arasında 3'ün katı olmalıdır ", Toast.LENGTH_LONG).show();

                } else if (parent.getItemIdAtPosition(position) == 1) {

                    Toast.makeText(sayfa1.this, "Dilim Orta Meridyeni -180 ile +180 arasında 6'nın katı olmalıdır ", Toast.LENGTH_LONG).show();
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        x = (EditText) findViewById(R.id.x);
        y = (EditText) findViewById(R.id.y);
        z = (EditText) findViewById(R.id.z);
        x2 = (EditText) findViewById(R.id.x2);
        x3 = (EditText) findViewById(R.id.x3);
        y2 = (EditText) findViewById(R.id.y2);
        y3 = (EditText) findViewById(R.id.y3);
        dilim = (EditText) findViewById(R.id.dom);
       dilim.setFilters(new InputFilter[]{ new InputFilterMinMax("-180", "180")});


dilim.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {

          if (!hasFocus) {
              boylamsifir = Double.parseDouble(dilim.getText().toString());
              kalan = (int) (boylamsifir % 3);
              if (kalan == 0) {
                  Toast.makeText(sayfa1.this, "Dilim Orta Meridyenin:" + boylamsifir, Toast.LENGTH_SHORT).show();
              } else if (kalan != 0) {
                  Toast.makeText(sayfa1.this, "Dilim Orta Meridyeni -180 ile +180 arasında 3'ün katı olmalıdır! ", Toast.LENGTH_SHORT).show();
              }
        }
    }


});

        so1 = (TextView) findViewById(R.id.so1);
        so2 = (TextView) findViewById(R.id.so2);
        so3 = (TextView) findViewById(R.id.so3);
        final RadioButton rd1 = (RadioButton) findViewById(R.id.rd1);
        final RadioButton rd2 = (RadioButton) findViewById(R.id.rd2);


        x.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
        y.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
        x2.setVisibility(View.INVISIBLE);
        x3.setVisibility(View.INVISIBLE);

        y2.setVisibility(View.INVISIBLE);
        y3.setVisibility(View.INVISIBLE);

        btnmap = (ImageButton) findViewById(R.id.btnmap);
        btnmap2 = (ImageButton) findViewById(R.id.btnmap2);

        btnmap2.setVisibility(View.INVISIBLE);

        rdg = (RadioGroup) findViewById(R.id.rdg);
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (rd1.isChecked()) {

                    x.setLayoutParams(new LinearLayout.LayoutParams(120, ViewGroup.LayoutParams.WRAP_CONTENT));
                    y.setLayoutParams(new LinearLayout.LayoutParams(120, ViewGroup.LayoutParams.WRAP_CONTENT));

                    x2.setVisibility(View.VISIBLE);
                    x3.setVisibility(View.VISIBLE);

                    y2.setVisibility(View.VISIBLE);
                    y3.setVisibility(View.VISIBLE);

                    x.setText("");
                    y.setText("");
                    z.setText("");
                    x2.setText("");
                    y2.setText("");
                    x3.setText("");
                    y3.setText("");

                    x.setHint(" dk' ");
                    y.setHint(" dk' ");
                    x2.setHint(" drc° ");
                    y2.setHint(" drc° ");
                    x3.setHint(" sn'' ");
                    y3.setHint(" sn'' ");

                } else if (rd2.isChecked()) {
                    x.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
                    y.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
                    x2.setVisibility(View.INVISIBLE);
                    x3.setVisibility(View.INVISIBLE);

                    x.setText("");
                    y.setText("");
                    z.setText("");
                    x2.setText("");
                    y2.setText("");
                    x3.setText("");
                    y3.setText("");

                    y2.setVisibility(View.INVISIBLE);
                    y3.setVisibility(View.INVISIBLE);

                    x.setHint("Enlem");
                    y.setHint("Boylam");


                }
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        final ElipsoitRepo elipsoitRepo = new ElipsoitRepo(this);
        boolean isContains = false;
        for (int i = 0; i < elipsoitRepo.getStudentList().size(); i++) {
            if (elipsoitRepo.getStudentList().get(i).containsValue("WGS84 (WGS84) ") ||
                    elipsoitRepo.getStudentList().get(i).containsValue("Hayford (ED50)") ||
                    elipsoitRepo.getStudentList().get(i).containsValue("GRS80 (ITRF)")  ||
                    elipsoitRepo.getStudentList().get(i).containsValue("Bessel")
                    ) {
                isContains = true;
                break;
            }
        }
        if (isContains == false) {
            Elipsoit wgs84 = new Elipsoit();
            wgs84.name = "WGS84 (WGS84) ";
            wgs84.a = 6378137;
            wgs84.b = 6356752.314245;
            elipsoitRepo.insert(wgs84);
            Elipsoit hayford = new Elipsoit();
            hayford.name = "Hayford (ED50) ";
            hayford.a = 6378388;
            hayford.b = 6356911.946;
            elipsoitRepo.insert(hayford);
            Elipsoit grs80=new Elipsoit();
            grs80.name="GRS80 (ITRF) ";
            grs80.a=6378137;
            grs80.b=6356752.31414034;
            elipsoitRepo.insert(grs80);
            Elipsoit bessel=new Elipsoit();
            bessel.name="Bessel";
            bessel.a=6377397.155;
            bessel.b=6356078.963;
            elipsoitRepo.insert(bessel);

        }


        final String[] elipsoitArray = new String[elipsoitRepo.getStudentList().size()];

        for (int i = 0; i < elipsoitRepo.getStudentList().size(); i++) {
            elipsoitArray[i] = elipsoitRepo.getStudentList().get(i).get("name");


        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elipsoitArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(sayfa1.this, "a= " + elipsoitRepo.getStudentList().get(position).get("a") + " b=" + elipsoitRepo.getStudentList().get(position).get("b"), Toast.LENGTH_SHORT).show();


                 b = Double.parseDouble(elipsoitRepo.getStudentList().get(position).get("b"));
                 a = Double.parseDouble(elipsoitRepo.getStudentList().get(position).get("a"));
                final String name1 = parent.getItemAtPosition(position).toString();

                c = Math.pow(a, 2) / b;
                e1 = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
                ekare = (Math.pow(e1, 2)) / (Math.pow(a, 2));
                eüskare = Math.pow(e1, 2) / Math.pow(b, 2);
                f = (a - b) / a;
                f2=1/f;
                n = f / (2 - f);
                alfa = (a / (1 + n)) * (1 + (Math.pow(n, 2)) / 4 + (Math.pow(n, 4)) / 64);
                beta = (a / (1 + n)) * (3 * n / 2 - 3 * Math.pow(n, 3) / 16);
                gama = (a / (1 + n)) * (15 * Math.pow(n, 2) / 16 - 15 * Math.pow(n, 4) / 64);
                sigma = (a / (1 + n)) * (35 * Math.pow(n, 3) / 48);
                epsilon = (a / (1 + n)) * (315 * Math.pow(n, 4) / 512);

                beta_ç=3*n/2-27*Math.pow(n,3)/32;
                gama_ç=21*n*n/16-55*Math.pow(n,4)/32;
                sigma_ç=151*Math.pow(n,3)/96;
                epsilon_ç=1097*Math.pow(n,4)/512;

                paro = (ImageButton) findViewById(R.id.paro);
                paro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intparo = new Intent(sayfa1.this, pop2.class);
                        Bundle b = new Bundle();
                        b.putString("name",name1);
                        b.putDouble("c",c);
                        b.putDouble("ekare",ekare);
                        b.putDouble("eüskare",eüskare);
                        b.putDouble("f",f2);

                        b.putDouble("alfa", alfa);
                        b.putDouble("beta", beta);
                        b.putDouble("gama", gama);
                        b.putDouble("sigma",sigma);
                        b.putDouble("epsilon",epsilon);

                        b.putDouble("beta_ç", beta_ç);
                        b.putDouble("gama_ç", gama_ç);
                        b.putDouble("sigma_ç",sigma_ç);
                        b.putDouble("epsilon_ç",epsilon_ç);

                        intparo.putExtras(b);
                        startActivity(intparo);
                    }
                });

                 }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        spd1.setVisibility(View.INVISIBLE);
        dilim.setVisibility(View.INVISIBLE);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                _globalString1 = parent.getItemAtPosition(position);

                rd1.setVisibility(View.VISIBLE);
                rd2.setVisibility(View.VISIBLE);

                if(parent.getItemIdAtPosition(position)==0){

                    btnmap.setVisibility(View.VISIBLE);
                    btnmap2.setVisibility(View.INVISIBLE);
                    x.setHint("Enlemi");
                    y.setHint("Boylamı");
                    sp2.setAdapter(adapter1);
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            _globalString2 = parent.getItemAtPosition(position);

                            if(parent.getItemIdAtPosition(position)==0){

                                spd1.setVisibility(View.INVISIBLE);
                                dilim.setVisibility(View.INVISIBLE);

                            }

                            else if(parent.getItemIdAtPosition(position)==1) {

                                spd1.setVisibility(View.VISIBLE);
                                dilim.setVisibility(View.VISIBLE);

                            }

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }else if(parent.getItemIdAtPosition(position)==1){



                    x.setHint("X'i Giriniz");
                    y.setHint("Y'yi Giriniz");
                    z.setHint("Z'yi Giriniz");

                    sp2.setAdapter(adapter2);
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            _globalString2 = parent.getItemAtPosition(position);

                            rd1.setVisibility(View.INVISIBLE);
                            rd2.setVisibility(View.INVISIBLE);
                            x.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
                            y.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
                            x2.setVisibility(View.INVISIBLE);
                            y2.setVisibility(View.INVISIBLE);
                            x3.setVisibility(View.INVISIBLE);
                            y3.setVisibility(View.INVISIBLE);

                            if(parent.getItemIdAtPosition(position)==0){
                                spd1.setVisibility(View.INVISIBLE);
                                dilim.setVisibility(View.INVISIBLE);
                                btnmap.setVisibility(View.INVISIBLE);
                                btnmap2.setVisibility(View.VISIBLE);

                           }
                            else if(parent.getItemIdAtPosition(position)==1) {

                                spd1.setVisibility(View.VISIBLE);
                                dilim.setVisibility(View.VISIBLE);
                                btnmap.setVisibility(View.INVISIBLE);
                                btnmap2.setVisibility(View.INVISIBLE);


                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemIdAtPosition(position)==2) {

                    sp2.setAdapter(adapter3);
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            rd1.setVisibility(View.INVISIBLE);
                            rd2.setVisibility(View.INVISIBLE);
                            _globalString2 = parent.getItemAtPosition(position);

                            x.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
                            y.setLayoutParams(new LinearLayout.LayoutParams(275, ViewGroup.LayoutParams.WRAP_CONTENT));
                            x.setHint("Yukarı Değer Giriniz");
                            y.setHint("Sağa Değer Giriniz");
                            x2.setVisibility(View.INVISIBLE);
                            y2.setVisibility(View.INVISIBLE);
                            x3.setVisibility(View.INVISIBLE);
                            y3.setVisibility(View.INVISIBLE);

                            if(parent.getItemIdAtPosition(position)==0) {

                                spd1.setVisibility(View.VISIBLE);
                                dilim.setVisibility(View.VISIBLE);
                                btnmap.setVisibility(View.INVISIBLE);
                                btnmap2.setVisibility(View.VISIBLE);



                            }

                            else if(parent.getItemIdAtPosition(position)==1) {

                                spd1.setVisibility(View.VISIBLE);
                                dilim.setVisibility(View.VISIBLE);
                                btnmap.setVisibility(View.INVISIBLE);
                                btnmap2.setVisibility(View.INVISIBLE);


                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}

        });

        btn =(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x.getText().toString().isEmpty() || y.getText().toString().isEmpty() || z.getText().toString().isEmpty()) {

                    Toast.makeText(sayfa1.this,
                            "DEĞER GİRMEDİNİZ !", Toast.LENGTH_SHORT).show();

                } else if (x.getText().toString().length() > 0 && y.getText().toString().length() > 0 && z.getText().toString().length() > 0) {

                    gx = Double.parseDouble(x.getText().toString());
                    gy = Double.parseDouble(y.getText().toString());
                    gz = Double.parseDouble(z.getText().toString());


                    if (x2.getText().toString().isEmpty()) {
                        gxson = gx;
                        gyson = gy;
                    } else if (x2.getText().toString().length() > 0) {


                        gx2 = Double.parseDouble(x2.getText().toString());
                        gx3 = Double.parseDouble(x3.getText().toString());
                        gy2 = Double.parseDouble(y2.getText().toString());
                        gy3 = Double.parseDouble(y3.getText().toString());
                        gxson = gx2 + gx / 60 + gx3 / 3600;
                        gyson = gy2 + gy / 60 + gy3 / 3600;
                    }


                    if (_globalString1.equals("Projeksiyon Koordinat Sistemi") && _globalString2.equals("Coğrafi Koordinat Sistemi")) {

                        if(dilim.getText().toString().isEmpty()){
                            Toast.makeText(sayfa1.this, "Dilim Orta Meridyenini Girmediniz!",Toast.LENGTH_SHORT).show();
                        }

                        else if (dilim.getText().length()>0) {
                            boylamsifir = Double.parseDouble(dilim.getText().toString());

                            if (_globalString3.equals("3° (GaussKruger)")) {

                                gxson = gxson / 1;
                                gyson = (gyson - 500000) / 1;
                            } else if (_globalString3.equals("6°(UTM)")) {

                                gxson = gxson / 0.9996;
                                gyson = (gyson - 500000) / 0.9996;
                            }

                            ro = Math.pow(gxson, 1) / Math.pow(alfa, 1);
                            fief = ro + beta_ç * Math.sin(2 * ro) + gama_ç * Math.sin(4 * ro) + sigma_ç * Math.sin(6 * ro) + epsilon_ç * Math.sin(8 * ro);
                            N = (c) / (Math.sqrt(1 + eüskare * Math.pow(Math.cos(fief), 2)));
                            t = Math.tan(fief);
                            etakare = eüskare * Math.cos(fief) * Math.cos(fief);

                            b1 = 1 / (N * Math.cos(fief));
                            b2 = (-t * (1 + etakare)) / (2 * N * N);
                            b3 = (-1 * (1 + 2 * Math.pow(t, 2) + etakare)) / (6 * Math.pow(N, 3) * Math.cos(fief));
                            b4 = (t * (5 + 3 * t * t + 6 * etakare - 6 * etakare * t * t)) / (24 * Math.pow(N, 4));
                            b5 = (5 + 28 * t * t + 24 * Math.pow(t, 4)) / (120 * Math.pow(N, 5) * Math.cos(fief));

                            deltafi = b2 * Math.pow(gyson, 2) + b4 * Math.pow(gyson, 4);
                            l = Math.toDegrees(b1 * gyson + b3 * Math.pow(gyson, 3) + b5 * Math.pow(gyson, 5));

                            sonuc = Math.toDegrees(fief + deltafi);
                            sonuc2 = boylamsifir + l;

                            so1.setText("Enlem=" + sonuc);
                            so2.setText("Boylam=" + sonuc2);
                        }

                    }

                    else if (_globalString1.equals("Projeksiyon Koordinat Sistemi") && _globalString2.equals("Kartezyen Koordinat Sistemi")){

                        if(dilim.getText().toString().isEmpty()){
                            Toast.makeText(sayfa1.this, "Dilim Orta Meridyenini Girmediniz!",Toast.LENGTH_SHORT).show();
                        }

                        else if (dilim.getText().length()>0) {
                        boylamsifir = Double.parseDouble(dilim.getText().toString());
                        if (_globalString3.equals("3° (GaussKruger)")) {

                            gxson = gxson / 1;
                            gyson = (gyson - 500000) / 1;
                        } else if (_globalString3.equals("6°(UTM)")) {

                            gxson = gxson / 0.9996;
                            gyson = (gyson - 500000) / 0.9996;
                        }

                        ro = Math.pow(gxson, 1) / Math.pow(alfa, 1);
                        fief = ro + beta_ç * Math.sin(2 * ro) + gama_ç * Math.sin(4 * ro) + sigma_ç * Math.sin(6 * ro) + epsilon_ç * Math.sin(8 * ro);
                        N = (c) / (Math.sqrt(1 + eüskare * Math.pow(Math.cos(fief), 2)));
                        t = Math.tan(fief);
                        etakare = eüskare * Math.cos(fief) * Math.cos(fief);

                        b1=1/(N*Math.cos(fief));
                        b2=(-t*(1+etakare))/(2*N*N);
                        b3=(-1*(1+2*Math.pow(t,2)+etakare))/(6*Math.pow(N,3)*Math.cos(fief));
                        b4=(t*(5+3*t*t+6*etakare-6*etakare*t*t))/(24*Math.pow(N,4));
                        b5=(5+28*t*t+24*Math.pow(t,4))/(120*Math.pow(N,5)*Math.cos(fief));

                        deltafi=b2*Math.pow(gyson,2)  +  b4*Math.pow(gyson,4);
                        l=Math.toDegrees(b1*gyson+b3*Math.pow(gyson,3)+b5*Math.pow(gyson,5));

                        enl=Math.toDegrees(fief+deltafi);
                        boyl=boylamsifir+l;

                        N = (c) / (Math.sqrt(1 + eüskare * Math.pow(Math.cos(Math.toRadians(enl)), 2)));
                        sonuc = (N + gz) * Math.cos(Math.toRadians(enl)) * Math.cos(Math.toRadians(boyl));
                        sonuc2 = (N + gz) * Math.cos(Math.toRadians(enl)) * Math.sin(Math.toRadians(boyl));
                        sonuc3 = ((1 - ekare) * N + gz) * Math.sin(Math.toRadians(enl));

                        so1.setText("X : " + sonuc);
                        so2.setText("Y : " + sonuc2);
                        so3.setText("Z : " + sonuc3);  }

                    }

                    else if (_globalString1.equals("Coğrafi Koordinat Sistemi") && _globalString2.equals("Kartezyen Koordinat Sistemi")) {

                        N = (c) / (Math.sqrt(1 + eüskare * Math.pow(Math.cos(Math.toRadians(gxson)), 2)));
                        sonuc = (N + gz) * Math.cos(Math.toRadians(gxson)) * Math.cos(Math.toRadians(gyson));
                        sonuc2 = (N + gz) * Math.cos(Math.toRadians(gxson)) * Math.sin(Math.toRadians(gyson));
                        sonuc3 = ((1 - ekare) * N + gz) * Math.sin(Math.toRadians(gxson));

                        so1.setText("X : " + sonuc);
                        so2.setText("Y : " + sonuc2);
                        so3.setText("Z : " + sonuc3);

                    } else if (_globalString1.equals("Coğrafi Koordinat Sistemi") && _globalString2.equals("Projeksiyon Koordinat Sistemi")) {
                        if(dilim.getText().toString().isEmpty()){
                            Toast.makeText(sayfa1.this, "Dilim Orta Meridyenini Girmediniz!",Toast.LENGTH_SHORT).show();
                        }

                        else if (dilim.getText().length()>0) {

                        boylamsifir = Double.parseDouble(dilim.getText().toString());
                        N = (c) / (Math.sqrt(1 + eüskare * Math.pow(Math.cos(Math.toRadians(gxson)), 2)));
                        t = Math.tan(Math.toRadians(gxson));
                        etakare = eüskare * Math.cos(Math.toRadians(gxson)) * Math.cos(Math.toRadians(gxson));

                        double q = -1 / 6;
                        double qq = 1 / 24;
                        double qqq = 1 / 120;

                        a1 = N * Math.cos(Math.toRadians(gxson));
                        a2 = -0.5 * N * Math.pow(Math.cos(Math.toRadians(gxson)), 2) * t;
                        a3 = (q) * N * Math.pow(Math.cos(Math.toRadians(gxson)), 3) * (1 - Math.pow(t, 2) + etakare);
                        a4 = (qq) * N * Math.pow(Math.cos(Math.toRadians(gxson)), 4) * t * (5 - Math.pow(t, 2) + 9 * etakare + 4 * Math.pow(etakare, 2));
                        a5 = (qqq) * N * Math.pow(Math.cos(Math.toRadians(gxson)), 5) * (5 - 18 * Math.pow(t, 2) + Math.pow(t, 4));
                        G = Math.toRadians(gxson) * alfa - beta * Math.sin(2 * Math.toRadians(gxson)) + gama * Math.sin(4 * Math.toRadians(gxson)) - sigma * Math.sin(6 * Math.toRadians(gxson)) + epsilon * Math.sin(8 * Math.toRadians(gxson));



                        l = Math.toRadians(gyson - boylamsifir);

                        if (_globalString3.equals("3° (GaussKruger)")) {


                            x1 = (G - a2 * l * l + a4 * l * l * l * l);
                            y1 = (a1 * l - a3 * l * l * l + a5 * l * l * l * l * l) + 500000;

                        } else if (_globalString3.equals("6°(UTM)")) {

                            x1 = (G - a2 * l * l + a4 * l * l * l * l) * 0.9996;
                            y1 = (a1 * l - a3 * l * l * l + a5 * l * l * l * l * l) * 0.9996 + 500000;

                        }

                        so1.setText("Yukarı Değer =" + x1);
                        so2.setText("Sağ Değer =" + y1); }

                    } else if (_globalString1.equals("Kartezyen Koordinat Sistemi") && _globalString2.equals("Coğrafi Koordinat Sistemi")) {

                        p = Math.sqrt(gxson * gxson + gyson * gyson);
                        r = Math.sqrt(p * p + gz * gz);
                        teta = Math.atan(gz * ((1 - f) + (ekare * a / r)) / p);

                        sonuc = Math.toDegrees(Math.atan((gz * (1 - f) + ekare * a * Math.pow(Math.sin(teta), 3)) / ((1 - f) * (p - ekare * a * Math.pow(Math.cos(teta), 3)))));
                        sonuc2 = Math.toDegrees(Math.atan(gyson / gxson));
                        sonuc3 = p * Math.cos(Math.toRadians(sonuc)) + gz * Math.sin(Math.toRadians(sonuc)) - a * Math.sqrt(1 - ekare * Math.pow(Math.sin(Math.toRadians(sonuc)), 2));


                        so1.setText("Enlem=" + sonuc);
                        so2.setText("Boylam=" + sonuc2);
                        so3.setText("Yükseklik=" + sonuc3);
                    }

                    else if (_globalString1.equals("Kartezyen Koordinat Sistemi") && _globalString2.equals("Projeksiyon Koordinat Sistemi")) {
                        if(dilim.getText().toString().isEmpty()){
                            Toast.makeText(sayfa1.this, "Dilim Orta Meridyenini Girmediniz!",Toast.LENGTH_SHORT).show();
                        }
                        else if (dilim.getText().length()>0) {

                        boylamsifir = Double.parseDouble(dilim.getText().toString());
                        p = Math.sqrt(gxson * gxson + gyson * gyson);
                        r = Math.sqrt(p * p + gz * gz);
                        teta = Math.atan(gz * ((1 - f) + (ekare * a / r)) / p);

                        sonuc = Math.toDegrees(Math.atan((gz * (1 - f) + ekare * a * Math.pow(Math.sin(teta), 3)) / ((1 - f) * (p - ekare * a * Math.pow(Math.cos(teta), 3)))));
                        sonuc2 = Math.toDegrees(Math.atan(gyson / gxson));
                        sonuc3 = p * Math.cos(Math.toRadians(sonuc)) + gz * Math.sin(Math.toRadians(sonuc)) - a * Math.sqrt(1 - ekare * Math.pow(Math.sin(Math.toRadians(sonuc)), 2));

                        N = (c) / (Math.sqrt(1 + eüskare * Math.pow(Math.cos(Math.toRadians(sonuc)), 2)));
                        t = Math.tan(Math.toRadians(sonuc));
                        etakare = eüskare * Math.cos(Math.toRadians(sonuc)) * Math.cos(Math.toRadians(sonuc));


                        double q = -1 / 6;
                        double qq = 1 / 24;
                        double qqq = 1 / 120;

                        a1 = N * Math.cos(Math.toRadians(sonuc));
                        a2 = -0.5 * N * Math.pow(Math.cos(Math.toRadians(sonuc)), 2) * t;
                        a3 = (q) * N * Math.pow(Math.cos(Math.toRadians(sonuc)), 3) * (1 - Math.pow(t, 2) + etakare);
                        a4 = (qq) * N * Math.pow(Math.cos(Math.toRadians(sonuc)), 4) * t * (5 - Math.pow(t, 2) + 9 * etakare + 4 * Math.pow(etakare, 2));
                        a5 = (qqq) * N * Math.pow(Math.cos(Math.toRadians(sonuc)), 5) * (5 - 18 * Math.pow(t, 2) + Math.pow(t, 4));
                        G = Math.toRadians(sonuc) * alfa - beta * Math.sin(2 * Math.toRadians(sonuc)) + gama * Math.sin(4 * Math.toRadians(sonuc)) - sigma * Math.sin(6 * Math.toRadians(sonuc)) + epsilon * Math.sin(8 * Math.toRadians(sonuc));



                        l = Math.toRadians(sonuc2 - boylamsifir);

                        if (_globalString3.equals("3° (GaussKruger)")) {


                            x1 = (G - a2 * l * l + a4 * l * l * l * l);
                            y1 = (a1 * l - a3 * l * l * l + a5 * l * l * l * l * l) + 500000;

                        } else if (_globalString3.equals("6°(UTM)")) {

                            x1 = (G - a2 * l * l + a4 * l * l * l * l) * 0.9996;
                            y1 = (a1 * l - a3 * l * l * l + a5 * l * l * l * l * l) * 0.9996 + 500000;

                        }


                        so1.setText("Yukarı Değer =" + x1);
                        so2.setText("Sağ Değer =" + y1); }

                    }
                }


                //klavye gitsin
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

            }
        });






        Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItemPosition() !=0 && spinner.getSelectedItemPosition() != 1 && spinner.getSelectedItemPosition() != 2 && spinner.getSelectedItemPosition() != 3) {
                    int deletePos = spinner.getSelectedItemPosition();
                    int deleteID = Integer.parseInt(elipsoitRepo.getStudentList().get(deletePos).get("id"));
                    ElipsoitRepo elipsoitRepo1 = new ElipsoitRepo(sayfa1.this);
                    elipsoitRepo1.delete(deleteID);
                    refreshSpinner();
                }
                else
                    Toast.makeText(getApplicationContext(),"Default objeler silinemez", Toast.LENGTH_SHORT).show();
            }
        });

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setText("");
                y.setText("");
                z.setText("");
                x2.setText("");
                y2.setText("");
                x3.setText("");
                y3.setText("");
                so3.setText("");
                so2.setText("");
                so1.setText("");


            }
        });





        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                 if (x2.getText().toString().length() > 0) {


                    gx2 = Double.parseDouble(x2.getText().toString());
                    gx3 = Double.parseDouble(x3.getText().toString());
                    gy2 = Double.parseDouble(y2.getText().toString());
                    gy3 = Double.parseDouble(y3.getText().toString());
                    gxson = gx2 + gx / 60 + gx3 / 3600;
                    gyson = gy2 + gy / 60 + gy3 / 3600;

                }
                double lat=0;
                double lng=0;


                if(x.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "Enlemi Girmediniz", Toast.LENGTH_SHORT).show();

                    x.requestFocus();
                    return;
                    }    else{

                                 if(x2.getText().toString().isEmpty()){

                                        lat = Double.parseDouble(x.getText().toString());
                                                  }

                                 else if (x2.getText().toString().length() > 0){

                                       gx=Double.parseDouble(x.getText().toString());
                                       gx2 = Double.parseDouble(x2.getText().toString());
                                       gx3 = Double.parseDouble(x3.getText().toString());
                                     lat = gx2 + gx / 60 + gx3 / 3600;

                                 }

                }

                if(y.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "Boylamı Girmediniz", Toast.LENGTH_SHORT).show();


                    y.requestFocus();

                    return;
                }else{


                    if(y2.getText().toString().isEmpty()){

                        lng = Double.parseDouble(y.getText().toString());
                    }

                    else if (y2.getText().length()>0){

                        gy=Double.parseDouble(y.getText().toString());
                        gy2 = Double.parseDouble(y2.getText().toString());
                        gy3 = Double.parseDouble(y3.getText().toString());
                        lng = gy2 + gy / 60 + gy3 / 3600;


                    }


                }

                Intent intent = new Intent(getBaseContext(),MapsActivity.class);
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);

                startActivity(intent);
            }
        });


        btnmap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat=0;
                double lng=0;


                lat=sonuc;
                lng=sonuc2;


                Intent intent = new Intent(getBaseContext(),MapsActivity.class);
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);

                startActivity(intent);
            }
        });

        ImageButton infow = (ImageButton) findViewById(R.id.infow);
        infow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(sayfa1.this,pop3.class);
                startActivity(int2);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }
    public void refreshSpinner(){
        ElipsoitRepo elipsoitRepo = new ElipsoitRepo(sayfa1.this);
        String[] elipsoitArray = new String[elipsoitRepo.getStudentList().size()];

        for (int i=0; i<elipsoitRepo.getStudentList().size(); i++){
            elipsoitArray[i] = elipsoitRepo.getStudentList().get(i).get("name");
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elipsoitArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();

        refreshSpinner();
    }

    @Override
    public void onStart(){
        super.onStart();
        adapter.notifyDataSetChanged();

        refreshSpinner();
    }


    }

