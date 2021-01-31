package com.example.fibonacciapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    private  final ArrayList list;

    public MyAdapter(ArrayList list) {
        this.list = list;
    }

    public void addItem(int i){
        this.list.add(i);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        MyviewHolder holder= new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Log.d("MyAdapter", "onBindViewHolder: "+position);
        holder.tv_number.setText(list.get(position).toString());
        Log.d("MyAdapter", "onBindViewHolder: "+holder.tv_number.getText().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{

        TextView tv_number;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_number=itemView.findViewById(R.id.tv_item_name);
        }
    }
}
