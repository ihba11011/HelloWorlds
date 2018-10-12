package com.example.hp.helloworld;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Recyclerview> {
    private ArrayList<String> data;

    TextView txttitle;

    public RecyclerAdapter(ArrayList<String> data){
        this.data=data;
    }
    @NonNull
    @Override
    public Recyclerview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout, parent, false);
        return new Recyclerview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview holder, int position) {
        String title= data.get(position);
        holder.txttitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Recyclerview extends RecyclerView.ViewHolder {
        TextView txttitle;
        public Recyclerview(@NonNull View itemView) {
            super(itemView);
            txttitle=itemView.findViewById(R.id.txttitle);
        }
    }
}
