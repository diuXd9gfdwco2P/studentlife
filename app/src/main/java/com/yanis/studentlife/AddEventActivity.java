package com.yanis.studentlife;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class AddEventActivity extends AppCompatActivity {
    EditText name,address,phone,date;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }
    public void addEvent(View view){
        final Intent i = new Intent(this, EventActivity.class);
        name=(EditText)findViewById(R.id.txtNameEventCreate);
        address=(EditText)findViewById(R.id.txtPlaceEventCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhoneEventCreate);
        date=(EditText)findViewById(R.id.txtDateEventCreate);
        final Map<String,Object> addEvent=new HashMap<>();
        addEvent.put("name",name.getText().toString());
        addEvent.put("address",address.getText().toString());
        addEvent.put("phone",phone.getText().toString());
        addEvent.put("date",date.getText().toString());
        addEvent.put("userID",currentuser);
        db.collection("event").add(addEvent).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddEventActivity.this,"Evenement ajouté avec succès "+documentReference.getId(),Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddEventActivity.this,"Evenement non ajouté!!!veuillez réessayer",Toast.LENGTH_LONG).show();
                    }
                });
        db.collection("home").add(addEvent).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddEventActivity.this,"Evenement ajouté avec succès "+documentReference.getId(),Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddEventActivity.this,"Evenement non ajouté!!!veuillez réessayer",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
