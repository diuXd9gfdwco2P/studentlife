package com.yanis.studentlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;


public class EventActivity extends SharedMainActivity {
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    evenementAdapter adapter;
    private String token;



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
                                list.add(new evenement(document.getString("name"),document.getString("address"),document.getString("date"),document.getString("phone"),document.getString("userID")));
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

    public void subscribe(View view){
        Button button=(Button) findViewById(R.id.subscribe);
        Log.i("TEST", "suscribe: "+ button.getContentDescription());
        //TODO
        Message message = Message.builder()
                .putData("Titre", "Notification")
                .putData("Message", "Un utilisateur s'est inscrit à votre evenement")
                .setToken(token)
                .build();
        String response = FirebaseMessaging.getInstance().send(message);



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
