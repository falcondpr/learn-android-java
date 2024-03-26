package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Switch switch1, switch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
    }

    public void verifyMovilData(View v) {
        if(switch1.isChecked()) {
            Toast.makeText(this, "Datos moviles activados", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Datos moviles desactivados", Toast.LENGTH_SHORT).show();
        }
    }

    public void verify(View v) {
        if(switch1.isChecked()) {
            Toast.makeText(this, "Datos moviles activos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Datos moviles desactivados", Toast.LENGTH_SHORT).show();
        }

        if(switch2.isChecked()) {
            Toast.makeText(this, "Wifi activos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wifi desactivados", Toast.LENGTH_SHORT).show();
        }
    }
}