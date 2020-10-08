package com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.marcosledesma.ejemplo03_enviarydevolverinformacin.R;
import com.marcosledesma.ejemplo03_enviarydevolverinformacin.modelos.Persona;

public class Activity4 extends AppCompatActivity {

    private EditText txtNombre, txtApellidos, txtEdad, txtPeso, txtAltura;
    private Switch swCasado;
    private Button btnCancelar, btnGuardar;

    // persona Recibirá la persona del Main
    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // 1. INICIALIZAR VARIABLES (asociar elementos de vista y controlador)
        inicializarVariables();

        // 2. RECIBIR EL INTENT DEL MAIN CON LA PERSONA
        persona = getIntent().getExtras().getParcelable("PERSONA");

        // 3. DAR VALORES A LOS txtNombre, txtApellidos etc (con los recibidos de Persona)
        if(persona != null){
            inicializaValores();
        }
        else {
            Toast.makeText(this, "No tengo datos de la persona", Toast.LENGTH_LONG).show();
        }

        // 4. CREAR EVENTOS DE LOS BOTONES (CANCELAR Y GUARDAR)
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED); // Para que el Main lo recoja y no haga nada
                finish();   // Cierra la actividad4
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Actualiza la persona en función a los datos de la Activity4
                persona.setNombre(txtNombre.getText().toString());
                persona.setApellidos(txtApellidos.getText().toString());
                persona.setEdad(Integer.parseInt(txtEdad.getText().toString()));
                persona.setAltura(Float.parseFloat(txtAltura.getText().toString()));
                persona.setPeso(Float.parseFloat(txtPeso.getText().toString()));
                persona.setCasado(swCasado.isChecked());

                // DEVOLVER LA PERSONA ACTUALIZADA AL MAIN (INTENT Y BUNDLE)
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("persona", persona);   // Este es un bundle distinto, por eso en minúscula
                intent.putExtras(bundle);

                setResult(RESULT_OK, intent);
                finish();   // Cierra la actividad4
            }
        });
    }

    private void inicializaValores() {
        txtNombre.setText(persona.getNombre());
        txtApellidos.setText(persona.getApellidos());
        txtEdad.setText(String.valueOf(persona.getEdad()));
        txtAltura.setText(String.valueOf(persona.getAltura()));
        txtPeso.setText(String.valueOf(persona.getPeso()));
        swCasado.setChecked(persona.isCasado());
    }

    private void inicializarVariables() {
        txtNombre = findViewById(R.id.txtNombreAct4);
        txtApellidos = findViewById(R.id.txtApellidosAct4);
        txtEdad = findViewById(R.id.txtEdadAct4);
        txtAltura = findViewById(R.id.txtAlturaAct4);
        txtPeso = findViewById(R.id.txtPesoAct4);
        swCasado = findViewById(R.id.swCasadoAct4);
        btnCancelar = findViewById(R.id.btnCancelarAct4);
        btnGuardar = findViewById(R.id.btnGuardarAct4);
    }
}