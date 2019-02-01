package com.yanis.studentlife;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddEventActivity extends AppCompatActivity {
    //private EditText nameEvent=(EditText)findViewById(R.id.txtNameEventCreate);
    //private EditText descriptionEvent=(EditText)findViewById(R.id.txtDescriptionEventCreate);
    //private EditText placeEvent=(EditText)findViewById(R.id.txtPlaceEventCreate);
    //private EditText phoneEvent=(EditText)findViewById(R.id.txtNumberPhoneEventCreate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    /**
     *
     * @param view
     */
    public void onCreateEvent(View view) {
        FirebaseFirestore mDatabase = FirebaseFirestore.getInstance();
        TextView eventName = findViewById(R.id.txtNameEventCreate);
        CalendarView calendarView = findViewById(R.id.calendarEventCreate);
        TextView textDescriptionEvent= findViewById(R.id.textDescriptionEvent);
        TextView textPlaceEvent = findViewById(R.id.textPlaceEvent);
        TextView textNumberPhoneEvent = findViewById(R.id.textNumberPhoneEvent);
        int enventDate = calendarView.getDateTextAppearance();
        Map<String, Object> event = new HashMap<>();
        event.put("eventName", eventName.getText().toString());
        event.put("dateEvent", enventDate);
        event.put("textDescriptionEvent", textDescriptionEvent.getText().toString());
        event.put("textPlaceEvent", textPlaceEvent.getText().toString());
        event.put("textNumberPhoneEvent", textNumberPhoneEvent.getText().toString());
        mDatabase.collection("event")
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
