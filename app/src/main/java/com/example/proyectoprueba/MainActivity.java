package com.example.proyectoprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAboutScreen(View v) {
        Intent intent1 = new Intent(this, ActivityTwo.class);
        startActivity(intent1);
    }
}