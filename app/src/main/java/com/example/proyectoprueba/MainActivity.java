package com.example.proyectoprueba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Persona> people;
    RecyclerView rv1;
    EditText input1, input2;
    AdapterPerson adapterPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        people = new ArrayList<Persona>();
        people.add(new Persona("Lucas", "911"));
        people.add(new Persona("Sofia", "132"));
        people.add(new Persona("Laura", "999"));

        LinearLayoutManager l = new LinearLayoutManager(this);
        rv1.setLayoutManager(l);

        adapterPerson = new AdapterPerson();
        rv1.setAdapter(adapterPerson);
    }

    public void add(View v) {
        Persona person1 = new Persona(input1.getText().toString(), input2.getText().toString());
        people.add(person1);
        input1.setText("");
        input2.setText("");

        adapterPerson.notifyDataSetChanged();
        rv1.scrollToPosition(people.size() - 1);
    }

    public void remove(View v) {
        int pos = -1;

        for(int f = 0; f < people.size(); f++) {
            if(people.get(f).getName().equals(input1.getText().toString())) {
                pos = f;
            }
        }
        if (pos != -1) {
            people.remove(pos);
            input1.setText("");
            input2.setText("");
            adapterPerson.notifyDataSetChanged();
            Toast.makeText(this, "Se elimino el usuario", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
        }
    }

    public void show(int pos) {
        input1.setText(people.get(pos).getName());
        input2.setText(people.get(pos).getPhone());
    }

    private class AdapterPerson extends RecyclerView.Adapter<AdapterPerson.AdapterPersonHolder> {
        @NonNull
        @Override
        public AdapterPersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterPersonHolder(getLayoutInflater().inflate(R.layout.itemperson, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterPersonHolder holder, int position) {
            holder.print(position);
        }

        @Override
        public int getItemCount() {
            return people.size();
        }

        class AdapterPersonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView txt1, txt2;

            public AdapterPersonHolder(@NonNull View itemView) {
                super(itemView);
                txt1 = itemView.findViewById(R.id.txtName);
                txt2 = itemView.findViewById(R.id.txtPhone);
                itemView.setOnClickListener(this);
            }

            public void print(int position) {
                txt1.setText("Nombre: " + people.get(position).getName());
                txt2.setText("Telefono: " + people.get(position).getPhone());
            }

            @Override
            public void onClick(View v) {
                show(getLayoutPosition());
            }
        }
    }
}