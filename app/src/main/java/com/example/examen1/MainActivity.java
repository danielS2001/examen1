package com.example.examen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtBase;
    private EditText txtAltura;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;
    private Rectangulo rectangle = new Rectangulo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNombre.setText("");
                txtAltura.setText("");
                txtBase.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNombre.getText().toString().matches("") ||
                txtBase.getText().toString().matches("") ||
                txtAltura.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Faltó capturar información", Toast.LENGTH_SHORT).show();
                } else {
                float base = Float.parseFloat(txtBase.getText().toString());
                rectangle.setBase(base);
                float altura = Float.parseFloat(txtAltura.getText().toString());
                rectangle.setAltura(altura);

                Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Rectangulo", rectangle);
                intent.putExtra("nombre", txtNombre.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar APP?");
                confirmar.setMessage("Se descartará toda la información ingresada");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nada
                    }
                });
                confirmar.show();
            }
        });


    }



    private void iniciar() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }
}