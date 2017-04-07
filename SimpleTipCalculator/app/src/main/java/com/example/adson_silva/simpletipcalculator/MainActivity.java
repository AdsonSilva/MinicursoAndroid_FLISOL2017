package com.example.adson_silva.simpletipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText valorConta;
    EditText qntdPessoas;


    TextView valorTotal;
    TextView valorIndividual;

    Button btnCalcular;

    LinearLayout result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.valorConta = (EditText) findViewById(R.id.conta);
        this.qntdPessoas = (EditText)findViewById(R.id.qntPessoas);

        this.valorTotal = (TextView)findViewById(R.id.valorTotal);
        this.valorIndividual = (TextView)findViewById(R.id.valorIndividual);

        this.btnCalcular = (Button)findViewById(R.id.btnCalcular);

        this.result = (LinearLayout)findViewById(R.id.result);

        this.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double conta = Double.parseDouble(valorConta.getText().toString());
                int pessoas = Integer.parseInt(qntdPessoas.getText().toString());

                double contaTotal = conta + calculaGorjeta(conta);

                valorTotal.setText(Double.toString(contaTotal));

                valorIndividual.setText(Double.toString(contaTotal/pessoas));

                result.setVisibility(View.VISIBLE);
            }
        });

    }

    private double calculaGorjeta(double conta){
        return conta * 0.1;
    }
}
