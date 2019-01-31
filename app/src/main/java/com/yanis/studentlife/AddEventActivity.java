package com.yanis.studentlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEventActivity extends AppCompatActivity {
    EditText name,address,phone,date;

    DataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        myDb=new DataBaseHelper(this);
        name=(EditText)findViewById(R.id.txtNameEventCreate);
        address=(EditText)findViewById(R.id.txtPlaceEventCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhoneEventCreate);
        date=(EditText)findViewById(R.id.txtDateEventCreate);
    }

    public void addEvent(View view){
        boolean isInserted=myDb.insertData(name.getText().toString(),address.getText().toString(),phone.getText().toString(),date.getText().toString());
        if(isInserted==true){
            Toast.makeText(AddEventActivity.this,"DATA inserted",Toast.LENGTH_LONG).show();
            Intent i =new Intent(AddEventActivity.this,evenmentActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(AddEventActivity.this,"DATA not inserted!!!",Toast.LENGTH_LONG).show();

        }
    }
}
