package com.example.proyectoprueba;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


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
        String fileName = input1.getText().toString();
        String content = input2.getText().toString();

        try {
            OutputStreamWriter newFile = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
            newFile.write(content);
            newFile.flush();
            newFile.close();
            input1.setText("");
            input2.setText("");
            Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show();
        } catch(IOException e) {
            Toast.makeText(this, "No se pudo crear el archivo", Toast.LENGTH_SHORT).show();
        }
    }

    public void recover(View v) {
        String fileName = input1.getText().toString();

        try {
            InputStreamReader fileExist = new InputStreamReader(openFileInput(fileName));
            BufferedReader b = new BufferedReader(fileExist);
            String line_of_file = b.readLine();
            String content = "";
            while (line_of_file != null) {
                content = content + line_of_file+"\n";
                line_of_file = b.readLine();
            }

            b.close();
            fileExist.close();
            input2.setText(content);
        } catch(IOException e) {
            Toast.makeText(this, "No se pudo encontrar el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}