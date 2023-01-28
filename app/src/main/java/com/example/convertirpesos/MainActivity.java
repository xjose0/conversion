package com.example.convertirpesos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnConvertir;
    private EditText txtPesos;
    private TextView txtDolares;
    private final double tasaCambio = 18.78; // tasa de cambio mxn/usd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        btnConvertir = findViewById(R.id.btnConvertir);
        txtPesos = findViewById(R.id.txtPesos);
        txtDolares = findViewById(R.id.txtDolares);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPesos.getText().toString().equals("")){
                    txtDolares.setText("Error... Campo vacío");
                } else{
                    double cantidadPesos = Double.parseDouble(txtPesos.getText().toString());
                    double cantidadDolares = cantidadPesos / tasaCambio;
                    txtDolares.setText("$" + cantidadPesos + " MXN \n" + String.format("$%.2f", cantidadDolares) + " USD");
                }
            }
        });

    }
}