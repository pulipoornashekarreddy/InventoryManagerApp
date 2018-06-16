package com.psrapps.www.inventorymanagerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by poornashekarreddy.p on 09-01-2018.
 */

public class AddConfirmation extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addconfirmation);
    }
    public void keep_adding(View v)
    {
        Intent i = new Intent(this,AddItem.class);
        startActivity(i);
    }
    public void logout_admin(View v) {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Are you sure you want to logout?");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in = new Intent(AddConfirmation.this,Login.class);
                startActivity(in);
            }
        });
        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alert = adb.create();
        alert.show();
    }
}
