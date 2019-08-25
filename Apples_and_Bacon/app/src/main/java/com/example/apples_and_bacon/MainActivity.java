package com.example.apples_and_bacon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/*
Creates an intent instance, this instance is given the input data from
the text field on apples activity, when the button is clicked, this data is
sent across to the bacon java class, and the intent opens the Bacon Activity.

Note: this app also includes intent service app
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //runs the intent service
        Intent intent = new Intent(this, CallumsIntentService.class);
        startService(intent);
        //runs the Myservice intent
        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    /*
    Creates an instance of an intent class, to switch between activities.

    takes text inputted from apples activity and takes the message over to
    bacon with the intent instance.
     */
    public void onClick(View view){
        Intent i = new Intent(this, Bacon.class);

        final EditText applesInput = (EditText) findViewById(R.id.applesInput);
        String userMessage = applesInput.getText().toString();
        i.putExtra("appleMessage", userMessage);

        startActivity(i);
    }
}
