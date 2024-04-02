package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtResult = findViewById(R.id.txtResult);
        Bundle dataResult = getIntent().getExtras();

        int value1 = dataResult.getInt("value1");
        int value2 = dataResult.getInt("value2");
        String operation = dataResult.getString("value3");

        switch (operation) {
            case "sumar":
                int sum = value1 + value2;
                txtResult.setText(value1 + "+" + value2 + "=" + sum);
                break;
            case "restar":
                int rest = value1 - value2;
                txtResult.setText(value1 + "-" + value2 + "=" + rest);
                break;
            case "multiplicar":
                int mult = value1 * value2;
                txtResult.setText(value1 + "*" + value2 + "=" + mult);
                break;
        }
    }

    public void goBackHome(View v) {
        finish();
    }
}