package com.example.android.navigationbarapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
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
    private static final String TAG = "AlphabetFragment";


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
        if (savedInstanceState!=null){
            this.grid=savedInstanceState.getBoolean("GRID_VIEW");

        }
        View rootView = inflater.inflate(R.layout.fragment_alphabet, container, false);
        ToggleButton = rootView.findViewById(R.id.toggle_button);
        FragmentTransaction transaction = manager.beginTransaction();
        if (grid){
            transaction.replace(R.id.alphabet_container, gridView).addToBackStack(null).commit();
            ToggleButton.setText(R.string.list_view);
        }
        else{
            transaction.replace(R.id.alphabet_container, listView).addToBackStack(null).commit();
            ToggleButton.setText(R.string.grid_view);
        }

        ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=manager.beginTransaction();
                if (grid){
                    transaction.replace(R.id.alphabet_container, listView).addToBackStack(null).commit();
                    ToggleButton.setText(R.string.grid_view);
                    grid=false;
                }
                else{
                    transaction.replace(R.id.alphabet_container, gridView).addToBackStack(null).commit();
                    ToggleButton.setText(R.string.list_view);
                    grid=true;
                }
            }
        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean("GRID_VIEW", grid);
        super.onSaveInstanceState(outState);

    }
}
