package com.example.phonebook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.phonebook.MainActivity;

public class databases extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="phonebook.db";
    private static  final int DATABASE_version=1;
    public static  final String TABLE_NAME="phonebook";
    public static  final String COL_ID="_id";
    public static  final String COL_NAME="name";
    public static  final String COL_phone="phoneNumber";

    private static final String SQL_CREATE_TABLE="create table " + TABLE_NAME + "("
                 + COL_ID + " integer primary key autoincrement,"
                 + COL_NAME + " varchar(50),"
                 + COL_phone + "  varchar(10)" + ")";


    public databases(MainActivity context) {
        super(context, DATABASE_NAME,null, DATABASE_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL(SQL_CREATE_TABLE);
           insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv=new ContentValues();
        cv.put(COL_NAME,"android");
        cv.put(COL_phone,"111-111");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"ios");
        cv.put(COL_phone,"222-222");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"windows");
        cv.put(COL_phone,"333-333");
        db.insert(TABLE_NAME,null,cv);

    }
}
