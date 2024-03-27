package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton image1, image2, image3, image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void press(View v) {
        ImageButton imgBtn = (ImageButton)v;
        imgBtn.setVisibility(View.INVISIBLE);
    }

    public void restart(View v) {
        ImageButton image1 = findViewById(R.id.image1);
        ImageButton image2 = findViewById(R.id.image2);
        ImageButton image3 = findViewById(R.id.image3);
        ImageButton image4 = findViewById(R.id.image4);

        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.VISIBLE);
        image3.setVisibility(View.VISIBLE);
        image4.setVisibility(View.VISIBLE);
    }
}