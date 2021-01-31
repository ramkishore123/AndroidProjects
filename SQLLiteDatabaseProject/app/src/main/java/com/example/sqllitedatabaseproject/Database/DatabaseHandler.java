package com.example.sqllitedatabaseproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqllitedatabaseproject.Model.Contact;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableContact="CREATE TABLE " +TABLE_CONTACTS+"("+ KEY_ID + " INTEGER PRIMARY KEY ,"+ KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT "+")";
        db.execSQL(createTableContact);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
        //if it doesnot exist create a new one
        onCreate(db);


    }


    //creating a new contact
    //we create a variable of type Modelclass
     public void addContact(Contact contact){
        //we need to use riteable method to add contacts
        SQLiteDatabase db =this.getWritableDatabase();
         //contentValues object is used to store a value
         ContentValues values= new ContentValues();
         //collect the key/view data to place in db

         //values.put(KEY_ID,contact.getID());

         values.put(KEY_PH_NO,contact.getPhoneNumber());

         values.put(KEY_NAME,contact.getName());

         //no try to put the values collected from the view to db using insert

         db.insert(TABLE_CONTACTS,null,values);
         db.close();




     }





    // code to get all contacts in a list view
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }









}
