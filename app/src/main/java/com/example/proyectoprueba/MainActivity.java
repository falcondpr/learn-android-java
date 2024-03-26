package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private RadioButton rb1, rb2;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);

        textResult = findViewById(R.id.textResult);
    }

    public void calculateOperation(View v) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);

        if (rb1.isChecked()) {
            int sumando = v1 + v2;
            textResult.setText("La suma es: " + sumando);
        } else if (rb2.isChecked()) {
            int restando = v1 - v2;
            textResult.setText("La resta es: " + restando);
        }
    }
}