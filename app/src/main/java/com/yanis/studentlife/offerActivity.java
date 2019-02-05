package com.yanis.studentlife;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class offerActivity extends SharedMainActivity {

    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        db.collection("Offer")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("READ_OFFER", document.getId() + " => " + document.getData());
                            }
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
