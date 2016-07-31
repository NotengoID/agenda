package com.notengoid.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etNombre;
    EditText etTelefono;
    EditText etEmail;
    EditText etFecha;
    EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        Intent intent = getIntent();

        if(intent == null) {
            return;
        }

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        etNombre.setText(nombre);
        etTelefono.setText(telefono);
        etEmail.setText(email);
        etEmail.setText(fecha);
        etDescripcion.setText(descripcion);

    }

    public void siguiente(View v){
        Intent intent = new Intent(MainActivity.this,DetalleContacto.class);

        intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), etFecha.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());

        startActivity(intent);

        this.finish();
    }
}
