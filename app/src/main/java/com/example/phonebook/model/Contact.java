package com.example.phonebook.model;

public class Contact {
    private String mName;
    private String mPhonenumber;
    private String mimage;
    public Contact(String mName, String mPhonenumber,String mimage) {
        this.mName = mName;
        this.mPhonenumber = mPhonenumber;
        this.mimage=mimage;
    }
    public String getmName() {
        return mName;
    }

    public String getmPhonenumber() {
        return mPhonenumber;
    }

    public String getmImage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage;
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
