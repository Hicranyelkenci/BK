package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class seferler extends AppCompatActivity {
    Button butonHome;
    ImageButton butonUser;
    ListView listeSefer;
    String[] seferler =new String[]{};
    Context context = this;
    Database Database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seferler);
        listeSefer = findViewById(R.id.listViewSefer);
        ArrayAdapter<String> adapterSefer = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,seferler);
        listeSefer.setAdapter(adapterSefer);



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
        Database = new Database(seferler.this);

    }
}
