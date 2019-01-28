package com.yanis.studentlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddEventActivity extends AppCompatActivity {
    private EditText nameEvent=(EditText)findViewById(R.id.txtNameEventCreate);
    private EditText descriptionEvent=(EditText)findViewById(R.id.txtDescriptionEventCreate);
    private EditText placeEvent=(EditText)findViewById(R.id.txtPlaceEventCreate);
    private EditText phoneEvent=(EditText)findViewById(R.id.txtNumberPhoneEventCreate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }
}
