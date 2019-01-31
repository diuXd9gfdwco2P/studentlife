package com.yanis.studentlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlanActivity extends AppCompatActivity {

    EditText name,address,phone,date;

    DataBaseHelperPlan myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        myDb=new DataBaseHelperPlan(this);
        name=(EditText)findViewById(R.id.txtNameEventCreate);
        address=(EditText)findViewById(R.id.txtPlaceEventCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhoneEventCreate);
        date=(EditText)findViewById(R.id.txtDateEventCreate);
    }

    public void addEvent(View view){
        boolean isInserted=myDb.insertData(name.getText().toString(),address.getText().toString(),phone.getText().toString(),date.getText().toString());
        if(isInserted==true){
            Toast.makeText(AddPlanActivity.this,"DATA inserted",Toast.LENGTH_LONG).show();
            Intent i =new Intent(AddPlanActivity.this,planActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(AddPlanActivity.this,"DATA not inserted!!!",Toast.LENGTH_LONG).show();

        }
    }
}
