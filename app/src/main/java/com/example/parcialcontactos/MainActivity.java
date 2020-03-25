package com.example.parcialcontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_telefono;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_telefono = (EditText) findViewById(R.id.et_telefono);
        rg = findViewById(R.id.rg);

        registerForContextMenu(et_nombre);
        registerForContextMenu(et_telefono);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        int id = v.getId();
        MenuInflater inflater = getMenuInflater();

        switch (id){
            case R.id.et_nombre:
                inflater.inflate(R.menu.menu_mayusculas, menu);
                break;
            case R.id.et_telefono:
                inflater.inflate(R.menu.menu_aleatorios, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.convertir_mayuscula:
                //convertir mayusculas
                et_nombre.setText(et_nombre.getText().toString().toUpperCase());
                return true;
            case R.id.generar_aleatorio:
                int x, n1, n2;
                Random ran = new Random();
                x = ran.nextInt(3);
                n1 = ran.nextInt(899)+100;
                n2 = ran.nextInt(8999)+1000;
                String numero = ("3" + x + "0" + n1 + n2);
                et_telefono.setText(numero);
                //Toast.makeText(this, "Generando Aleatorio", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //Botones de acción
    public void checkButton(View v) {
        int radioId = rg.getCheckedRadioButtonId();
        rb = findViewById(radioId);
    }

    public void guardarcontacto(View v){
        String nombre = et_nombre.getText().toString();
        String telefono = et_telefono.getText().toString();
        if (rg.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "El grupo es requerido", Toast.LENGTH_LONG).show();
        }
        if(nombre.length() == 0){
            Toast.makeText(this, "El campo Nombre es requerido", Toast.LENGTH_LONG).show();
        }
        if (telefono.length() == 0) {
            Toast.makeText(this, "El campo Teléfono es requerido", Toast.LENGTH_LONG).show();
        }

        if (nombre.length() != 0  && telefono.length() != 0 && rg.getCheckedRadioButtonId() != -1) {
            Intent i = new Intent(this, listaContactos.class);
            i.putExtra("nombre", et_nombre.getText().toString());
            i.putExtra("telefono", et_telefono.getText().toString());
            i.putExtra("grupo", rb.getText().toString());
            startActivity(i);
        }
    }

    public void  cerrar (View v){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.btn_limpiar:
                et_nombre.setText("");
                et_telefono.setText("");
                break;
            case R.id.btn_contacto:
                Intent i = new Intent(this, listaContactos.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
