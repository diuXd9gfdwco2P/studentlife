package com.yanis.studentlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    @Override
    public void onBackPressed() {
        Bundle bundle = getIntent().getExtras();

        if (bundle.getString("LoginActivity").equals(LoginActivity.class.toString())) {
            return;
        }
        else{
            super.onBackPressed();
        }
    }
}
