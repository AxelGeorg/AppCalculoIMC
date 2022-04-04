package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaResultadoCalculoIMC extends AppCompatActivity {

    float fPeso = 0;
    float fAltura = 0;
    float fResultadoIMC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado_calculo_imc);

        Bundle bundle = getIntent().getExtras();
        fPeso   = bundle.getFloat("peso"  );
        fAltura = bundle.getFloat("altura");

        TextView textViewPeso   = findViewById(R.id.textViewPeso  );
        textViewPeso  .setText(Float.toString(fPeso));

        TextView textViewAltura = findViewById(R.id.textViewAltura);
        textViewAltura.setText(Float.toString(fAltura));

        fResultadoIMC = fPeso / (fAltura * fAltura);
        TextView textViewIMC = findViewById(R.id.textViewResultadoIMC);
        textViewIMC.setText(Float.toString(fResultadoIMC));

        ImageView imgView = findViewById(R.id.imageView);

        Drawable drawable = null;
        String sClassificacao = "";

        if(fResultadoIMC < 18.5)
        {
            sClassificacao = "Abaixo do Peso";
            drawable = getResources().getDrawable(R.drawable.magrinho);
        }
        else if((fResultadoIMC >= 18.6) && (fResultadoIMC <= 24.9))
        {
            sClassificacao = "Peso ideal";
            drawable = getResources().getDrawable(R.drawable.magro);
        }
        else if((fResultadoIMC >= 25) && (fResultadoIMC <= 29.9))
        {
            sClassificacao = "Levemente acima do peso";
            drawable = getResources().getDrawable(R.drawable.gordinho);
        }
        else if((fResultadoIMC >= 30) && (fResultadoIMC <= 34.9))
        {
            sClassificacao = "Obesidade grau |";
            drawable = getResources().getDrawable(R.drawable.gordo);
        }
        else if((fResultadoIMC >= 35) && (fResultadoIMC <= 39.9))
        {
            sClassificacao = "Obesidade grau || (severa)";
            drawable = getResources().getDrawable(R.drawable.gordo);
        }
        else if(fResultadoIMC >= 40)
        {
            sClassificacao = "Obesidade grau ||| (mórbida)";
            drawable = getResources().getDrawable(R.drawable.gordao);
        }

        if(drawable != null)
        {
            imgView.setImageDrawable(drawable);
            Toast.makeText(getApplicationContext(), sClassificacao, Toast.LENGTH_LONG).show();
        }
    }
}