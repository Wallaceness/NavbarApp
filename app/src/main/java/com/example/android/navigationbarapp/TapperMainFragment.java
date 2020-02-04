package com.example.android.navigationbarapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
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
    private FragmentManager manager;
    private TextFragment fragment1;
    private PlusOneFragment fragment2;
    private int clicks=0;

    public TapperMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tapper_main, container, false);
        if (savedInstanceState==null){
            fragment2 = new PlusOneFragment();
//        int fetchedClicks = savedInstanceState.getInt("EXISTING_CLICKS");
            fragment1 = new TextFragment();
//        this.clicks=fetchedClicks;
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment1, fragment1).addToBackStack(null).commit();

            FragmentTransaction transaction2 = manager.beginTransaction();
            transaction2.add(R.id.fragment2, fragment2).addToBackStack(null).commit();
        }
        else{
            fragment2 = (PlusOneFragment) manager.findFragmentById(R.id.fragment2);
            fragment1 = (TextFragment) manager.findFragmentById(R.id.fragment1);

        }
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        manager = getChildFragmentManager();
    }

    public void onButtonClicked(){
        fragment1.addClick();
        clicks+=1;
    }

    public void onLongClick(){
        fragment1.clearClicks();
        clicks=0;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("EXISTING_CLICKS", clicks);
        super.onSaveInstanceState(outState);
    }
}
