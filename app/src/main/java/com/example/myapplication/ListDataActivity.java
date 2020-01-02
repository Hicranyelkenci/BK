package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.contentcapture.DataRemovalRequest;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {
    Database Database;
    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = findViewById(R.id.listView);
        Database = new Database(this);
        Listele();

    }
    public void Listele(){
        Database Database = new Database(ListDataActivity.this);
        List<String> list = Database.kisiListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListDataActivity.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,list);
        mListView.setAdapter(adapter);
    }




}
