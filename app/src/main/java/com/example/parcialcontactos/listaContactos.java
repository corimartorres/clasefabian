package com.example.parcialcontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class listaContactos extends AppCompatActivity {

    private TextView tvMostrarNombre, tvMostrarTelefono, rbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
        String nombre, telefono, button;
        tvMostrarNombre = (TextView) findViewById(R.id.tvMostrarNombre);
        tvMostrarTelefono = (TextView) findViewById(R.id.tvMostrarTelefono);
        rbutton = (TextView) findViewById(R.id.tv_grupo);

        Bundle bundle =this.getIntent().getExtras();
        if (bundle != null) {
            nombre = bundle.getString("nombre");
            telefono = bundle.getString("telefono");
            button = bundle.getString("grupo");

            tvMostrarNombre.setText(nombre);
            tvMostrarTelefono.setText(telefono);
            rbutton.setText(button);
        }
    }

    public void regresar(View v){
        finish();
    }

    public void borrartodos (View v){
        tvMostrarNombre.setText("");
        tvMostrarTelefono.setText("");
        rbutton.setText("");
    }

    public void ordenarapellido (View v){
        Toast.makeText(getBaseContext(), "Contactos Ordenados por Apellido",Toast.LENGTH_SHORT).show();
    }

    public void ordenargrupo (View v){
        Toast.makeText(getBaseContext(), "Contactos Ordenados por Grupo",Toast.LENGTH_SHORT).show();
    }

    public void listainvertida (View v){
        Toast.makeText(getBaseContext(), "Lista Invertida",Toast.LENGTH_SHORT).show();
    }

}
