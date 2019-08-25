package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /*
    Creates a String array called foods, takes the array and converts it to list items,
    Then listens to whenever user taps the screen, extracts the String value of the item and
    stores it in the food variable, then pops up info about the item with a Toast.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String array for the listView
        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"};

        //takes the foods String array and converts it into list items
        ListAdapter callumsAdapter = new CustomAdapter(this, foods);
        ListView callumsListView = (ListView) findViewById(R.id.callumsListView);
        callumsListView.setAdapter(callumsAdapter);


        //Listener, whenever user taps screen, extracts String value of the item and
        //stores it in the food variable, then
        //gives them info about the item they tapped
        callumsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String food = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
