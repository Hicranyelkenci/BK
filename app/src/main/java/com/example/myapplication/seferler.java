package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class seferler extends AppCompatActivity {
    Button butonHome;
    ImageButton butonUser;
    TextView seferNeredenEdit1,seferNeredenEdit2,seferNeredenEdit3,
            seferNereyeEdit1,seferNereyeEdit2,seferNereyeEdit3,
            seferKSEdit1,seferKSEdit2,seferKSEdit3,
            seferFiyatEdit1, seferFiyatEdit2, seferFiyatEdit3,
            nereden1,nereden2,nereden3,
            nereye1,nereye2,nereye3,
            ks1,ks2,ks3,
            fiyat1,fiyat2,fiyat3,
    seferTarihi;
    LinearLayout ilkSefer, ikinciSefer, ucuncuSefer;
    Database Database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seferler);
        Database = new Database(this);
        seferNeredenEdit1 = findViewById(R.id.seferNeredenEdit1);
        seferNeredenEdit2 = findViewById(R.id.seferNeredenEdit2);
        seferNeredenEdit3 = findViewById(R.id.seferNeredenEdit3);
        seferNereyeEdit1 = findViewById(R.id.seferNereyeEdit1);
        seferNereyeEdit2 = findViewById(R.id.seferNereyeEdit2);
        seferNereyeEdit3 = findViewById(R.id.seferNereyeEdit3);
        seferKSEdit1 = findViewById(R.id.seferKSEdit1);
        seferKSEdit2 = findViewById(R.id.seferKSEdit2);
        seferKSEdit3 = findViewById(R.id.seferKSEdit3);
        seferFiyatEdit1 = findViewById(R.id.seferFiyatEdit1);
        seferFiyatEdit2 = findViewById(R.id.seferFiyatEdit2);
        seferFiyatEdit3 = findViewById(R.id.seferFiyatEdit3);
        nereden1 = findViewById(R.id.nereden1);
        nereden2 = findViewById(R.id.nereden2);
        nereden3 = findViewById(R.id.nereden3);
        nereye1 = findViewById(R.id.nereye1);
        nereye2 = findViewById(R.id.nereye2);
        nereye3 = findViewById(R.id.nereye3);
        ks1 = findViewById(R.id.ks1);
        ks2 = findViewById(R.id.ks2);
        ks3 = findViewById(R.id.ks3);
        fiyat1 = findViewById(R.id.fiyat1);
        fiyat2 = findViewById(R.id.fiyat2);
        fiyat3 = findViewById(R.id.fiyat3);
        ilkSefer = findViewById(R.id.ilkSefer);
        ikinciSefer = findViewById(R.id.ikinciSefer);
        ucuncuSefer = findViewById(R.id.ucuncuSefer);
        seferTarihi = findViewById(R.id.seferTarih);
        String nereden = getIntent().getExtras().getString("nereden");
        String nereye = getIntent().getExtras().getString("nereye");
        String tarih = getIntent().getExtras().getString("tarih");
        nereden1.setText(nereden);
        nereden2.setText(nereden);
        nereden3.setText(nereden);
        nereye1.setText(nereye);
        nereye2.setText(nereye);
        nereye3.setText(nereye);
        fiyat1.setText("90");
        fiyat2.setText("90");
        fiyat3.setText("90");
        ks1.setText("12:00");
        ks2.setText("15:00");
        ks3.setText("18:00");
        seferTarihi.setText(tarih);

        butonHome = findViewById(R.id.bkturizm);
        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(seferler.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });

        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(seferler.this,user.class);
                startActivity(gecisYap);
            }
        });
        ilkSefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kalkis = nereden1.getText().toString();
                String varis = nereye1.getText().toString();
                String kalkissaati = ks1.getText().toString();
                String fiyat = fiyat1.getText().toString();
                Intent yerSec = new Intent(seferler.this,yerSec.class);
                yerSec.putExtra("nereden",kalkis);
                yerSec.putExtra("nereye",varis);
                yerSec.putExtra("kalkissaati",kalkissaati);
                yerSec.putExtra("fiyat",fiyat);
                startActivity(yerSec);
            }
        });
        ikinciSefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yerSec2 = new Intent(seferler.this,yerSec.class);
                startActivity(yerSec2);
            }
        });
        ucuncuSefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yerSec3 = new Intent(seferler.this,yerSec.class);
                startActivity(yerSec3);
            }
        });



    }
}








