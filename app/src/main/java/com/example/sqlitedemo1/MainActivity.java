package com.example.sqlitedemo1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    DatabaseHandler mydb;

    EditText FormalName;
    EditText CompanyTypeCode;
    EditText MainAddress;
    EditText MainPostCode;
    EditText ReceptionNo;
    EditText WebsiteURL;
    EditText Customer;
    EditText Supplier;
    EditText Companynotes;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting setting all the editTexts
        FormalName = (EditText) findViewById(R.id.editText1);
        CompanyTypeCode = (EditText) findViewById(R.id.editText2);
        MainAddress = (EditText) findViewById(R.id.editText3);
        MainPostCode = (EditText) findViewById(R.id.editText4);
        ReceptionNo = (EditText) findViewById(R.id.editText5);
        WebsiteURL = (EditText) findViewById(R.id.editText6);
        Customer = (EditText) findViewById(R.id.editText7);
        Supplier = (EditText) findViewById(R.id.editText8);
        Companynotes = (EditText) findViewById(R.id.editText9);


        mydb = new DatabaseHandler(this);
        mydb.getReadableDatabase();

    }


    // When user click on the Submit button
    public void SubmitDetails(View view) {
        mydb.addContact(FormalName.getText().toString(), CompanyTypeCode.getText().toString(), MainAddress.getText().toString(),
                MainPostCode.getText().toString(), ReceptionNo.getText().toString(),
                WebsiteURL.getText().toString(), Customer.getText().toString(), Supplier.getText().toString(),
                Companynotes.getText().toString());

        Toast.makeText(this, "Company Added", Toast.LENGTH_SHORT).show();

    }

    // Setting the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.ShowCompanies) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
