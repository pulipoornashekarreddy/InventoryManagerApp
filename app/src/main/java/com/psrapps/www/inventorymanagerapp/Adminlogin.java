package com.psrapps.www.inventorymanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by poornashekarreddy.p on 08-01-2018.
 */

public class Adminlogin extends AppCompatActivity{
    EditText username,password;
    String a1,b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);
        username = (EditText) findViewById(R.id.un_admin);
        password = (EditText) findViewById(R.id.ps_admin);
    }
    public void onClick_admin(View v)
    {
        if(v.getId()==R.id.button_admin) {

            a1 = username.getText().toString();
            b1 = password.getText().toString();
            Intent i = new Intent(this, AddItem.class);
            i.putExtra("name", a1);
            i.putExtra("pass", b1);
            startActivity(i);
        }
        else if(v.getId()==R.id.signup_button_admin)
        {
            Intent i = new Intent(this,Adminsignup.class);
            startActivity(i);
        }
    }
}
