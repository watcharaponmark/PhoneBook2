package com.example.phonebook.Adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phonebook.R;
import com.example.phonebook.model.Contact;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//สร้าง adapter เอง
public class ContactListAdapte extends ArrayAdapter<Contact>{
    private static final String TAG=ContactListAdapte.class.getSimpleName();
    private Context  mcontext;
    private  int mLayoutresourceId;
    private ArrayList<Contact> mcontactArrayList;

    public ContactListAdapte(Context context, int resource,ArrayList<Contact> contactsList) {
        super(context, resource, contactsList);
        this.mcontext=context;
        this.mLayoutresourceId=resource;
        this.mcontactArrayList=contactsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        View itemLayout = convertView;
               if(itemLayout == null){
                  itemLayout = View.inflate(mcontext,mLayoutresourceId,null);
               }
        ImageView imageView=(ImageView) itemLayout.findViewById(R.id.image);
        TextView textView=(TextView)itemLayout.findViewById(R.id.text);
        TextView tvPhone=(TextView)itemLayout.findViewById(R.id.textView_phone);
        Contact contact=mcontactArrayList.get(position);
        String  contactImage=contact.getmImage();
        AssetManager am=mcontext.getAssets();
        try {
           InputStream stream= am.open(contactImage);
            Drawable Imagedrawable=Drawable.createFromStream(stream,null);
            imageView.setImageDrawable(Imagedrawable);

        } catch (IOException e) {

            e.printStackTrace();
            Log.e(TAG,"เปิดไฟล์ image "+contactImage+" ไม่ได้");

        }


        textView.setText(contact.getmName());
        tvPhone.setText(contact.getmPhonenumber());

        /*  if("android".equals(contact.getmName())) {
            imageView.setImageResource(R.drawable.ic_android);
        }else if("ios".equals(contact.getmName())){
            imageView.setImageResource(R.drawable.ic_ios);

        }else if("windows".equals(contact.getmName())){
            imageView.setImageResource(R.drawable.ic_win);
        }else if("linux".equals(contact.getmName())){
            imageView.setImageResource(R.drawable.ic_linux);
        }else if("osx".equals(contact.getmName())){
            imageView.setImageResource(R.drawable.ic_osx);
        }else if("asus".equals(contact.getmName())){
            imageView.setImageResource(R.drawable.ic_asus);
        }else{
            imageView.setImageResource(R.drawable.ic_dell);
        }*/


        return itemLayout;
    }
/*
   @Override
    public int getCount() {
        return 10;
    }
    */
}
