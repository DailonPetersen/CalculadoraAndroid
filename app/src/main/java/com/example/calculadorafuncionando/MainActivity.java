package com.example.calculadorafuncionando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    Button btAdicao, btSubtracao, btDivisao, btMultiplicacao, btIgual;
    Button cleanAll, backspace, virgula;
    EditText display;
    TextView conta;

    Double firstValue = Double.NaN;
    Double secondValue;

    private char operation;

    //funcao que calcula
    private Double calculaValores() {
        if( !Double.isNaN(firstValue) ){ //se meu primeiro valor nao é indefinido
            secondValue = Double.parseDouble(display.getText().toString()); //setando o segundo valor

            Double finalValue = 0.0;

            switch (operation) {
                case '+':
                    finalValue = firstValue + secondValue;
                    break;
                case '-':
                    finalValue = firstValue - secondValue;
                    break;
                case '*':
                    finalValue = firstValue * secondValue;
                    break;
                case '/':
                    finalValue = firstValue / secondValue;
                    break;
                default:
                    display.setText("Opçao Inváida");
            }
            return finalValue;
        } else{
            firstValue = Double.parseDouble(display.getText().toString()); // se primeiro valor for NaN, então definimos ele aqui
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia as variaveis usando os valores digitados
        bt1 = findViewById(R.id.one);
        bt2 = findViewById(R.id.two);
        bt3 = findViewById(R.id.three);
        bt4 = findViewById(R.id.four);
        bt5 = findViewById(R.id.five);
        bt6 = findViewById(R.id.six);
        bt7 = findViewById(R.id.seven);
        bt8 = findViewById(R.id.eight);
        bt9 = findViewById(R.id.nine);
        bt0 = findViewById(R.id.zero);
        btAdicao = findViewById(R.id.some);
        btSubtracao = findViewById(R.id.minos);
        btMultiplicacao = findViewById(R.id.multiply);
        btDivisao = findViewById(R.id.divide);
        btIgual = findViewById(R.id.equals);
        display = findViewById(R.id.display);
        conta = findViewById(R.id.conta);
        cleanAll = findViewById(R.id.clean);
        backspace = findViewById(R.id.backspace);

        //evento quando o botao é clicado
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
                calculaValores();
                operation = '+';
                conta.setText(firstValue + "+");
                display.setText(null);
            }
        });

        btSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaValores();
                operation = '-';
                conta.setText(firstValue + "-");
                display.setText(null);
            }
        });

        btMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaValores();
                operation = '*';
                conta.setText(firstValue + "*");
                display.setText(null);
            }
        });

        btDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaValores();
                operation = '/';
                conta.setText(firstValue + "/");
                display.setText(null);
            }
        });

        btIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double finalValue = calculaValores();
                operation = '0';
                conta.setText(conta.getText().toString() + secondValue + " = " + finalValue);
                firstValue = Double.NaN; //precisa voltar a ser indefinido
                display.setText(null);
            }
        });

        cleanAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conta.setText("");
                display.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = display.getText().toString();
                txt = txt.substring(0, txt.length() - 1);
                display.setText(txt);
            }
        });

    }



}
