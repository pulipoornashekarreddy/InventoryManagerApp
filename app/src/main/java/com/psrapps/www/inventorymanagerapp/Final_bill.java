package com.psrapps.www.inventorymanagerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by poornashekarreddy.p on 05-12-2017.
 */

public class Final_bill extends AppCompatActivity{
    public int price,quantity;
    String p_disp,q_disp;
    TextView p,q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_bill);
        Intent i=getIntent();
        price=i.getIntExtra("Price",0);
        quantity=i.getIntExtra("Quantity",0);
        p=(TextView)findViewById(R.id.TF_price);
        q=(TextView)findViewById(R.id.TF_quantity);
        p_disp=Integer.toString(price);
        q_disp=Integer.toString(quantity);
        p.setText(p_disp);
        q.setText(q_disp);
    }
    public void done(View v)
    {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Are you sure you want to logout?");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in = new Intent(Final_bill.this,Login.class);
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
    public void continue_to_add(View v)
    {
        Intent i = new Intent(this,list.class);
        startActivity(i);
    }
}
