package com.ali.denemeson;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.ali.denemeson.R;

public class sayfa2 extends AppCompatActivity {
    EditText name;
    EditText a,b;
    Button insert;
    ImageButton info;
    PopupWindow popupwindow;
    LayoutInflater lay1;
    RelativeLayout relative;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);
        name = (EditText) findViewById(R.id.isim);
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        insert = (Button) findViewById(R.id.insert);

        info = (ImageButton) findViewById(R.id.info);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty() || a.getText().toString().isEmpty() || b.getText().toString().isEmpty()){
                    Toast.makeText(sayfa2.this, "Boş Alanlar Var!", Toast.LENGTH_SHORT).show();
                }

                else if (name.getText().toString().length() > 0 && a.getText().toString().length() > 0 && b.getText().toString().length() > 0){

                Elipsoit elipsoit = new Elipsoit();
                elipsoit.name = name.getText().toString();
                elipsoit.a = Double.parseDouble(a.getText().toString());
                elipsoit.b = Double.parseDouble(b.getText().toString());
                ElipsoitRepo elipsoitRepo = new ElipsoitRepo(sayfa2.this);
                elipsoitRepo.insert(elipsoit);
                finish();
                    Toast.makeText(sayfa2.this, "Elipsoit Dönüştürücüye Eklendi...", Toast.LENGTH_SHORT).show();


            }}
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sayfa2.this,pop1.class));

            }
        });

    }
}
