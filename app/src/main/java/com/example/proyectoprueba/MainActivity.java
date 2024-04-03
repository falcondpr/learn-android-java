package com.example.proyectoprueba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText input1, input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
    }

    public void save(View v) {
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String date1 = input1.getText().toString();
        String activityText = input2.getText().toString();
        editor.putString(date1, activityText);
        editor.commit();
        input1.setText("");
        input2.setText("");
        Toast.makeText(this, "Las actividades fueron registradas", Toast.LENGTH_SHORT).show();
    }

    public void recover(View v) {
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String dataFile = sp.getString(input1.getText().toString(), "Not found!");

        if (dataFile.equals("Not found!")) {
            input2.setText("");
            Toast.makeText(this, "Las actividades NO fueron encontradas", Toast.LENGTH_SHORT).show();
        } else {
            input2.setText(dataFile);
        }
    }
}