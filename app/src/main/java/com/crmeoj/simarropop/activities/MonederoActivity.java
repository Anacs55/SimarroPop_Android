package com.crmeoj.simarropop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.crmeoj.simarropop.R;

public class MonederoActivity extends AppCompatActivity {

    private Spinner spnMonedero;
    private RecyclerView rvMonedero;
    private TextView tvMonederoSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monedero);

        spnMonedero = findViewById(R.id.spnMonedero);
        rvMonedero = findViewById(R.id.rvMonedero);
        tvMonederoSaldo = findViewById(R.id.tvMonederoSaldo);

        String[] opciones = new String[]{"Compras", "Ventas"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMonedero.setAdapter(adapter);

        spnMonedero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}