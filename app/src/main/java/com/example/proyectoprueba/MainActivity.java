package com.example.proyectoprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText input1, input2;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        spinner1 = findViewById(R.id.spinner1);

        String[] operations = {"sumar", "restar", "multiplicar"};
        ArrayAdapter<String>adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operations);
        spinner1.setAdapter(adapter1);
    }

    public void showResult(View v) {
        Intent intent1 = new Intent(this, ResultActivity.class);
        int value1 = Integer.parseInt(input1.getText().toString());
        int value2 = Integer.parseInt(input2.getText().toString());
        String operation = spinner1.getSelectedItem().toString();

        intent1.putExtra("value1", value1);
        intent1.putExtra("value2", value2);
        intent1.putExtra("value3", operation);
        startActivity(intent1);
    }
}