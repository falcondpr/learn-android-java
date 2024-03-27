package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView image1, image2, image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
    }

    public void drop(View v) {
        int value1 = 1 + (int)(Math.random() * 6);
        int value2 = 1 + (int)(Math.random() * 6);
        int value3 = 1 + (int)(Math.random() * 6);

        switch (value1) {
            case 1: image1.setImageResource(R.drawable.dado1);break;
            case 2: image1.setImageResource(R.drawable.dado2);break;
            case 3: image1.setImageResource(R.drawable.dado3);break;
            case 4: image1.setImageResource(R.drawable.dado4);break;
            case 5: image1.setImageResource(R.drawable.dado5);break;
            case 6: image1.setImageResource(R.drawable.dado6);break;
        }

        switch (value2) {
            case 1: image2.setImageResource(R.drawable.dado1);break;
            case 2: image2.setImageResource(R.drawable.dado2);break;
            case 3: image2.setImageResource(R.drawable.dado3);break;
            case 4: image2.setImageResource(R.drawable.dado4);break;
            case 5: image2.setImageResource(R.drawable.dado5);break;
            case 6: image2.setImageResource(R.drawable.dado6);break;
        }

        switch (value3) {
            case 1: image3.setImageResource(R.drawable.dado1);break;
            case 2: image3.setImageResource(R.drawable.dado2);break;
            case 3: image3.setImageResource(R.drawable.dado3);break;
            case 4: image3.setImageResource(R.drawable.dado4);break;
            case 5: image3.setImageResource(R.drawable.dado5);break;
            case 6: image3.setImageResource(R.drawable.dado6);break;
        }
    }
}