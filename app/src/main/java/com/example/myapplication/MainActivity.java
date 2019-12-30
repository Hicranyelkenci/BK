package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button butonHome;
    ImageButton butonUser;
    Button butonBiletal;
    Button butonBiletlerim;
    Button butonRezervasyonlar;
    Button butonBilgi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butonHome = findViewById(R.id.bkturizm);
        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });

        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this,user.class);
                startActivity(gecisYap);


            }
        });

        butonBiletal = findViewById(R.id.biletal);
        butonBiletal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap1 = new Intent(MainActivity.this,biletAl.class);
                startActivity(gecisYap1);
            }
        });

        butonBiletlerim = findViewById(R.id.biletlerim);
        butonBiletlerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap2 = new Intent(MainActivity.this,biletlerim.class);
                startActivity(gecisYap2);            }
        });
        butonRezervasyonlar = findViewById(R.id.rezervasyonlarım);
        butonRezervasyonlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap3 = new Intent(MainActivity.this,rezervasyonlar.class);
                startActivity(gecisYap3);
            }
        });
        butonBilgi = findViewById(R.id.bilgi);
        butonBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap4 = new Intent(MainActivity.this,bilgi.class);
                startActivity(gecisYap4);
            }
        });


    }

}
