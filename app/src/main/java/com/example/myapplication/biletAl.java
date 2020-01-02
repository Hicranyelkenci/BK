package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
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
import java.sql.SQLRecoverableException;
import java.text.DateFormat;
import java.util.Calendar;

public class biletAl extends AppCompatActivity{

    Button butonHome;
    ImageButton butonUser;
    RadioGroup radioGroup;
    RadioButton radioTekyon;
    Button tarihGidis;
    Button tarihDonus;
    Button butonSeferEkle;
    TextView textGidis;
    TextView textDonus;
    DatePickerDialog datePickerDialog;
    Spinner gidis;
    Spinner donus;
    Button butonUcusara;
    RadioButton gidisdonus;
    Database Database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_al);
        butonHome = findViewById(R.id.bkturizm);
        tarihGidis = findViewById(R.id.tarihGidis);
        textGidis = findViewById(R.id.textGidis);
        textDonus = findViewById(R.id.textDonus);
        gidisdonus = findViewById(R.id.gidisdonus);
        radioGroup = findViewById(R.id.radiogroup);
        tarihDonus = findViewById(R.id.tarihDonus);
        butonUcusara = findViewById(R.id.butonUcusara);
        butonSeferEkle = findViewById(R.id.butonSeferEkle);
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
        donus = findViewById(R.id.varıs);

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
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
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
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
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

                String nereden = gidis.getSelectedItem().toString();
                String nereye = donus.getSelectedItem().toString();
                String tarih = textGidis.getText().toString();
                String tarih2 = textDonus.getText().toString();
                if (nereden.equals(nereye)){
                    Toast.makeText(biletAl.this, "Varış Noktası Kalkış Noktasıyla aynı olamaz..", Toast.LENGTH_SHORT).show();
                }
                else if (tarih.isEmpty()){
                    Toast.makeText(biletAl.this, "Tarih boş olamaz..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent gecisSefer = new Intent(biletAl.this,seferler.class);
                    gecisSefer.putExtra("nereden",nereden);
                    gecisSefer.putExtra("nereye",nereye);
                    gecisSefer.putExtra("tarih",tarih);
                    startActivity(gecisSefer);
                }
            }
        });
        butonSeferEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gecisSefer = new Intent(biletAl.this,seferEkle.class);
                startActivity(gecisSefer);
            }
        });


    }


}
