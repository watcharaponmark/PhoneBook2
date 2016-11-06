package com.example.phonebook.model;

/**
 * Created by Mark on 10/23/16.
 */
public class Contact {
    private String mName;
    private String mPhonenumber;
    public Contact(String mName, String mPhonenumber) {
        this.mName = mName;
        this.mPhonenumber = mPhonenumber;
    }
    public String getmName() {
        return mName;
    }

    public String getmPhonenumber() {
        return mPhonenumber;
    }

    public void setmName(String mName) {

        this.mName = mName;
    }

    public void setmPhonenumber(String mPhonenumber) {
        this.mPhonenumber = mPhonenumber;
    }

    @Override
    public String toString() {
        return mName;
    }
}
