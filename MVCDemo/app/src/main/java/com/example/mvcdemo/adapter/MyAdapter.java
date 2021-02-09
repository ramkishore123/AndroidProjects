package com.example.mvcdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvcdemo.MainActivity;
import com.example.mvcdemo.Model.Country;
import com.example.mvcdemo.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Country> list;
private MainActivity activity;
    public MyAdapter(MainActivity activity, List<Country> list) {
        this.activity=activity;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
     MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.countryName.setText(list.get(position).countryName);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder  extends RecyclerView.ViewHolder{

        private TextView countryName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName=itemView.findViewById(R.id.tv_country);
        }
    }
}
