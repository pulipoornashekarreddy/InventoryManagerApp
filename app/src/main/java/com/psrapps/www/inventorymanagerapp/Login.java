package com.psrapps.www.inventorymanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText username,password;
    String a1,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.un);
        password = (EditText) findViewById(R.id.ps);
    }

    public void onClick(View v)
    {
        if(v.getId()==R.id.button) {

            a1 = username.getText().toString();
            b1 = password.getText().toString();
            Intent i = new Intent(this, list.class);
            i.putExtra("name", a1);
            i.putExtra("pass", b1);
            startActivity(i);
        }
        else if(v.getId()==R.id.signup_button)
        {
            Intent i = new Intent(this,Signup.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.admin_button)
        {
            Intent i=new Intent(this,Adminlogin.class);
            startActivity(i);
        }
    }

}
