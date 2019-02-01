package com.yanis.studentlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class planActivity extends AppCompatActivity {



    DataBaseHelperPlan myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenment);
        myDb=new DataBaseHelperPlan(this);

        Cursor res=myDb.getAllData();
        if(res.getCount()==0){
            showMessage("Plans","Aucun plan n'est disponible");
        }
        StringBuffer buffer =new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("name : "+res.getString(1)+"\n");
            buffer.append("Address : "+res.getString(2)+"\n");
            buffer.append("Phone : "+res.getString(3)+"\n");
            buffer.append("Date : "+res.getString(4)+"\n\n\n");
        }
        showMessage("Plan",buffer.toString());
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void btn_plus_Click(View view){
        Intent i =new Intent(this,AddPlanActivity.class);
        startActivity(i);
    }

    public void btn_home_Click(View view){
        Intent i =new Intent(this,HomeActivity.class);
        startActivity(i);
    }
    public void btn_evenment_Click(View view){
        Intent i =new Intent(this,evenmentActivity.class);
        startActivity(i);
    }
    public void btn_offer_Click(View view){
        Intent i =new Intent(this,offerActivity.class);
        startActivity(i);
    }
    public void btn_plan_Click(View view){
        Intent i =new Intent(this,planActivity.class);
        startActivity(i);
    }
}
