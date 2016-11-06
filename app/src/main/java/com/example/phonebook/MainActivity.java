package com.example.phonebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.phonebook.db.databases;
import com.example.phonebook.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private databases mhelper;
    private SQLiteDatabase mDatabase;
    private ArrayList<Contact> mcontacttArr=new ArrayList<>();
    private ListView mContactListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mhelper = new databases(this);
        mDatabase = mhelper.getWritableDatabase();

       Cursor cursor= mDatabase.query(databases.TABLE_NAME,null,null,null,null,null,null);

        while (cursor.moveToNext()) {

            String name = cursor.getString(cursor.getColumnIndexOrThrow(databases.COL_NAME));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(databases.COL_phone));

            Contact contact = new Contact(name, phone);
            mcontacttArr.add(contact);
        }

            mContactListview=(ListView) findViewById(R.id.listView_contact);
            ArrayAdapter<Contact> adapter=new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, mcontacttArr);
            mContactListview.setAdapter(adapter);






    }
}
