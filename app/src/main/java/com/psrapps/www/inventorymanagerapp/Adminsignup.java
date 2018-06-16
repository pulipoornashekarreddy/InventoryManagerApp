package com.psrapps.www.inventorymanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by poornashekarreddy.p on 08-01-2018.
 */

public class Adminsignup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminsignup);
    }

    public void enter_signup_admin(View v)
    {
        Intent i = new Intent(this,Adminlogin.class);
        startActivity(i);
    }
}
