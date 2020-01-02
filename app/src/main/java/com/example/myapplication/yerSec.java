package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class yerSec extends AppCompatActivity {
    Button buton1,buton2,buton3,buton4,buton5,buton6,buton7,buton8,buton9,buton10,buton11,buton12;
    Database Database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yer_sec);


        buton1 = findViewById(R.id.buton1);
        buton2 = findViewById(R.id.buton2);
        buton3 = findViewById(R.id.buton3);
        buton4 = findViewById(R.id.buton4);
        buton5 = findViewById(R.id.buton5);
        buton6 = findViewById(R.id.buton6);
        buton12 = findViewById(R.id.buton12);
        buton11 = findViewById(R.id.buton11);
        buton10 = findViewById(R.id.buton10);
        buton9 = findViewById(R.id.buton9);
        buton8 = findViewById(R.id.buton8);
        buton7 = findViewById(R.id.buton7);
        final String kalkis = getIntent().getExtras().getString("nereden");
        final String varis = getIntent().getExtras().getString("nereye");
        final String kalkissaati = getIntent().getExtras().getString("kalkissaati");
        final String fiyat = getIntent().getExtras().getString("fiyat");

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton1.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton2.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String gelenYer=  buton3.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });
        buton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String gelenYer=  buton4.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });
        buton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String gelenYer=  buton5.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });   buton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton6.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });   buton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton7.getText().toString();

                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });
        buton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton8.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });   buton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String gelenYer=  buton9.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        }); buton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton10.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });   buton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton11.getText().toString();

                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        }); buton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String gelenYer=  buton12.getText().toString();
                Intent biletGoster = new Intent(yerSec.this,biletGoster.class);
                biletGoster.putExtra("nereden",kalkis);
                biletGoster.putExtra("nereye",varis);
                biletGoster.putExtra("kalkissaati",kalkissaati);
                biletGoster.putExtra("fiyat",fiyat);
                biletGoster.putExtra("gelenYer", gelenYer);
                startActivity(biletGoster);
            }
        });
    }
}
