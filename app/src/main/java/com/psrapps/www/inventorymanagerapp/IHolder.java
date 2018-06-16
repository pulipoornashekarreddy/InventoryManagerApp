package com.psrapps.www.inventorymanagerapp;

import android.app.Application;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by poornashekarreddy.p on 06-12-2017.
 */

public class IHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private Spinner count;
    private TextView price;

    public IHolder(View itemView) {
        super(itemView);
        this.name=(TextView)itemView.findViewById(R.id.item_name);
        this.price=(TextView)itemView.findViewById(R.id.item_price);
        this.count=(Spinner)itemView.findViewById(R.id.spin_id);
    }

    public void UpdateUI(IModel a)
    {
        name.setText(a.getName());
        price.setText(a.getPrice());
        int b = Integer.parseInt(a.getQuantity());
        List<String> c=new ArrayList<String>();
        for(int d=1;d<=b;d++)
        {
            c.add(String.valueOf(d));
        }
        ArrayAdapter<String> price = new ArrayAdapter<String>(itemView.getContext(),android.R.layout.simple_list_item_1,c);
        count.setAdapter(price);
    }
}
