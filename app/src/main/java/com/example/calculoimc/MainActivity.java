package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso   = findViewById(R.id.editTextPeso  );
        edtAltura = findViewById(R.id.editTextAltura);

        Toast.makeText(getApplicationContext(), "Quando digitar a altura digite com . ao invés de ,", Toast.LENGTH_SHORT).show();
    }

    public void CalculaIMC(View view)
    {
        float fPeso   = Float.parseFloat(edtPeso.getText().toString());
        float fAltura = Float.parseFloat(edtAltura.getText().toString());

        Intent intent = new Intent(getApplicationContext(), TelaResultadoCalculoIMC.class);
        intent.putExtra("peso"  , fPeso  );
        intent.putExtra("altura", fAltura);
        startActivity(intent);
    }
}