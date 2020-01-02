package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    private static final int DATABASE_VERSION=3;
    private static final String ROW_IDSEFER="id";
    private static final String ROW_KALKIS="kalkis";
    private static final String ROW_VARIS="varis";
    private static final String ROW_KALKISSAATI="kalkissaati";
    private static final String ROW_FIYAT="fiyat";
    private static final String ROW_YER ="yer";
    private static final String CREATE_TABLE_KISILER = "CREATE TABLE "
            + TABLO_KISILER + "("  + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ROW_AD + " TEXT NOT NULL, "
            + ROW_SOYAD + " TEXT NOT NULL, "
            + ROW_EPOSTA + " TEXT NOT NULL, "
            + ROW_SIFRE + " TEXT NOT NULL, "
            + ROW_SIFRETEKRAR + " TEXT NOT NULL, "
            + ROW_TEL + " TEXT NOT NULL );";

    private static final String CREATE_TABLE_SEFERLER = "CREATE TABLE "
            + TABLO_SEFERLER + "(" + ROW_IDSEFER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ROW_KALKIS + " TEXT NOT NULL, "
            + ROW_VARIS + " TEXT NOT NULL, "
            + ROW_KALKISSAATI + " TEXT NOT NULL, "
            + ROW_FIYAT + " TEXT NOT NULL, "
            + ROW_YER + " TEXT NOT NULL );";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KISILER);
        db.execSQL(CREATE_TABLE_SEFERLER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_KISILER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_SEFERLER);
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
            db.insert(TABLO_KISILER, null, contentValues); }
        catch (Exception e){
        }
        db.close();
    }

    public List<String> kisiListele(){
        List<String> kisiler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_AD,ROW_SOYAD,ROW_EPOSTA, ROW_SIFRE,ROW_SIFRETEKRAR,ROW_TEL};
            Cursor cursor = db.query(TABLO_KISILER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                kisiler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3)
                        + " - "
                        + cursor.getString(4)
                        + " - "
                        + cursor.getString(5)
                        + " - "
                        + cursor.getString(6));
            }
        }catch (Exception e){
        }
        db.close();
        return kisiler;
    }

    public void addSefer(String kalkis, String varis, String kalkissaati, String fiyat, String yer){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues content = new ContentValues();
            content.put(ROW_KALKIS, kalkis);
            content.put(ROW_VARIS, varis);
            content.put(ROW_KALKISSAATI, kalkissaati);
            content.put(ROW_FIYAT, fiyat);
            content.put(ROW_YER, yer);
            db.insert(TABLO_SEFERLER,null,content);
        }
        catch (Exception e){

        }db.close();}

    public List<String> seferListele(){
        List<String> seferler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_KALKIS,ROW_VARIS,ROW_KALKISSAATI, ROW_FIYAT, ROW_YER};
            Cursor cursor = db.query(TABLO_SEFERLER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                seferler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3)
                        + " - "
                        + cursor.getString(4)
                        + " - "
                        + cursor.getString(5));
            }
        }catch (Exception e){
        }
        db.close();
        return seferler;
    }
}