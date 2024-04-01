package com.example.proyectoprueba;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String[] names={"dado1","dado2","dado3","dado4","dado5","dado6"};
    float[] circlesCount={1,2,3,4,5,6};
    int[] photos={R.drawable.dado1,R.drawable.dado2,R.drawable.dado3,R.drawable.dado4,R.drawable.dado5,R.drawable.dado6};

    RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);
        rv1.setAdapter(new AdapterDado());
    }

    private class AdapterDado extends RecyclerView.Adapter<AdapterDado.AdapterDadoHolder> {
        @NonNull
        @Override
        public AdapterDadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterDadoHolder(getLayoutInflater().inflate(R.layout.itemdado, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterDadoHolder holder, int position) {
            holder.printFn(position);
        }

        @Override
        public int getItemCount() {
            return circlesCount.length;
        }

        private class AdapterDadoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView txt1, txt2;
            ImageView img1;
            public AdapterDadoHolder(@NonNull View itemView) {
                super(itemView);
                img1 = itemView.findViewById(R.id.imageView2);
                txt1 = itemView.findViewById(R.id.txtName1);
                txt2 = itemView.findViewById(R.id.txtName2);

                itemView.setOnClickListener(this);
            }

            public void printFn(int position) {
                img1.setImageResource(photos[position]);
                txt1.setText(names[position]);
                txt2.setText(String.valueOf(circlesCount[position]));
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, names[getLayoutPosition()], Toast.LENGTH_SHORT).show();
            }
        }
    }
}