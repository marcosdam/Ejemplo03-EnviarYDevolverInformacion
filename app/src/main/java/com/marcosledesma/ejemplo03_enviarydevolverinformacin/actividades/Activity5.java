package com.marcosledesma.ejemplo03_enviarydevolverinformacin.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;

import com.marcosledesma.ejemplo03_enviarydevolverinformacin.R;

public class Activity5 extends AppCompatActivity {

    private RatingBar rbValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        rbValoracion = findViewById(R.id.rbValoracionAct5);

        // Listener para cuando cambien las estrellas
        rbValoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putFloat("rating", rating);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}