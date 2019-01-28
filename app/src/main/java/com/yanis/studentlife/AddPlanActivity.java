package com.yanis.studentlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddPlanActivity extends AppCompatActivity {
    private EditText namePlan=(EditText)findViewById(R.id.txtNamePlanCreate);
    private EditText descriptionPlan=(EditText)findViewById(R.id.txtDescriptionPlanCreate);
    private EditText placePlan=(EditText)findViewById(R.id.txtPlacePlanCreate);
    private EditText phonePlan=(EditText)findViewById(R.id.txtNumberPhonePlanCreate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
    }
}
