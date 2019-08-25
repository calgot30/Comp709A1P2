package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //variables for the widgets
    EditText usernameInput;
    EditText passwordInput;
    TextView callumsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gives variables references to the widgets on the activity_main
        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        callumsText = (TextView) findViewById(R.id.callumsText);
    }

    //Save the users login info
    public void saveInfo(View view){
        //creates sharedPref object file, gets the user info as parameter
        //and makes the file private so only this app can access it
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);


        //creates an object that allows us to edit the shared preferences
        SharedPreferences.Editor editor = sharedPref.edit();
        //key value pair, putting variables in the file
        //creates key called username, with value as userInput
        editor.putString("username", usernameInput.getText().toString());
        //creates key called password, with value as userInput
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        //toast notification to say that the is has saved
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

    }

    //Print out the saved data from the users input
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");
        callumsText.setText(name + " " + pw);

    }

}
