package com.example.examen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RectanguloActivity extends AppCompatActivity {
    private TextView lblArea;
    private TextView lblPerimetro;
    private TextView lblBase;
    private TextView lblAltura;
    private TextView lblNombre;
    private Button btnCalcular;
    private Button btnRegresar;
    private RadioGroup radioGroup;
    private RadioButton selectedRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        iniciar();
        Bundle datos = getIntent().getExtras();

        Rectangulo rectangulo = (Rectangulo) datos.getSerializable("Rectangulo");

        lblBase.setText("Base : " +rectangulo.getBase());
        lblAltura.setText("Altura : " +rectangulo.getAltura());
        lblNombre.setText("Nombre: " +datos.getString("nombre"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedRbText = selectedRadioButton.getText().toString();
                    if (selectedRbText.matches("Area")) {
                        lblArea.setText(" " +rectangulo.calculoArea());
                    } else if (selectedRbText.matches("Perimetro")) {
                        lblPerimetro.setText(" " +rectangulo.calculoPerimetro());
                    }
                    //textView.setText(selectedRbText + " is Selected");
                }



            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(RectanguloActivity.this);
                confirmar.setTitle("¿Regresar?");
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
        lblArea = (TextView) findViewById(R.id.lblArea);
        lblPerimetro = (TextView) findViewById(R.id.lblPerimetro);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblBase = (TextView) findViewById(R.id.lblBase);
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        //radioGroup = findViewById(R.id.radioGroup);
        radioGroup = findViewById(R.id.radioGroup);
    }
}