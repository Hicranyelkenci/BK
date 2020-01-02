package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class rezervasyonlar extends AppCompatActivity {
    Button butonHome;
    ImageButton butonUser;
    ListView listeRBiletler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyonlar);
        butonHome = findViewById(R.id.bkturizm);
        listeRBiletler = findViewById(R.id.listeRBiletler);
        biletListele();
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
    public void biletListele(){
        Database Database = new Database(rezervasyonlar.this);
        List<String> list = Database.seferListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(rezervasyonlar.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,list);
        listeRBiletler.setAdapter(adapter);
    }
}
