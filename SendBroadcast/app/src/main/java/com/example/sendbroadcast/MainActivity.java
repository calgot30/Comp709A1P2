package com.example.sendbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

/*
creates broadcast intent, when button is clicked it will broadcast the intent

Note: this didnt work for me.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //creates broadcast intent, listens for click and when clicked broadcasts the intent
    public void sendOutBroadcast(View view){
        Intent i = new Intent();
        i.setAction("com.example.sendbroadcast");
        //makes sure this works with all versions of android
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);
    }
}
