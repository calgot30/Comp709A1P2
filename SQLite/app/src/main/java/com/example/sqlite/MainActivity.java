package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

/*
Takes input from the text fields on screen and sends the information to the DBhandler class
which deals with the process accordingly
 */
public class MainActivity extends AppCompatActivity {

    EditText callumsInput;
    TextView callumsText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callumsInput = (EditText) findViewById(R.id.callumsInput);
        callumsText = (TextView) findViewById(R.id.callumsText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();

    }

    //Add a product to the database, then calls printDatabase() method
    public void addButtonClick(View view){
        Products product = new Products(callumsInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }


    //Delete items, then print the database
    public void deleteButtonClick(View view){
        String inputText = callumsInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    //prints the info from the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        callumsText.setText(dbString);
        callumsInput.setText("");
    }
}
