package com.yanis.studentlife;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddOfferActivity extends AppCompatActivity {
    //private EditText nameOffer=(EditText)findViewById(R.id.txtNameOfferCreate);
   // private EditText nameEntreprise=(EditText)findViewById(R.id.txtNameEntrepriseOfferCreate);
   // private EditText placeEvent=(EditText)findViewById(R.id.txtPlaceOfferCreate);
   // private EditText phoneEvent=(EditText)findViewById(R.id.txtNumberPhoneOfferCreate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
    }

    /**
     *
     * @param view on click view.
     */
    public void onCreateOffer(View view) {
        FirebaseFirestore mDatabase = FirebaseFirestore.getInstance();
        TextView textNameEntrepriseOffer = findViewById(R.id.textNameEntrepriseOffer);
        TextView textNameOffer = findViewById(R.id.textNameOffer);
        CalendarView calendarView = findViewById(R.id.calendarOffer);
        TextView textPlaceOffer = findViewById(R.id.textPlaceOffer);
        TextView textNumberPhoneOffer = findViewById(R.id.textNumberPhoneOffer);
        int calendarOffer = calendarView.getDateTextAppearance();
        Map<String, Object> event = new HashMap<>();
        event.put("textNameEntrepriseOffer", textNameEntrepriseOffer.getText().toString());
        event.put("textNameOffer", textNameOffer.getText().toString());
        event.put("dateEvent", calendarOffer);
        event.put("textPlaceOffer", textPlaceOffer.getText().toString());
        event.put("textNumberPhoneOffer", textNumberPhoneOffer.getText().toString());
        mDatabase.collection("offer")
                .add(event)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.i("tag_firebase", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("tag_faillure", "error adding document", e);
                    }
                });
    }
}
