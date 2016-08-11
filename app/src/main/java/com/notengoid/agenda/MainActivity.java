package com.notengoid.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.support.design.widget.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText etNombre;
    TextInputEditText etTelefono;
    TextInputEditText etEmail;
    DatePicker etFecha;
    TextInputEditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etTelefono = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etFecha = (DatePicker) findViewById(R.id.etFecha);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);
        String extras = null;

        Intent intent = getIntent();

        if(intent == null) {
            return;
        }

        Bundle parametros = getIntent().getExtras();

        if(parametros == null){
            return;
        }

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));


        if(fecha == null){
            return;
        }

        etNombre.setText("" + nombre);
        etTelefono.setText("" + telefono);
        etEmail.setText("" + email);
        etDescripcion.setText("" + descripcion);

        System.out.print(Integer.parseInt(fecha.substring(0,2)) + "/" + (Integer.parseInt(fecha.substring(3,5))-1) + "/" + Integer.parseInt(fecha.substring(6)));
        etFecha.updateDate(Integer.parseInt(fecha.substring(6)),Integer.parseInt(fecha.substring(3,5))-1,Integer.parseInt(fecha.substring(0,2)));
    }

    public void siguiente(View v){
        Intent intent = new Intent(MainActivity.this,DetalleContacto.class);

        intent.putExtra(getResources().getString(R.string.pnombre), "" + etNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), "" + etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), "" + etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), "" +
                ((etFecha.getDayOfMonth()<10)?"0":"") + etFecha.getDayOfMonth() + "-" +
                ((etFecha.getMonth()<9)?"0":"")+(etFecha.getMonth() + 1) + "-" +
                etFecha.getYear());
        intent.putExtra(getResources().getString(R.string.pdescripcion), "" + etDescripcion.getText().toString());

        startActivity(intent);
        this.finish();
    }
}
