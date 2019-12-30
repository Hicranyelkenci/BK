package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="bk";
    private static final String TABLO_KISILER="kisiler";
    private static final String TABLO_SEFERLER="seferler";
    private static final String ROW_ID="id";
    private static final String ROW_AD="ad";
    private static final String ROW_SOYAD="soyad";
    private static final String ROW_EPOSTA="eposta";
    private static final String ROW_SIFRE="sifre";
    private static final String ROW_SIFRETEKRAR="sifretekrar";
    private static final String ROW_TEL="tel";
    private static final int DATABASE_VERSION=1;
    private static final String ROW_IDSEFER="id";
    private static final String ROW_KALKIS="kalkis";
    private static final String ROW_VARIS="varis";
    private static final String ROW_KALKISSAATI="kalkissaati";
    private static final String ROW_VARISSAATI="varissaati";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLO_KISILER + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " TEXT NOT NULL, "
                + ROW_SOYAD + " TEXT NOT NULL, "
                + ROW_EPOSTA + " TEXT NOT NULL, "
                + ROW_SIFRE + " TEXT NOT NULL, "
                + ROW_SIFRETEKRAR + " TEXT NOT NULL, "
                + ROW_TEL + " TEXT NOT NULL)");
        db.execSQL(" CREATE TABLE " + TABLO_SEFERLER + "("
                + ROW_IDSEFER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_KALKIS + " TEXT NOT NULL, "
                + ROW_VARIS + " TEXT NOT NULL, "
                + ROW_KALKISSAATI + " TEXT NOT NULL, "
                + ROW_VARISSAATI + " TEXT NOT NULL)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_KISILER);
        onCreate(db);
    }

    public void addData(String ad, String soyad, String epost, String sifr, String sifrtekrar, String tell){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put(ROW_AD, ad);
            contentValues.put(ROW_SOYAD, soyad);
            contentValues.put(ROW_EPOSTA, epost);
            contentValues.put(ROW_SIFRE, sifr);
            contentValues.put(ROW_SIFRETEKRAR, sifrtekrar);
            contentValues.put(ROW_TEL, tell);
            db.insert(TABLO_KISILER,null,contentValues);
        }
        catch (Exception e){
        }
        db.close();
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLO_KISILER;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public Cursor readData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLO_SEFERLER;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

}