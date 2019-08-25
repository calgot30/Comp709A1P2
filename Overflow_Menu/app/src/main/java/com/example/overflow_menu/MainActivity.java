package com.example.overflow_menu;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


/*
Creates the overflow menu, uses radio buttons to check which theme is being used,
switch statements are used to check which of the radio buttons is checked, then the theme is changed
accordingly.  XML settings are saved in menu_main.xml

Note: I had to create this in a basic activity for it to work.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CoordinatorLayout main_view = (CoordinatorLayout) findViewById(R.id.main_view);

        //switch statements to see which radio button is checked, changes the background settings
        //accordingly
        switch(item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu_green:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.menu_yellow:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.YELLOW);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
