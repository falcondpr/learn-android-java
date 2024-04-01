package com.example.proyectoprueba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] countries={"Argentina","Bolivia","Brasil"};
    int [] flags = {R.drawable.dado1, R.drawable.dado2, R.drawable.dado3};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        CountriesAdapter adapter1 = new CountriesAdapter();
        spinner.setAdapter(adapter1);
    }

    public void getItemFn(View v) {
        Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    class CountriesAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return countries.length;
        }

        @Override
        public Object getItem(int position) {
            return countries[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater  = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.itemspinner, null);
            ImageView iv1 = convertView.findViewById(R.id.imageView);
            TextView txt1 = convertView.findViewById(R.id.txtCountry);
            iv1.setImageResource(flags[position]);
            txt1.setText(countries[position]);
            return convertView;
        }
    }
}