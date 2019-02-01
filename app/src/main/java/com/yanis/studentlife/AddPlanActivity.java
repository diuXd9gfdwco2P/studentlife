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

public class AddPlanActivity extends AppCompatActivity {
    //private EditText namePlan=(EditText)findViewById(R.id.txtNamePlanCreate);
   // private EditText descriptionPlan=(EditText)findViewById(R.id.txtDescriptionPlanCreate);
   // private EditText placePlan=(EditText)findViewById(R.id.txtPlacePlanCreate);
   // private EditText phonePlan=(EditText)findViewById(R.id.txtph);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
    }

    /**
     *
     * @param view on click view.
     */
    public void onCreatePlan(View view) {
        FirebaseFirestore mDatabase = FirebaseFirestore.getInstance();
        TextView planName = findViewById(R.id.textNamePlan);
        CalendarView calendarView = findViewById(R.id.calendarPlan);
        TextView textDescriptionPlan = findViewById(R.id.textDescriptionPlan);
        TextView textPlacePlan = findViewById(R.id.textPlacePlan);
        TextView textNumberPhonePlan = findViewById(R.id.textNumberPhonePlan);
        int planDate = calendarView.getDateTextAppearance();
        Map<String, Object> event = new HashMap<>();
        event.put("planName", planName.getText().toString());
        event.put("dateEvent", planDate);
        event.put("textDescriptionPlan", textDescriptionPlan.getText().toString());
        event.put("textPlacePlan", textPlacePlan.getText().toString());
        event.put("textNumberPhonePlan", textNumberPhonePlan.getText().toString());
        mDatabase.collection("plan")
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
