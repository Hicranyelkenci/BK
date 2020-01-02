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

public class biletlerim extends AppCompatActivity {
    ListView listeBiletler;
    Database Database;
    Button butonHome;
    ImageButton butonUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biletlerim);
        butonHome = findViewById(R.id.bkturizm);
        listeBiletler = findViewById(R.id.listeBiletler);
        Database = new Database(this);
        biletListele();
        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(biletlerim.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });

        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(biletlerim.this,user.class);
                startActivity(gecisYap);


            }
        });
    }
    public void biletListele(){
        Database Database = new Database(biletlerim.this);
        List<String> list = Database.seferListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(biletlerim.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,list);
        listeBiletler.setAdapter(adapter);
    }
}
