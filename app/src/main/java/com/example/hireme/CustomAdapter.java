package com.example.hireme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name, email, telephone, address, skill, rate;

    CustomAdapter(Context context,
                  ArrayList name,
                  ArrayList email,
                  ArrayList telephone,
                  ArrayList address,
                  ArrayList skill,
                  ArrayList rate){
        this.context = context;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.skill = skill;
        this.rate = rate;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.telephone_txt.setText(String.valueOf(telephone.get(position)));
        holder.address_txt.setText(String.valueOf(address.get(position)));
        holder.skill_txt.setText(String.valueOf(skill.get(position)));
        holder.rate_txt.setText(String.valueOf(rate.get(position)));


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_txt, email_txt, telephone_txt, address_txt, skill_txt, rate_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.name_txt);
            email_txt = itemView.findViewById(R.id.email_txt);
            telephone_txt = itemView.findViewById(R.id.telephone_txt);
            address_txt = itemView.findViewById(R.id.address_txt);
            skill_txt = itemView.findViewById(R.id.skill_txt);
            rate_txt = itemView.findViewById(R.id.rate_txt);


        }
    }


}
