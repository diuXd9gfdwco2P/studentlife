package com.yanis.studentlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddOfferActivity extends AppCompatActivity {
    private EditText nameOffer=(EditText)findViewById(R.id.txtNameOfferCreate);
    private EditText nameEntreprise=(EditText)findViewById(R.id.txtNameEntrepriseOfferCreate);
    private EditText placeEvent=(EditText)findViewById(R.id.txtPlaceOfferCreate);
    private EditText phoneEvent=(EditText)findViewById(R.id.txtNumberPhoneOfferCreate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
    }
}
