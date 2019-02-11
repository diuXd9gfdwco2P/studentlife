package com.yanis.studentlife;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;
import java.util.Map;


public class AddEventActivity extends AppCompatActivity {
    EditText name,address,phone,date;

    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }






    public void addEvent(View view){
        final Intent i = new Intent(this,evenmentActivity.class);



        name=(EditText)findViewById(R.id.txtNameEventCreate);
        address=(EditText)findViewById(R.id.txtPlaceEventCreate);
        phone=(EditText)findViewById(R.id.txtNumberPhoneEventCreate);
        date=(EditText)findViewById(R.id.txtDateEventCreate);



        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        final String token;
                        if(task.isSuccessful()) {
                            final Map<String,Object> addEvent=new HashMap<>();
                            addEvent.put("name",name.getText().toString());
                            addEvent.put("address",address.getText().toString());
                            addEvent.put("phone",phone.getText().toString());
                            addEvent.put("date",date.getText().toString());
                            token = task.getResult().getToken();
                            addEvent.put("UserId",token);

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

                            Log.v(TAG, "Token created:" + task.getResult().getToken());
                        } else{
                            Log.v(TAG,"No token");

                        }

                    }

                });


    }
}
