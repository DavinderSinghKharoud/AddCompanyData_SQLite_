package com.example.sqlitedemo1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Ref;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView txt1;
    EditText RefID;
    DatabaseHandler mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Setting the textView and editText
        txt1=findViewById(R.id.text1);
        RefID=(EditText)findViewById(R.id.CompanyRefDelete);

        // Creating the database
        mydb = new DatabaseHandler(this);
        mydb.getReadableDatabase();

        //Setting scrollable textView
        txt1.setMovementMethod(new ScrollingMovementMethod());

        //Displaying the all companies details
        displayingALL();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Adding more companies
        if (id == R.id.adding) {
            Intent intent=new Intent(this,MainActivity.class);
            // set the new task and clear flags
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

            return true;
        }

        // Deleting the table
        if (id == R.id.deletingall) {
            mydb.deleteTable();
            update();
            return true;
        }

        // Deleting last row
        if (id == R.id.deletinglastrow) {
            mydb.deleteLastRow();
            update();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Fetching all the details to show it in the view
    private void displayingALL() {

        // Reading all contacts
        List<Companies> contacts = mydb.getAllContacts();
        if (contacts.size()==0) txt1.setText("No records in the Database");

        for (Companies cn : contacts) {
            String log =  "CompanyRef : "+cn.get_CompanyRef()+ "\nFormalName: "+cn.get_FormalName()+"\nCompanyTypeCode : "+cn.get_CompanyTypeCode()
                    +"\n MainAdress  : "+cn.get_MainAdress()+"\nMainPostcode  : "+cn.get_MainPostcode()+" \nReceptionNo  : "+cn.get_ReceptionNo()
                    +" \nWebsiteURL  : "+cn.get_WebsiteURL()+"\n Customer  : "+cn.get_Customer()+"\n Supplier  : "+cn.get_Supplier()+
                    "\n Compaynotes : "+cn.get_Companynotes()+"\n\n";
            txt1.append(log+ "\n");
        }

    }

    // Setting the textView empty and then displaying all the details
    public void update(){
        txt1.setText("");
        displayingALL();

    }

    // Delete specific company by providing the CompanyRef(ID)
    public void DeleteSpecificCompany(View view) {
        String CompanyRef=RefID.getText().toString();
        mydb.deleteRow(CompanyRef);
        update();
    }
}
