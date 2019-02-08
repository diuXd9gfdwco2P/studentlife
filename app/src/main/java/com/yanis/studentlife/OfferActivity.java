package com.yanis.studentlife;

import android.content.Intent;
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

public class OfferActivity extends SharedMainActivity {

    FirebaseFirestore db=FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    OfferAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewOffer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db.collection("Offre").orderBy("date", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<offer> list=new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                list.add(new offer(document.getString("name"),document.getString("address"),document.getString("date"),document.getString("phone")));
                            }
                            adapter=new OfferAdapter(OfferActivity.this,list);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Log.w("READ_OFFER", "Error getting documents.", task.getException());
                        }
                    }
        });
    }

    public void btn_plus_Click(View view){
        Intent i =new Intent(this,AddOfferActivity.class);
        startActivity(i);
    }
}
