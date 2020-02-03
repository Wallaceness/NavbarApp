package com.example.android.navigationbarapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class list_Fragment extends Fragment {
    private String[] alphabet= {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private ListView alphaList;

    public list_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_, container, false);
        alphaList = (ListView) rootView.findViewById(R.id.alpha_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(container.getContext(),R.layout.listview_adapter, R.id.letter_item, alphabet);
        alphaList.setAdapter(adapter);
        return rootView;
    }

}
