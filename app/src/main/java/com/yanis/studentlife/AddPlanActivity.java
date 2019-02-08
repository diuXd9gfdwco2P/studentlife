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


public class AddPlanActivity extends AppCompatActivity {


    EditText name,address,phone,date;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
    }
    public void addPlan(View view){
        final Intent i = new Intent(this,planActivity.class);
        name=(EditText)findViewById(R.id.txtNamePlanCreate);
        address=(EditText)findViewById(R.id.txtPlacePlanCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhonePlanCreate);
        date=(EditText)findViewById(R.id.txtDatePlanCreate);
        Map<String,Object> addPlan=new HashMap<>();
        addPlan.put("name",name.getText().toString());
        addPlan.put("address",address.getText().toString());
        addPlan.put("phone",phone.getText().toString());
        addPlan.put("date",date.getText().toString().replaceAll("/","").replaceAll("-",""));
        addPlan.put("userID",currentuser);
        db.collection("plan").add(addPlan).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddPlanActivity.this,"Plan ajouté avec succès "+documentReference.getId(),Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddPlanActivity.this,"Plan non ajouté!!!veuillez réessayer",Toast.LENGTH_LONG).show();
                    }
                });
        db.collection("home").add(addPlan).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddPlanActivity.this,"Plan ajouté avec succès "+documentReference.getId(),Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddPlanActivity.this,"Plan non ajouté!!!veuillez réessayer",Toast.LENGTH_LONG).show();
                    }
                });

    }
}
