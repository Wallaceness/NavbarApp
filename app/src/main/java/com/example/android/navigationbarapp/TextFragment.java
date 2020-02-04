package com.example.android.navigationbarapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {
    private TextView textNode;
    private int clicks=0;


    public TextFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_text, container, false);
        textNode= root.findViewById(R.id.text_node);
        if (savedInstanceState!=null){
            clicks=savedInstanceState.getInt("CLICK_COUNT");
        }
        textNode.setText(Integer.toString(clicks));
        return root;
    }

    public void addClick(){
        clicks+=1;
        textNode.setText(Integer.toString(clicks));
    }

    public void clearClicks(){
        clicks=0;
        textNode.setText(Integer.toString(clicks));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("CLICK_COUNT", clicks);
        super.onSaveInstanceState(outState);
    }

}
