package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.text.DateFormat;
import java.util.Calendar;

public class biletAl extends AppCompatActivity{

    Button butonHome;
    ImageButton butonUser;
    RadioGroup radioGroup;
    RadioButton radioTekyon;
    Button tarihGidis;
    Button tarihDonus;
    TextView textGidis;
    TextView textDonus;
    DatePickerDialog datePickerDialog;
    Spinner gidis;
    Spinner donus;
    Button butonUcusara;
    RadioButton gidisdonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_al);
        butonHome = findViewById(R.id.bkturizm);
        tarihGidis = findViewById(R.id.tarihGidis);
        textGidis = findViewById(R.id.textGidis);
        gidisdonus = findViewById(R.id.gidisdonus);
        radioGroup = findViewById(R.id.radiogroup);
        tarihDonus = findViewById(R.id.tarihDonus);
        butonUcusara = findViewById(R.id.butonUcusara);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radioTekyon = findViewById(R.id.tekyon);
                tarihDonus = findViewById(R.id.tarihDonus);
                textDonus = findViewById(R.id.textDonus);
                if (radioTekyon.isChecked()) {
                    tarihDonus.setVisibility(View.GONE);
                    textDonus.setVisibility(View.GONE);
                } else {
                    tarihDonus.setVisibility(View.VISIBLE);
                    textDonus.setVisibility(View.VISIBLE);
                }
            }
        });

        gidis =  findViewById(R.id.kalkıs);
        //gidis.getSelectedItem().toString();
        donus = findViewById(R.id.varıs);
        //donus.getSelectedItem().toString();

        String[] kalkısNoktası = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kalkısNoktası);
        gidis.setAdapter(adapter);

        String[] varısNoktası = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> adapterVarıs = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,varısNoktası);
        donus.setAdapter(adapterVarıs);


        tarihGidis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog = new DatePickerDialog(biletAl.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                textGidis.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        tarihDonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog = new DatePickerDialog(biletAl.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                textDonus.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(biletAl.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });
        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(biletAl.this,user.class);
                startActivity(gecisYap);

            }
        });
        butonUcusara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisSefer = new Intent(biletAl.this,seferler.class);
                startActivity(gecisSefer);
            }
        });


    }


}
