package com.yanis.studentlife;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

public abstract class SharedMainActivity extends AppCompatActivity {
    /**
     * On click home button.
     *
     * @param view view to display.
     */
    public void btn_home_Click(View view){
        if(!this.getClass().getName().equals(HomeActivity.class.getName())) {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
    }

    /**
     * On click event button.
     *
     * @param view Offer to display.
     */
    public void btn_event_Click(View view){
        if(!this.getClass().getName().equals(EventActivity.class.getName())) {
            Intent i = new Intent(this, EventActivity.class);
            startActivity(i);
        }
    }

    /**
     * On click home button.
     *
     * @param view Offer to display.
     */
    public void btn_offer_Click(View view){
        if(!this.getClass().getName().equals(OfferActivity.class.getName())) {
            Intent i = new Intent(this, OfferActivity.class);
            startActivity(i);
        }
    }

    /**
     * On click plan button.
     *
     * @param view view to display.
     */
    public void btn_plan_Click(View view){
        if(!this.getClass().getName().equals(planActivity.class.getName())) {
            Intent i = new Intent(this, planActivity.class);
            startActivity(i);
        }
    }
}
