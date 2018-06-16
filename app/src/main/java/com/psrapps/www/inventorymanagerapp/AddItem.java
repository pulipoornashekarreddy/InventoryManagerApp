package com.psrapps.www.inventorymanagerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by poornashekarreddy.p on 08-01-2018.
 */

public class AddItem extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);
    }
    public void scan(View v)
    {
            Intent i = new Intent(this,BScanner.class);
            startActivity(i);
    }
    public void proceed(View v)
    {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Confirm addition");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in = new Intent(AddItem.this,AddConfirmation.class);
                startActivity(in);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alert = adb.create();
        alert.show();
    }
}
