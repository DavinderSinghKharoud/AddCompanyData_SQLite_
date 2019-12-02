package com.example.sqlitedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Creating all variables of table
    public static final String Database_Name="CompanyManagement";
    public static final int Database_version=1;

    public static final String Table_Company="Companies";

    public static final String Key_CompanyRef="CompanyRef";
    public static final String Key_Formal_Name="FormalName";
    public static final String Key_CompanyTypeCode="CompanyTypeCode";
    public static final String Key_Address="MainAddress";
    public static final String Key_Postal_Code="MainPostCode";
    public static final String Key_ReceptionNo="ReceptionNo";
    public static final String Key_WebsiteURL="WebsiteURL";
    public static final String Key_Customer="Customer";
    public static final String Key_Supplier="Supplier";
    public static final String Key_Company_notes="Companynotes";


    // Query to create table
    String Create_Table="CREATE TABLE "+Table_Company+
            " ( "+Key_CompanyRef+" Integer PRIMARY KEY, "+
            Key_Formal_Name+" TEXT, "+
            Key_CompanyTypeCode+" TEXT, "+
            Key_Address+" TEXT, "+
            Key_Postal_Code+" TEXT, "+
            Key_ReceptionNo+" TEXT, "+
            Key_WebsiteURL+" TEXT, "+
            Key_Customer+" TEXT, "+
            Key_Supplier+" TEXT, "+
            Key_Company_notes+" TEXT"+
            " )";

    // Query to delete the table
    String Drop_Company_Management="DROP TABLE IF EXISTS "+ Table_Company;


    public DatabaseHandler(Context context) {
        super(context, Database_Name, null,Database_version);
    }

    //Creating the table
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(Create_Table);
    }

    //Deleting the old table and creating new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Drop_Company_Management);
        onCreate(db);

    }


    // Inserting data in table by providing all the details through arguements

    public void addContact(String FormalName, String CompanyTypeCode, String MainAdress, String MainPostcode, String ReceptionNo,
                           String WebsiteURL, String Customer, String Supplier, String Companynotes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Key_Formal_Name,FormalName);
        values.put(Key_CompanyTypeCode,CompanyTypeCode);
        values.put(Key_Address,MainAdress);

        values.put(Key_Postal_Code,MainPostcode);
        values.put(Key_ReceptionNo,ReceptionNo);
        values.put(Key_WebsiteURL,WebsiteURL);

        values.put(Key_Customer,Customer);
        values.put(Key_Supplier,Supplier);
        values.put(Key_Company_notes,Companynotes);

        db.insert(Table_Company,null,values);
        db.close();

    }

    // Fetching all the details of companies and setting them in companies object, In the end returning the list of companies

    public List<Companies> getAllContacts() {
        List<Companies> contactList = new ArrayList<Companies>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Table_Company;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Companies company = new Companies();
                company.set_CompanyRef(Integer.parseInt(cursor.getString(0)));
                company.set_FormalName(cursor.getString(1));
                company.set_CompanyTypeCode(cursor.getString(2));
                company.set_MainAdress(cursor.getString(3));
                company.set_MainPostcode(cursor.getString(4));
                company.set_ReceptionNo(cursor.getString(5));
                company.set_WebsiteURL(cursor.getString(6));
                company.set_Customer(cursor.getString(7));
                company.set_Supplier(cursor.getString(8));
                company.set_Companynotes(cursor.getString(9));

                // Adding contact to list
                contactList.add(company);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }



    // Deleting the table and creating new one
    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(Drop_Company_Management);
        db.execSQL(Create_Table);


    }

    // Deleting the specific row in the table buy providing the id
    public void deleteRow(String value1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + Table_Company+ " WHERE "+Key_CompanyRef+"='"+value1+"'");
        db.close();
    }

    // Delete the last row in the database
    public void deleteLastRow()
    {
        Companies companies = new Companies();
        String selectQuery = "SELECT  * FROM " + Table_Company;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            companies.set_CompanyRef(Integer.parseInt(cursor.getString(0)));

         }
        db.execSQL("DELETE FROM " + Table_Company+ " WHERE "+Key_CompanyRef+"='"+companies.get_CompanyRef()+"'");
        db.close();
    }


}
