package com.yanis.studentlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddOfferActivity extends AppCompatActivity {
    EditText name,address,phone,date;

    DataBaseHelperOffer myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);

        myDb=new DataBaseHelperOffer(this);
        name=(EditText)findViewById(R.id.txtNameOfferCreate);
        address=(EditText)findViewById(R.id.txtPlaceOfferCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhoneOfferCreate);
        date=(EditText)findViewById(R.id.txtDateOfferCreate);
    }

    public void addOffer(View view){
        boolean isInserted=myDb.insertData(name.getText().toString(),address.getText().toString(),phone.getText().toString(),date.getText().toString());
        if(isInserted==true){
            Toast.makeText(AddOfferActivity.this,"DATA inserted",Toast.LENGTH_LONG).show();
            Intent i =new Intent(AddOfferActivity.this,offerActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(AddOfferActivity.this,"DATA not inserted!!!",Toast.LENGTH_LONG).show();

        }
    }
}
