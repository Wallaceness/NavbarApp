package com.example.android.navigationbarapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A fragment with a Google +1 button.
 */
public class PlusOneFragment extends Fragment {

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    private Button mPlusOneButton;
    private TapperMainFragment parentActivity;


    public PlusOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);

        //Find the +1 button
        mPlusOneButton = (Button) view.findViewById(R.id.counter_button);

        parentActivity = (TapperMainFragment) getParentFragment();

        mPlusOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.onButtonClicked();
            }
        });

        mPlusOneButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                parentActivity.onLongClick();
                return true;
            }
        });
        return view;
    }

}
