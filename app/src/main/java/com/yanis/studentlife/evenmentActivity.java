package com.yanis.studentlife;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

public class evenmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenment);
    }

    public void btn_plus_Click(View view){
        Intent i =new Intent(this,AddEventActivity.class);
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
