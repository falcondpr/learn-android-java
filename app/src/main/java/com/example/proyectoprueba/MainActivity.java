package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private TextView txtResult;
    private EditText i1, i2;
    private String[] operations = {"sumar", "restar", "multiplicar", "dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1 = findViewById(R.id.input1);
        i2 = findViewById(R.id.input2);

        txtResult = findViewById(R.id.textResult);
        spinner1 = findViewById(R.id.spinner1);

        ArrayAdapter<String>adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operations);
        spinner1.setAdapter(adapter1);
    }

    public void operate(View v) {
        int value1 = Integer.parseInt(i1.getText().toString());
        int value2 = Integer.parseInt(i2.getText().toString());

        String operation = spinner1.getSelectedItem().toString();

        if (operation.equals("sumar")) {
            int suma = value1 + value2;
            txtResult.setText("La suma es: " + suma);
        }

        if (operation.equals("restar")) {
            int resta = value1 - value2;
            txtResult.setText("La resta es: " + resta);
        }

        if (operation.equals("multiplicar")) {
            int multiplicacion = value1 * value2;
            txtResult.setText("La multiplicacion es: " + multiplicacion);
        }

        if (operation.equals("dividir")) {
            int division = value1 / value2;
            txtResult.setText("La division es: " + division);
        }
    }
}