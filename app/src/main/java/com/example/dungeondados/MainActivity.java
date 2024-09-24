package com.example.dungeondados;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeondados.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public int totalContador;
    public String reset = "-";

    int contadorD6;
    int tiradasD6 = 0;

    ActivityMainBinding binding;

    public static final String ESTADO_CONTADOR = "Estado del contador";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            totalContador = savedInstanceState.getInt(ESTADO_CONTADOR);
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.totalContador.setText(String.valueOf(totalContador));

        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalContador = 0;
                binding.totalContador.setText(reset);
                binding.tiradasD6.setText(reset);
                binding.resultadoD6.setText(reset);
            }
        });

        binding.buttonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorD6 = (int) (Math.random() * 5) + 1;
                tiradasD6++;
                binding.resultadoD6.setText(contadorD6);
                binding.tiradasD6.setText(String.valueOf(tiradasD6));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(ESTADO_CONTADOR, totalContador);
        super.onSaveInstanceState(savedInstanceState);
    }
}