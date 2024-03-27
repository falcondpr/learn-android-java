package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private String jugador = "x";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
    }

    public void press(View v) {
        Button b = (Button)v;

        if (b.getText().toString().isEmpty()) {
            b.setText(jugador);
            verifyWin(jugador);
            changePlayer();
        }
    }

    // function created by chatgpt to learn logic structure
    public void verifyWin(String turn) {
        // Arreglo para almacenar el estado de cada casilla
        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9};

        // Arreglo para almacenar el texto de cada casilla
        String[] cells = new String[9];

        // Obtener el texto de cada botón y almacenarlo en el arreglo
        for (int i = 0; i < 9; i++) {
            cells[i] = buttons[i].getText().toString();
        }

        // Arreglo que contiene todas las combinaciones ganadoras
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Filas
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Columnas
                {0, 4, 8}, {2, 4, 6}               // Diagonales
        };

        // Verificar si alguna combinación ganadora está completa para el jugador actual
        for (int i = 0; i < winCombinations.length; i++) {
            int[] combination = winCombinations[i];
            if (cells[combination[0]].equals(turn) &&
                    cells[combination[1]].equals(turn) &&
                    cells[combination[2]].equals(turn)) {
                // Si alguna combinación ganadora está completa, el jugador ha ganado
                // Puedes agregar aquí cualquier acción que quieras realizar cuando un jugador gane
                Toast.makeText(this, "¡Jugador " + turn + " ha ganado!", Toast.LENGTH_SHORT).show();
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");
                // Puedes detener el juego aquí si lo deseas
                return;
            }
        }

        // Si ninguna combinación ganadora está completa y no hay más casillas vacías, hay un empate
        boolean tie = true;
        for (String cell : cells) {
            if (cell.isEmpty()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            // Puedes agregar aquí cualquier acción que quieras realizar en caso de empate
            Toast.makeText(this, "¡Empate!", Toast.LENGTH_SHORT).show();
            // Puedes detener el juego aquí si lo deseas
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
        }
    }


    public void changePlayer() {
        if(jugador.equals("x")) {
            jugador = "o";
        } else {
            jugador = "x";
        }
    }

    public void leave(View v) {
        finish();
    }
}