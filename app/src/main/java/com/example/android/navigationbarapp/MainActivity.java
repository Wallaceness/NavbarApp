package com.example.android.navigationbarapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mainContainer;
    private FragmentManager MainManager=getSupportFragmentManager();
    private AlphabetFragment alphabetView;
    private TapperMainFragment tapperView;
    private Birthstones_main birthStonesView;
    Fragment currentFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainContainer = findViewById(R.id.container_div);

        alphabetView = new AlphabetFragment();
        tapperView = new TapperMainFragment();
        birthStonesView = new Birthstones_main();

        FragmentTransaction transaction = MainManager.beginTransaction();
        transaction.add(R.id.container_div, alphabetView).addToBackStack(null).commit();
        currentFragment = alphabetView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.alphabet) {
            FragmentTransaction transaction1 = MainManager.beginTransaction();
            transaction1.replace(R.id.container_div, alphabetView).addToBackStack(null).commit();
            currentFragment = alphabetView;
            toolbar.setTitle(item.getTitle());
            return true;
        }
        else if (id==R.id.stress_tapper){
            FragmentTransaction transaction2 = MainManager.beginTransaction();
            transaction2.replace(R.id.container_div, tapperView).addToBackStack(null).commit();
            currentFragment= tapperView;
            toolbar.setTitle(item.getTitle());
            return true;
        }
        else if (id==R.id.Birthstones){
            FragmentTransaction transaction3 = MainManager.beginTransaction();
            transaction3.replace(R.id.container_div, birthStonesView).addToBackStack(null).commit();
            currentFragment = birthStonesView;
            toolbar.setTitle(item.getTitle());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
