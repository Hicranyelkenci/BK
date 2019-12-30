package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class rezervasyonlar extends AppCompatActivity {
    Button butonHome;
    ImageButton butonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyonlar);
        butonHome = findViewById(R.id.bkturizm);
        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(rezervasyonlar.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });

        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(rezervasyonlar.this,user.class);
                startActivity(gecisYap);


            }
        });
    }
}
