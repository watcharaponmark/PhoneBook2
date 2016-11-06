package com.example.phonebook.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.phonebook.model.Contact;

import java.util.ArrayList;
public class ContactListAdapte extends ArrayAdapter<Contact>{
    public ContactListAdapte(Context context, int resource,ArrayList<Contact> objects) {
        super(context, resource, objects);
    }
}
