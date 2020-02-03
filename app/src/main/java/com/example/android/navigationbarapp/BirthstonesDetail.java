package com.example.android.navigationbarapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthstonesDetail extends Fragment {
    private TextView nameView;
    private TextView descriptionView;
    private ConstraintLayout detailParent;
    private String name;
    private int image;
    private String description;

    public BirthstonesDetail(String name, int image, String description) {
        this.name=name;
        this.image=image;
        this.description=description;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_birthstones_detail, container, false);
        nameView = rootView.findViewById(R.id.name_field);
        descriptionView =rootView.findViewById(R.id.description_field);
        nameView.setText(this.name);
        descriptionView.setText(this.description);
//        descriptionView.setBackground(getDrawable(image));
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        int image = intent.getIntExtra("image", 0);
//        String description = intent.getStringExtra("description");

        return rootView;
    }

}
