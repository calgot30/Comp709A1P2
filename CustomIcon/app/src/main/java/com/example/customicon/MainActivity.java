package com.example.customicon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


/*
I did this through adding a new image asset
https://developer.android.com/studio/write/image-asset-studio
gave it an image and sent the icons
to it, Buckys original way did not work for me
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
