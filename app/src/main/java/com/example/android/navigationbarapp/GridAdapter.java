package com.example.android.navigationbarapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;


public class GridAdapter extends BaseAdapter {
    private Context c;
    private String[] alphabet= {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public GridAdapter(Context c){
        this.c=c;
    }

    @Override
    public int getCount() {
        return alphabet.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView imageView;

        if (convertView == null) {
            imageView = new TextView(c);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (TextView) convertView;
        }
        imageView.setBackgroundResource(R.color.colorPrimary);
        imageView.setText(alphabet[position]);
        return imageView;
    }
}
