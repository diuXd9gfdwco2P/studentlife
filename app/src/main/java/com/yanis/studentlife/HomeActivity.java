package com.yanis.studentlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    RecyclerView recyclerView;
    HomeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewHome);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db.collection("home")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<evenement>list=new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                list.add(new evenement(document.getString("name"),document.getString("address"),document.getString("date"),document.getString("phone")));
                            }
                            adapter=new HomeAdapter(HomeActivity.this,list);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Log.w("READ_EVENT", "Error getting documents.", task.getException());
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
