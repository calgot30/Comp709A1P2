package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


class CustomAdapter extends ArrayAdapter<String>{

    //constructor takes the string array, and uses the custom_row file to format the layout.
    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row ,foods);
    }


    /*
    Creates a custom view for our list to be displayed in,
    Takes the info of each item in the array and stores it
    in the TextView variable, the text is then placed next to the image that we have
    specified, and returns the custom view.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater callumsInflater = LayoutInflater.from(getContext());
        View customView = callumsInflater.inflate(R.layout.custom_row, parent, false);

        //gets info about the text and picture we provided
        String singleFoodItem = getItem(position);
        TextView callumsText = (TextView) customView.findViewById(R.id.callumsText);
        ImageView callumsImage = (ImageView) customView.findViewById(R.id.callumsImage);

        //changes text to whatever the foodItem value is that has been collected from the food array
        callumsText.setText(singleFoodItem);

        //changes the image to whatever image we have set it to
        callumsImage.setImageResource(R.drawable.doggo4);

        return customView;
    }
}
