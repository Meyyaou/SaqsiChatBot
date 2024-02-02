package com.example.saqsi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBname= "signin.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table users(email TEXT primary key, username TEXT, password TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(
                "drop table if exists users"
        );
    }
    public boolean insertUser(String email, String username, String password){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);

        long result = DB.insert("users", null, contentValues);
    if(result== -1) {return false;}else{return true;}//check if success or not
    }

    //we check if account already exist?
    public boolean checkEmail(String email){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor = DB.rawQuery(
                "select * from users where email =?", new String[]{email}
        );
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkAccount(String username, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery(
            "select * from users where username = ? and password =?",  new String[]{username, password}
        );
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
