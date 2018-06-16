package com.psrapps.www.inventorymanagerapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Created by poornashekarreddy.p on 06-12-2017.
 */

public class IAdapter extends RecyclerView.Adapter<IHolder> {
    public IAdapter(ArrayList<IModel> k) {
        this.k = k;
    }
    public ArrayList<IModel> k = new ArrayList();
    @Override
    public IHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new IHolder(view);
    }

    @Override
    public void onBindViewHolder(IHolder holder, int position) {
        final IModel kk = k.get(position);
        holder.UpdateUI(kk);
    }


    @Override
    public int getItemCount() {
        return k.size();
    }
}
