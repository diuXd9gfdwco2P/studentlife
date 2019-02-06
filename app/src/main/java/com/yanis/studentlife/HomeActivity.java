package com.yanis.studentlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends SharedMainActivity {
    FirebaseFirestore db=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db.collection("event")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("READ_EVENT", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("READ_EVENT", "Error getting documents.", task.getException());
                        }
                    }
                });
        db.collection("Offer")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("READ_Offer", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("READ_Offer", "Error getting documents.", task.getException());
                        }
                    }
                });
        db.collection("plan")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("READ_Plan", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("READ_Plan", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
    @Override
    public void onBackPressed() {
        Bundle bundle = getIntent().getExtras();

        if (bundle.getString("LoginActivity").equals(LoginActivity.class.toString())) {
            return;
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }
}
