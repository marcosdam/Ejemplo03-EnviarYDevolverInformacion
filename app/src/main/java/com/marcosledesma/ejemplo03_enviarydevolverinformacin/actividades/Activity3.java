package com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.marcosledesma.ejemplo03_enviarydevolverinformacin.R;

public class Activity3 extends AppCompatActivity {

    private TextView titulo;
    private SeekBar valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        titulo = findViewById(R.id.txtTituloAct3);
        valor = findViewById(R.id.sbValorAct3);

        // SACAMOS LAS VARIABLES DEL BUNDLE
        Bundle bundle = this.getIntent().getExtras();
        double decimal = bundle.getDouble("DECIMAL");
        valor.setProgress((int)decimal);
        String texto = bundle.getString("FRASE");
        titulo.setText(texto);
    }
}