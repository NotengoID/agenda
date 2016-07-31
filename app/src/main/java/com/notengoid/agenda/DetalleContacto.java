package com.notengoid.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvFecha;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvEmail.setText(fecha);
        tvDescripcion.setText(descripcion);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void editar(View v){
        Intent intent = new Intent(DetalleContacto.this,MainActivity.class);

        intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), tvTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), tvEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), tvFecha.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), tvDescripcion.getText().toString());

        startActivity(intent);

        this.finish();
    }
}
