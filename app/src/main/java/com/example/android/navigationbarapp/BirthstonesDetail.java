package com.example.android.navigationbarapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthstonesDetail extends Fragment {
    private TextView nameView;
    private TextView descriptionView;
    private ConstraintLayout detailParent;
    private Button backButton;
    private String name;
    private int image;
    private String description;
    private FragmentManager manager;

    public BirthstonesDetail(){

    }

    public BirthstonesDetail(String name, int image, String description) {
        this.name=name;
        this.image=image;
        this.description=description;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager=getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState!=null){
            this.name=savedInstanceState.getString("NAME");
            this.image=savedInstanceState.getInt("IMAGE");
            this.description = savedInstanceState.getString("DESCRIPTION");
        }
        View rootView =inflater.inflate(R.layout.fragment_birthstones_detail, container, false);
        nameView = rootView.findViewById(R.id.name_field);
        descriptionView =rootView.findViewById(R.id.description_field);
        nameView.setText(this.name);
        descriptionView.setText(this.description);
        backButton = rootView.findViewById(R.id.back_button);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(BirthstonesDetail.this).commit();
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("NAME", name);
        outState.putInt("IMAGE", image);
        outState.putString("DESCRIPTION",description);
        super.onSaveInstanceState(outState);
    }
}
