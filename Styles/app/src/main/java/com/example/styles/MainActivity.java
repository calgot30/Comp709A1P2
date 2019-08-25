package com.example.styles;

import androidx.appcompat.app.AppCompatActivity;

//importing the correct bundle
import android.app.Activity;
import android.os.Bundle;

//I had to change from compatActivity to Activity to fix the app and stop from crashing
//this was the error before:
//java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.styles/com.example.styles.MainActivity}: java.lang.IllegalStateException: You need to use a Theme.AppCompat theme (or descendant) with this activity.
public class MainActivity extends Activity {
/*
I had themes and styles in the same app so the BabyBlue and BigBoy (inherited) themes were deleted
as the commenting in xml wouldnt work

Create a new xml file for the design, then create the values that you want to customise in the
activity_main scree, then change the style reference in the xml of the activity_main.
Change the style reference in the AndroidManifest.xml to chang the overall theme of the app also
 */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
