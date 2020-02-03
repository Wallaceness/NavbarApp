package com.example.android.navigationbarapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private List<Birthstone> stones;
    private LayoutInflater viewInflater;

    MainAdapter(List<Birthstone> datalist, Context context){
        stones=datalist;
        viewInflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myHolder=viewInflater.inflate(R.layout.birthstone_items, parent, false);
        return new MainHolder(myHolder, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        Birthstone stone = stones.get(position);
        holder.myStone= stone;
        holder.nameView.setText(stone.stoneName);
        holder.imageView.setImageResource(stone.imgSrc);
    }

    @Override
    public int getItemCount() {
        return stones.size();
    }

    class MainHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Birthstone myStone;
        LinearLayout parentLayout;
        ImageView imageView;
        TextView nameView;

        final MainAdapter mainAdapter;

        public MainHolder(View itemView, MainAdapter adapt){
            super(itemView);

            parentLayout=itemView.findViewById(R.id.item_parent);
            imageView = itemView.findViewById(R.id.list_image);
            nameView=itemView.findViewById(R.id.list_name);
            this.mainAdapter=adapt;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            BirthstonesDetail detail=new BirthstonesDetail(myStone.stoneName, myStone.imgSrc, myStone.description);
            FragmentTransaction transaction =Birthstones_main.BirthstoneManager.beginTransaction();
            transaction.replace(R.id.birthstones_container, detail).addToBackStack(null).commit();
        }
    }
}
