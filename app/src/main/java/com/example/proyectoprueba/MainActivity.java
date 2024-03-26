package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView textResult;
    private CheckBox check1, check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);

        textResult = findViewById(R.id.textResult);
    }

    public void calculateOperation(View v) {
        int v1 = Integer.parseInt(et1.getText().toString());
        int v2 = Integer.parseInt(et2.getText().toString());

        String result = "";

        if (check1.isChecked()) {
            int suma = v1 + v2;
            result += "La suma es: " + suma + " ";
        }

        if (check2.isChecked()) {
            int resta = v1 - v2;
            result += " La resta es: " + resta;
        }

        textResult.setText(result);
    }
}