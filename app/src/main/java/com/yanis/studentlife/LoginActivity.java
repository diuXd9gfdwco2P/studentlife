package com.yanis.studentlife;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmailAddress=(EditText) findViewById(R.id.txtEmailLogin);
        txtPassword=(EditText) findViewById(R.id.txtPasswordLogin);
        firebaseAuth=FirebaseAuth.getInstance();
    }


    public void btnUserLogin_Click(View view){

        final ProgressDialog progressDialog=ProgressDialog.show(LoginActivity.this,"Please wait ...!!!","Processing ...",true);
        firebaseAuth.signInWithEmailAndPassword(txtEmailAddress.getText().toString(),txtPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();


                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(LoginActivity.this,HomeActivity.class);
                            i.putExtra("LoginActivity", LoginActivity.class.toString());
                            startActivity(i);

                        }else{
                            Log.e("ERROR",task.getException().toString());
                            Toast.makeText(LoginActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
