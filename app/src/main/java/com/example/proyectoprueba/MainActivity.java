package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView text1;
    String imagePosition = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.tex1);
        int nro = (int)(Math.random() * 8);

        switch (nro) {
            case 0: imagePosition = "image1";break;
            case 1: imagePosition = "image2";break;
            case 2: imagePosition = "image3";break;
            case 3: imagePosition = "image4";break;
            case 4: imagePosition = "image5";break;
            case 5: imagePosition = "image6";break;
        }

        text1= findViewById(R.id.tex1);
        text1.setText("Cual es la posicion de:  " + imagePosition);
    }

    public void press(View v) {
        ImageButton b = (ImageButton)v;
        if (b.getTag().toString().equals(imagePosition)) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Es incorrecto senalaste la posicion " + b.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}