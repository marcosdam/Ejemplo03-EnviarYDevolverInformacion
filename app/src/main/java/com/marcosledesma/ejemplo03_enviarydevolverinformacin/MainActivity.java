package com.marcosledesma.ejemplo03_enviarydevolverinformacin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades.Activity2;
import com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades.Activity3;
import com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades.Activity4;
import com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades.Activity5;
import com.marcosledesma.ejemplo03_enviarydevolverinformacin.modelos.Persona;

public class MainActivity extends AppCompatActivity {

    private Persona persona;
    private final int ACTIVIDAD_2 = 2;
    private final int ACTIVIDAD_3 = 3;
    private final int ACTIVIDAD_4 = 4;
    private final int ACTIVIDAD_5 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método que usarán todos los botones (abrir otra actividad)
    public void clickBoton(View botonClicked){
        Button boton = (Button) botonClicked;   // CAST de View a Button

        Intent intent = null;   // En cada caso decimos a que actividad vamos

        // Para pasar información de una a otra actividad necesitamos un Bundle
        Bundle bundle = new Bundle();

        // Para identificar qué actividad está trayendo info al Main
        int actividad = 0;

        // Dependiendo del boton pulsado abriremos una u otra actividad
        switch (boton.getId())
        {
            case R.id.btnAct2Main:
                intent = new Intent(MainActivity.this, Activity2.class);
                bundle.putInt("NUMERO", 100);
                actividad = ACTIVIDAD_2;
                break;
            case R.id.btnAct3Main:
                intent = new Intent(MainActivity.this, Activity3.class);
                bundle.putString("FRASE","Holaaaaaa");
                bundle.putDouble("DECIMAL", 60);
                actividad = ACTIVIDAD_3;
                break;
            case R.id.btnAct4Main:
                intent = new Intent(MainActivity.this, Activity4.class);
                // Crear persona
                persona = new Persona("Marcos", "Ledesma Picazo", 27, 1.78f, 65, false);
                // Para enviar la persona a la Activity4 debemos coger el bundle
                bundle.putParcelable("PERSONA", persona);   // Al hacer parcelable la clase persona ya puedo usar putParcelable

                actividad = ACTIVIDAD_4;

                break;
            case R.id.btnAct5Main:
                intent = new Intent(MainActivity.this, Activity5.class);
                actividad = ACTIVIDAD_5;
                break;
        }
        intent.putExtras(bundle);   // Cargamos el bundle (la info) que debe llevarse la actividad

        // startActivityForResult (saber a qué actividad he enviado, quién me tiene que contestar)
        startActivityForResult(intent, actividad);
    }

    // Aquí llegamos cuando la actividad 4 se ha cerrado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Si vengo de la Activity4 hago esto
        if (requestCode == ACTIVIDAD_4){
            if(resultCode == RESULT_OK)
            {
                persona = data.getExtras().getParcelable("persona");    // Aquí data es el intent de Activity4
                Toast.makeText(this, persona.toString(), Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Se ha cancelado", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == ACTIVIDAD_2){
            Toast.makeText(this, "Vengo de la Activity 2", Toast.LENGTH_LONG).show();
        }
        if (requestCode == ACTIVIDAD_3){
            Toast.makeText(this, "Vengo de la Activity 3", Toast.LENGTH_LONG).show();
        }
        if (requestCode == ACTIVIDAD_5){
            float rating = data.getExtras().getFloat("rating");
            Toast.makeText(this, "Valoración: " + rating, Toast.LENGTH_LONG).show();
        }
    }
}