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


public class AddOfferActivity extends AppCompatActivity {

    EditText name,address,phone,date;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
    }
    public void addOffer(View view){
        final Intent i = new Intent(this, OfferActivity.class);
        name=(EditText)findViewById(R.id.txtNameOfferCreate);
        address=(EditText)findViewById(R.id.txtPlaceOfferCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhoneOfferCreate);
        date=(EditText)findViewById(R.id.txtDateOfferCreate);
        Map<String,Object> addOffer=new HashMap<>();
        addOffer.put("name",name.getText().toString());
        addOffer.put("address",address.getText().toString());
        addOffer.put("phone",phone.getText().toString());
        addOffer.put("date",date.getText().toString());
        addOffer.put("userID",currentuser);
        db.collection("Offre").add(addOffer).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddOfferActivity.this,"Offre ajoutée avec succès "+documentReference.getId(),Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddOfferActivity.this,"Offre non ajoutée!!!veuillez réessayer",Toast.LENGTH_LONG).show();
                    }
                });
        db.collection("home").add(addOffer).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddOfferActivity.this,"Offre ajoutée avec succès "+documentReference.getId(),Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddOfferActivity.this,"Offre non ajoutée!!!veuillez réessayer",Toast.LENGTH_LONG).show();
                    }
                });

    }
}
