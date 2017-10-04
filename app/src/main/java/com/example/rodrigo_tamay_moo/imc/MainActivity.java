package com.example.rodrigo_tamay_moo.imc;

import android.app.Dialog;
import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mCampoPeso, mCampoEstatura;
    private Button mBotonCalcular, mBotonLimpiar;
    private TextView mEtiquetaImc;
    public String s;
    public double peso, estatura, imc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCampoPeso = (EditText)findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText)findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button)findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button)findViewById(R.id.boton_limpiar);
        mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);
        mBotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    s = mCampoPeso.getText().toString();
                    peso = Double.parseDouble(s);
                    s = mCampoEstatura.getText().toString();
                    estatura = Double.parseDouble(s);
                    imc = peso / (estatura * estatura);
                    s = String.format("%2.2f", imc);
                    mEtiquetaImc.setText(s);
                }catch (Exception e){
                    AlertDialog.Builder noti=new AlertDialog.Builder(MainActivity.this);
                    noti.setIcon(R.drawable.war);

                    noti.setTitle("Warning");
                    noti.setMessage("Ingrese Datos");
                    noti.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Gracias", Toast.LENGTH_SHORT).show();
                        }
                    });
                    noti.setNegativeButton(android.R.string.cancel,null);
                    Dialog dialog=noti.create();
                    dialog.show();
            }
        }});

        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }
        });

}
}