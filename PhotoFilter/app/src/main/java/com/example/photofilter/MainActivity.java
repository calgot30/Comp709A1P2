package com.example.photofilter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.Image;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ImageView callumsImageView;
    Drawable doggoPic;
    Bitmap bitmapImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callumsImageView = (ImageView) findViewById(R.id.callumsImageView);


        //from tutorial 59
        /*
        doggoPic = getResources().getDrawable(R.drawable.doggo6);
        bitmapImage = ((BitmapDrawable) doggoPic).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        callumsImageView.setImageBitmap(newPhoto);
        */

        //from tutorial 60
        //puts two images in Drawable array, creates a LayerDrawable object
        //Then places the array inside the object and displays it
        Drawable[] layers = new Drawable[2];
        layers[0] = getResources().getDrawable(R.drawable.doggo3);
        layers[1] = getResources().getDrawable(R.drawable.filter);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        callumsImageView.setImageDrawable(layerDrawable);

        //saves the image onto your phone gallery
        //MediaStore.Images.Media.insertImage(getContentResolver(), newPhoto, "title", "description");

    }

    //Inverts the colors of a bitmap image
    public static Bitmap invertImage(Bitmap original){
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int pixelColor;
        int height = original.getHeight();
        int width = original.getWidth();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                pixelColor = original.getPixel(x, y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        return finalImage;
    }
}
