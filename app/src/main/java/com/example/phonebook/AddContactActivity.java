package com.example.phonebook;

import android.content.ContentValues;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.phonebook.db.databases;


public class AddContactActivity extends AppCompatActivity  {
    private EditText mNameEditText,mPhoneText;
    private Button mSaveButton;

    private databases mHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

      // mHelper = new databases(this);
      // mDb = mHelper.getWritableDatabase();

        mNameEditText=(EditText)findViewById(R.id.edt_name);
        mPhoneText=(EditText)findViewById(R.id.edt_phone);
        mSaveButton=(Button)findViewById(R.id.bt_save);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mNameEditText.getText().toString();
                String phhone=mPhoneText.getText().toString();

                ContentValues cv=new ContentValues();
                cv.put(databases.COL_NAME,name);
                cv.put(databases.COL_phone,phhone);
                cv.put(databases.COL_IMAGE,R.drawable.ic_android);
               // mDb.insert(databases.TABLE_NAME,null,cv);
            }
        });

    }
}
