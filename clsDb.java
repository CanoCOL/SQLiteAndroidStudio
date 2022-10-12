package com.example.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//creando la base e datos

public class clsDb extends SQLiteOpenHelper {
    //se crean las tablas
    String tblUser = "CREATE TABLE user(email text primary key, fullname text, password text)";
    public clsDb(Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la tabla
        db.execSQL(tblUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se actualiza la tabla
    db.execSQL("DROP TABLE user");
    db.execSQL(tblUser);
    }
}