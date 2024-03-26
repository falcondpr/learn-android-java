package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView txt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        txt1 = findViewById(R.id.txt1);
    }

    public void sumNums(View v) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);
        int suma = v1 + v2;
        txt1.setText("La suma es: "+ suma);
    }
}