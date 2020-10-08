package com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.marcosledesma.ejemplo03_enviarydevolverinformacin.R;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // TOMAR POSESIÓN DEL INTENT QUE ME HA CREADO MainActivity
        Intent intent = this.getIntent();

        // OBTENER EL BUNDLE
        Bundle bundle = intent.getExtras();

        if (bundle != null)
        {
            int numerito = bundle.getInt("NUMERO");
            Toast.makeText(this, "Numero: " + numerito, Toast.LENGTH_LONG).show();
        }
    }
}