package com.example.android.navigationbarapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TapperMainFragment extends Fragment {


    public TapperMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tapper_main, container, false);
    }

    FragmentManager manager=getSupportFragmentManager();
    private TextFragment fragment1;
    private PlusOneFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new TextFragment();
        fragment2= new PlusOneFragment();

        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.fragment1, fragment1).addToBackStack(null).commit();

        FragmentTransaction transaction2 = manager.beginTransaction();
        transaction2.add(R.id.fragment2, fragment2).addToBackStack(null).commit();
    }

    public void onButtonClicked(){
        fragment1.addClick();
    }

    public void onLongClick(){
        fragment1.clearClicks();
    }

}
