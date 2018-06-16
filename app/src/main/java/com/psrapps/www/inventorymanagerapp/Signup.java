package com.psrapps.www.inventorymanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by poornashekarreddy.p on 05-12-2017.
 */

public class Signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void enter_signup(View v)
    {
        Intent i = new Intent(this,list.class);
        startActivity(i);
    }
}
