package com.psrapps.www.inventorymanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by poornashekarreddy.p on 05-12-2017.
 */

public class Digital_payment extends AppCompatActivity{
    public int price,quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digital_payment);
        Intent i=getIntent();
        price=i.getIntExtra("Price",0);
        quantity=i.getIntExtra("Quantity",0);
    }
    public void bill(View v)
    {
        Intent i = new Intent(this,Final_bill.class);
        i.putExtra("Price",price);
        i.putExtra("Quantity",quantity);
        startActivity(i);
    }
}
