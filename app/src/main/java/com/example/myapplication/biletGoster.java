package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class biletGoster extends AppCompatActivity {
    Database Database;
    ListView biletGoster;
    Button satinal;
    Button rezerve, alertButon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_goster);
        biletGoster = findViewById(R.id.biletGoster);
        satinal = findViewById(R.id.biletSatinAl);


        rezerve = findViewById(R.id.rezerve);
        Database = new Database(this);
        String kalkis = getIntent().getExtras().getString("nereden");
        String varis = getIntent().getExtras().getString("nereye");
        String kalkissaati = getIntent().getExtras().getString("kalkissaati");
        String fiyat = getIntent().getExtras().getString("fiyat");
        String gelenYer = getIntent().getExtras().getString("gelenYer");

        Database Database = new Database(biletGoster.this);
        Database.addSefer(kalkis,varis,kalkissaati,fiyat,gelenYer);



        biletListelee();
        satinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(biletGoster.this,"Biletiniz satın alındı.",Toast.LENGTH_SHORT).show();
                Intent gecis1 = new Intent(biletGoster.this,biletlerim.class);
                startActivity(gecis1); }});
        rezerve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(biletGoster.this,"Biletiniz rezerve edildi.",Toast.LENGTH_SHORT).show();
                Intent gecis2 = new Intent(biletGoster.this,rezervasyonlar.class);
                startActivity(gecis2); }});
    }
    public void biletListelee(){
        Database Database = new Database(biletGoster.this);
        List<String> list = Database.seferListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(biletGoster.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,list);
        biletGoster.setAdapter(adapter);
    }
}

