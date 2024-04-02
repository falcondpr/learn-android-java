package com.example.proyectoprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView text1;

    private ActivityResultLauncher<Intent> loginLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Bundle dataResult = result.getData().getExtras();
                    text1.setText(dataResult.getString("username"));
                } else if (result.getResultCode() == RESULT_CANCELED) {
                    Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
                }else {}
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.preview1);
    }

    public void goToLogin(View v) {
        Intent intent1 = new Intent(this, FormLogin.class);
        loginLauncher.launch(intent1);
    }
}