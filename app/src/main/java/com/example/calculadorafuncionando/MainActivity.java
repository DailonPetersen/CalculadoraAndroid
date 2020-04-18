package com.example.calculadorafuncionando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    Button btAdicao, btSubtracao, btDivisao, btMultiplicacao;
    Button cleanAll, backspace, virgula;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.one);
        bt2 = findViewById(R.id.two);
        bt3 = findViewById(R.id.three);
        bt4 = findViewById(R.id.four);
        bt5 = findViewById(R.id.five);
        bt6 = findViewById(R.id.six);
        bt7 = findViewById(R.id.seven);
        bt8 = findViewById(R.id.eight);
        bt9 = findViewById(R.id.nine);
        btAdicao = findViewById(R.id.some);
        btSubtracao = findViewById(R.id.minos);
        btMultiplicacao = findViewById(R.id.multiply);
        btDivisao = findViewById(R.id.divide);
        display = findViewById(R.id.display);
        cleanAll = findViewById(R.id.clean);
        backspace = findViewById(R.id.backspace);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "1");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "2");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "3");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "4");
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "5");
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "6");
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "7");
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "8");
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "9");
            }
        });

        btAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "+");
            }
        });

        btAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cleanAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Object> textoAtual = new ArrayList<>();

                String texto = display.toString();



                   textoAtual.remove(-1);
                   String novoTexto = textoAtual.toString();
                   display.setText(novoTexto);

            }
        });



    }



}
