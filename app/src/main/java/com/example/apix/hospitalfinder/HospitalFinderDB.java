package com.example.apix.hospitalfinder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Apix on 21/01/2017.
 */

public class HospitalFinderDB extends SQLiteOpenHelper {

    static final String DB_NAME = "hospitalfinder_DB";
    static  final  int DB_VERSION = 2;

    public HospitalFinderDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXIST Mikoa (mkoaId INTERGER, mkoa_jina VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Mikoa");
        onCreate(db);
    }

    public void insertMikoa(int id,String mkoa){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Mikoa VALUES ('"+ id +"', '"+mkoa+"')");
    }

    public void initializeDatabase(){
        insertMikoa(1,"Arusha");
        insertMikoa(2,"Dar-Es-Salaam");
        insertMikoa(3,"Dodoma");
        insertMikoa(4,"Iringa");
        insertMikoa(5,"Kagera");
        insertMikoa(6,"Kigoma");
        insertMikoa(7,"Kilimanjaro");
        insertMikoa(8,"Lindi");
        insertMikoa(9,"Mara");
        insertMikoa(10,"Mbeya");
        insertMikoa(11,"Morogoro");
        insertMikoa(12,"Mtwara");
        insertMikoa(13,"Mwanza");
        insertMikoa(14,"Pwani");
        insertMikoa(15,"Rukwa");
        insertMikoa(16,"Ruvuma");
        insertMikoa(17,"Shinyanga");
        insertMikoa(18,"Singida");
        insertMikoa(19,"Tabora");
        insertMikoa(20,"Tanga");
        insertMikoa(21,"Manyara");
        insertMikoa(22,"Geita");
        insertMikoa(23,"Katavi");
        insertMikoa(24,"Njombe");
        insertMikoa(25,"Simiyu");
    }

    public Cursor getData(String sqlselection){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlselection,null);
        return cursor;
    }
}
