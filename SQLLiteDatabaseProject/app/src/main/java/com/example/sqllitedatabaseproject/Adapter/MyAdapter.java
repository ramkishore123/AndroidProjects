package com.example.sqllitedatabaseproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllitedatabaseproject.Model.Contact;
import com.example.sqllitedatabaseproject.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    private  List<Contact> list;
    Context context;

    public MyAdapter(List<Contact> list, Context context) {
        this.list = list;
        this.context=context;
    }

    public MyAdapter(List<Contact> contacts) {
        this.list=contacts;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list,parent,false);

        MyviewHolder holder= new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Log.d("MyAdapter", "onBindViewHolder: "+position);
        holder.tv_id.setText("ID: "+ list.get(position).getID()+ " ");
        holder.tv_name.setText("Name: "+list.get(position).getName().toString());
        holder.tv_phoneNumber.setText("phone number "+list.get(position).getPhoneNumber().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{

        TextView tv_id,tv_name,tv_phoneNumber;
        LinearLayout root;
        //send broadcast message to the mainactivity with same constant value
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id=itemView.findViewById(R.id.tv_id);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_phoneNumber=itemView.findViewById(R.id.tv_phoneNumber);
            root=itemView.findViewById(R.id.root);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id= tv_id.getText().toString();
                    String name= tv_name.getText().toString();
                    String phoneNumber=tv_phoneNumber.getText().toString();


                    Intent intent=new Intent();
                    intent.setAction("SELECTEDROW");
                    intent.putExtra("id",id);
                    intent.putExtra("name", name);
                    intent.putExtra("phoneNumber",phoneNumber);
                    context.sendBroadcast(intent);

                }
            });
        }
    }
}
