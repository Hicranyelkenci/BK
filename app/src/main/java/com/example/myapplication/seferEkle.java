package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class seferEkle extends AppCompatActivity {
    Button butonSeferEkle;
    TextView seferEkleKalkis;
    TextView seferEkleVaris;
    Spinner kalkisEdit ;
    Spinner varisEdit;
    TextView seferEkleKalkisSaati;
    TextView seferEkleVarisSaati;
    Spinner spinnerKalkisSaati ;
    Spinner spinnerVarisSaati;
    Database Database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefer_ekle);
        butonSeferEkle = findViewById(R.id.butonSeferEkle);
        seferEkleKalkis = findViewById(R.id.seferEkleKalkis);
        seferEkleVaris = findViewById(R.id.seferEkleVaris);
        kalkisEdit = findViewById(R.id.kalkisEdit);
        varisEdit = findViewById(R.id.varisEdit);
        seferEkleKalkisSaati = findViewById(R.id.seferEkleKalkisSaati);
        seferEkleVarisSaati = findViewById(R.id.seferEkleKalkisSaati);
        spinnerKalkisSaati = findViewById(R.id.spinnerKalkisSaati);
        spinnerVarisSaati = findViewById(R.id.spinnerVarisSaati);

        String[] kalkısNoktasıyer = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> adapterkalkısyer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kalkısNoktasıyer);
        kalkisEdit.setAdapter(adapterkalkısyer);

        String[] varısNoktasıyer = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> adapterVarısyer = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,varısNoktasıyer);
        varisEdit.setAdapter(adapterVarısyer);

        String[] kalkısNoktası = getResources().getStringArray(R.array.sefersaat);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kalkısNoktası);
        spinnerKalkisSaati.setAdapter(adapter);
        String[] varısNoktası = getResources().getStringArray(R.array.sefersaat);
        ArrayAdapter<String> adapterVarıs = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,varısNoktası);
        spinnerVarisSaati.setAdapter(adapterVarıs);



        butonSeferEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seferKalkisEdit = kalkisEdit.getSelectedItem().toString();
                String seferVarisEdit = varisEdit.getSelectedItem().toString();
                String seferSpinnerKalkisSaati = spinnerKalkisSaati.getSelectedItem().toString();
                String seferSpinnerVarisSaati = spinnerVarisSaati.getSelectedItem().toString();
                Database = new Database(seferEkle.this);
                Intent intentListSefer = new Intent(seferEkle.this, seferler.class);
                startActivity(intentListSefer);

            }
        });

    }

}
