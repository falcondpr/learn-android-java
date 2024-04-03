package com.example.proyectoprueba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText input1, input2, input3, input4;
    AdminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);

        admin = new AdminSQLiteOpenHelper(this, "bd2", null, 1);
    }

    public void add(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registerInfo = new ContentValues();

        registerInfo.put("patente", input1.getText().toString());
        registerInfo.put("marca", input2.getText().toString());
        registerInfo.put("modelo", input3.getText().toString());
        registerInfo.put("precio", input4.getText().toString());

        bd.insert("vehicles", null, registerInfo);

        input1.setText("");
        input2.setText("");
        input3.setText("");
        input4.setText("");
        bd.close();

        Toast.makeText(this, "Vehiculo agregado", Toast.LENGTH_SHORT).show();
    }

    public void getVehicle(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patent = input1.getText().toString();
        Cursor row = bd.rawQuery("select marca,modelo,precio from vehicles where patente='"+patent+"'", null);
        if (row.moveToFirst()) {
            input2.setText(row.getString(0));
            input3.setText(row.getString(1));
            input4.setText(row.getString(2));
        } else {
            Toast.makeText(this, "No existe el vehiculo", Toast.LENGTH_SHORT).show();
            input1.setText("");
            input2.setText("");
            input3.setText("");
            input4.setText("");
        }
        bd.close();
    }

    public void delete(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patent = input1.getText().toString();
        int cant = bd.delete("vehicles", "patente='"+patent+"'", null);
        
        if (cant==1) {
            Toast.makeText(this, "Vehiculo eliminado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vehiculo no encontrado", Toast.LENGTH_SHORT).show();
        }
        
        bd.close();
    }

    public void modify(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patent = input1.getText().toString();

        ContentValues registerInfo = new ContentValues();

        registerInfo.put("marca", input2.getText().toString());
        registerInfo.put("modelo", input3.getText().toString());
        registerInfo.put("precio", input4.getText().toString());
        int cant = bd.update("vehicles", registerInfo, "patente='"+patent+"'", null);
        
        if (cant == 1) {
            Toast.makeText(this, "Se modifico los datos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vehiculo no encontrado", Toast.LENGTH_SHORT).show();
        }

        bd.close();
    }
}