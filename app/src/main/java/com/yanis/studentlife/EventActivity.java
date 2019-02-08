package com.yanis.studentlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class EventActivity extends SharedMainActivity {
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    evenementAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        db.collection("event").orderBy("date", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<evenement>list=new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                list.add(new evenement(document.getString("name"),document.getString("address"),document.getString("date"),document.getString("phone")));
                            }
                            adapter=new evenementAdapter(EventActivity.this,list);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Log.w("READ_EVENT", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void btn_plus_Click(View view){
        Intent i =new Intent(this,AddEventActivity.class);
        startActivity(i);
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
