package com.example.proyectoprueba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormLogin extends AppCompatActivity {
    EditText input1, input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
    }

    public void login(View v) {
        Intent intent1 = new Intent();
        intent1.putExtra("username", input1.getText().toString());
        setResult(Activity.RESULT_OK, intent1);
        finish();
    }

    public void cancel(View v) {
        Intent intent1 = new Intent();
        setResult(Activity.RESULT_CANCELED, intent1);
        finish();
    }
}