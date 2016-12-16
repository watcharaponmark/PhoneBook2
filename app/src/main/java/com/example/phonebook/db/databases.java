package com.example.phonebook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import com.example.phonebook.AddContactActivity;
import com.example.phonebook.MainActivity;

public class databases extends SQLiteOpenHelper {

    private  static final String TAG=databases.class.getSimpleName();

    private static  final String DATABASE_NAME="phonebook.db";
    private static  final int DATABASE_version=2;
    public static  final String TABLE_NAME="phonebook";
    public static  final String COL_ID="_id";
    public static  final String COL_NAME="name";
    public static  final String COL_phone="phoneNumber";
    public static  final String COL_IMAGE="image";

    private static final String SQL_CREATE_TABLE="create table " + TABLE_NAME + "("
                 + COL_ID + " integer primary key autoincrement,"
                 + COL_NAME + " varchar(50),"
                 + COL_phone + " varchar(10),"
                 + COL_IMAGE + " varchar(20)"+ ")";


    public databases(MainActivity context) {
        super(context, DATABASE_NAME,null, DATABASE_version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL(SQL_CREATE_TABLE);
           insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG,"onUpgrade() : oldVersion= "+oldVersion+",newVersion = "+newVersion);

            db.execSQL("drop table "+ TABLE_NAME);
            db.execSQL(SQL_CREATE_TABLE);
            insertInitialData(db);

    }
    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv=new ContentValues();
        cv.put(COL_NAME,"android");
        cv.put(COL_phone,"111-111");
        cv.put(COL_IMAGE,"ic_android.png");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"ios");
        cv.put(COL_phone,"222-222");
        cv.put(COL_IMAGE,"ic_ios.png");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"windows");
        cv.put(COL_phone,"333-333");
        cv.put(COL_IMAGE,"ic_windows.png");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"linux");
        cv.put(COL_phone,"444-444");
        cv.put(COL_IMAGE,"ic_linux.png");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"osx");
        cv.put(COL_phone,"555-555");
        cv.put(COL_IMAGE,"ic_osx.png");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"asus");
        cv.put(COL_phone,"666-666");
        cv.put(COL_IMAGE,"ic_asus.png");
        db.insert(TABLE_NAME,null,cv);

        cv=new ContentValues();
        cv.put(COL_NAME,"dell");
        cv.put(COL_phone,"777-777");
        cv.put(COL_IMAGE,"ic_dell.png");
        db.insert(TABLE_NAME,null,cv);

    }
}
