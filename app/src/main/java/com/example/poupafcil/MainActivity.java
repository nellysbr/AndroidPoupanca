package com.example.poupafcil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private EditText inputNew, inputMounth, inputTime, inputTax;
    private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.textResult);
        inputNew = findViewById(R.id.inputNew);
        inputMounth = findViewById(R.id.inputMounth);
        inputTime = findViewById(R.id.inputTime);
        inputTax = findViewById(R.id.inputTax);

    }

    public void handleCalc(View view){

        DecimalFormat form = new DecimalFormat("R$: 0.00");


        AlertDialog.Builder cxMsg = new AlertDialog.Builder(this);
        cxMsg.setTitle("Erro");
        cxMsg.setMessage("Digite um valor válido");
        cxMsg.setNeutralButton("OK", null);

        double valorInicial = Double.parseDouble(inputNew.getText().toString());
        double tax = Double.parseDouble(inputTax.getText().toString()) / 100 ;
        double appMensal = Double.parseDouble(inputMounth.getText().toString());
        double meses = Double.parseDouble(inputTime.getText().toString());

        double total = valorInicial * Math.pow((1 + tax), meses);


        resultText.setText(form.format(total));



    }
}