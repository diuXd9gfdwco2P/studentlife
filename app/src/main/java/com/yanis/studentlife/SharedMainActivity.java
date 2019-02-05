package com.yanis.studentlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class SharedMainActivity extends AppCompatActivity {

    /**
     * On click home button.
     *
     * @param view view to display.
     */
    public void btn_home_Click(View view){
        Intent i =new Intent(this,HomeActivity.class);
        startActivity(i);
    }

    /**
     * On click event button.
     *
     * @param view offer to display.
     */
    public void btn_event_Click(View view){
        Intent i =new Intent(this,evenmentActivity.class);
        startActivity(i);
    }

    /**
     * On click home button.
     *
     * @param view offer to display.
     */
    public void btn_offer_Click(View view){
        Intent i =new Intent(this,offerActivity.class);
        startActivity(i);
    }

    /**
     * On click plan button.
     *
     * @param view view to display.
     */
    public void btn_plan_Click(View view){
        Intent i =new Intent(this,planActivity.class);
        startActivity(i);
    }

}
