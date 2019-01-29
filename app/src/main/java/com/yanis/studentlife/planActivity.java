package com.yanis.studentlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class planActivity extends AppCompatActivity {
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference ref=database.getReference().getRoot().child("test");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ref.setValue("Hello, World!");
        // Attach a listener to read the data at our posts reference
        /*ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Plan plan = dataSnapshot.getValue(Plan.class);
                System.out.println(plan.description);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });*/
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
