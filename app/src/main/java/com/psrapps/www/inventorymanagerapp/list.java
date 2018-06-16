package com.psrapps.www.inventorymanagerapp;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class list extends AppCompatActivity {
    private static IAdapter a;
    static RecyclerView recyclerView;
    public int price,quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       /* Spinner spinner = findViewById(R.id.spin_id);
        //quantity=parseInt(spinner.getSelectedItem().toString()); //
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                Toast.makeText(list.this, spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });*/
        setSupportActionBar(toolbar);
        //Toast.makeText(this, ((String.valueOf(BScanner.k.size())) ),Toast.LENGTH_SHORT).show();
        if(BScanner.k.size()!=0)
        {
            for(int p=0;p<BScanner.k.size();p++)
            {
                price+=parseInt(BScanner.k.get(p).getPrice());
            }
            load();
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),BScanner.class);
                startActivity(i);
                finish();
            }
        });
    }
    public void pay(View v)
    {
        Intent i = new Intent(this,Digital_payment.class);
        i.putExtra("Price",price);
        i.putExtra("Quantity",quantity);
        startActivity(i);
    }

    public void load()
    {
        //Toast.makeText(this,"in load",Toast.LENGTH_LONG).show();
        recyclerView = (RecyclerView)findViewById(R.id.re);
        recyclerView.setHasFixedSize(true);
        a = new IAdapter(BScanner.k);
        recyclerView.setAdapter(a);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //price=price*quantity;                                                                      //new
        TextView total = (TextView)findViewById(R.id.TF_total);
        total.setText(String.valueOf(price));
    }
}
