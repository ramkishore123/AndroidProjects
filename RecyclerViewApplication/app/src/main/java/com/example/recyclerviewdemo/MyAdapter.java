package com.example.recyclerviewdemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.model.Email;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    private final ArrayList<Email> list;
    private IRecyclerViewItemClickListener listener;

    public MyAdapter(ArrayList<Email> list, IRecyclerViewItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyviewHolder holder = new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Log.d("MyAdapter", "onBindViewHolder: " + position);
        holder.tv_sender_name.setText(list.get(position).getSenderName());
        holder.tv_subject.setText(list.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {


        TextView tv_sender_name;
        TextView tv_subject;
        RelativeLayout root;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sender_name = itemView.findViewById(R.id.tv_item_name);
            tv_subject = itemView.findViewById(R.id.tv_item_currency);
            root=itemView.findViewById(R.id.root);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(list.get(getAdapterPosition()));
                }
            });

        }
    }
}
