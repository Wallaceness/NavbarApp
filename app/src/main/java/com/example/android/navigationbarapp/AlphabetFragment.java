package com.example.android.navigationbarapp;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlphabetFragment extends Fragment {
    private FragmentManager manager;
    private list_Fragment listView;
    private GridFragment gridView;
    private Button ToggleButton;
    private boolean grid=false;


    public AlphabetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager=getChildFragmentManager();
        listView = new list_Fragment();
        gridView = new GridFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_alphabet, container, false);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.alphabet_container, listView).addToBackStack(null).commit();
        ToggleButton = rootView.findViewById(R.id.toggle_button);

        ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=manager.beginTransaction();
                if (grid){
                    transaction.replace(R.id.alphabet_container, listView).addToBackStack(null).commit();
                    ToggleButton.setText("Grid View");
                    grid=false;
                }
                else{
                    transaction.replace(R.id.alphabet_container, gridView).addToBackStack(null).commit();
                    ToggleButton.setText("List View");
                    grid=true;
                }
            }
        });
        return rootView;
    }

}
