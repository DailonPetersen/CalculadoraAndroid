package com.example.calculadorafuncionando;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;

/* ********************** CALCULADORA PARA TRABRALHO DO GRAU A - PROG. SISTEMAS MÓVEIS(MOBILE) **********************
   TO DO:
    -

*/
public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    Button btAdicao, btSubtracao, btDivisao, btMultiplicacao, btIgual;
    Button cleanAll, backspace, virgula;
    Button fracao, percent, negative, exponencial, raiz;
    EditText display;
    TextView conta;

    double firstValue, secondValue;
    Double finalValue;

    private char operation;

    //funcao que define os valores
    private void defineValores() {
        if( !Double.isNaN(firstValue) ){ //se meu primeiro valor nao é indefinido
            secondValue = Double.parseDouble(display.getText().toString()); //setando o segundo valor
        } else {
            firstValue = Double.parseDouble(display.getText().toString()); // se primeiro valor for NaN, então definimos ele aqui
        }
    }

    //funcao que calcula baseado no valor atual da var 'operation'
    private void CalculaValores(){
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
            case 'f':
                finalValue = ( 1 / firstValue);
                break;
            case 'n':
                finalValue = (-1 * firstValue);
                break;
            case 'e':
                finalValue = (firstValue*firstValue);
                break;
            case '√':
                finalValue = Math.sqrt(firstValue);
                break;
            case ',':
                finalValue = firstValue /10;
                display.setText(finalValue + "." + secondValue);
                break;
            default:
                String p = display.getText().toString();
                firstValue = Double.parseDouble(p);
                Toast toast = Toast.makeText(getApplicationContext(), "Operação indefinida", Toast.LENGTH_SHORT);
                toast.show();
        }
    }

    public void Ponto(View v){
        display.setText(display.getText() +".");
    }

    public void Percent(View v){ //fazer a conta aqui dentro
        if ( finalValue != null){ //caso já tenha um resultado, quero calcular a partir dele
            finalValue = (finalValue / 100);
            conta.setText(String.valueOf(finalValue));
        }else{
            defineValores();
            secondValue = ((firstValue * secondValue) /100 );
            display.setText(String.valueOf(secondValue));
        }
    }

        public void Raiz(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = '√';
        CalculaValores();
        conta.setText(String.valueOf(finalValue));
        display.setText(" ");
        firstValue = finalValue;
    }

    public void MudaSinal(View v){
        if ( finalValue !=  null ){
            finalValue = (-1*finalValue);
            conta.setText(String.valueOf(finalValue));
        }
        else if (finalValue == null){
            defineValores();
            operation = 'n';
            CalculaValores();
        }
        conta.setText(String.valueOf(finalValue));
        display.setText("");
    }

    public void Exponecial(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = 'e';
        CalculaValores();
        conta.setText(String.valueOf(finalValue));
        display.setText(" ");
        firstValue = finalValue;
    }

    public void Fracao(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = 'f';
        CalculaValores();
        conta.setText(Double.toString(finalValue));
        display.setText("");
        firstValue = finalValue;
    }

    public void Soma(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = '+';
        conta.setText(firstValue + " +");
        display.setText("");
    }

    public void Subtracao(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = '-';
        conta.setText(firstValue + " -");
        display.setText("");
    }

    public void Multiplicacao(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = '*';
        conta.setText(firstValue + " *");
        display.setText("");
    }

    public void Divisao(View v){
        try { defineValores(); } catch (Exception e){ /*do nothing */ }
        operation = '/';
        conta.setText(firstValue + " /");
        display.setText("");
    }

    public void Igual(View v){
        try{
            defineValores();
            CalculaValores();
            conta.setText(String.valueOf(finalValue));
            display.setText(" ");
        } catch (Exception e){
            System.out.print(e);
            Toast t = Toast.makeText(getApplicationContext(), "Clique no C para calcular novamente", Toast.LENGTH_LONG);
            t.show();
        }
        operation = ' ';
        firstValue = finalValue;
    }

    public void cleanAll(View v){
        operation = ' ';
        firstValue = Double.NaN;
        finalValue = null;
        if ( conta.getText() ==  null){
            Toast t = Toast.makeText(getApplicationContext(), "A calculadora está limpa!", Toast.LENGTH_SHORT);
            t.show();
        }
        conta.setText("");
        display.setText("");
    }

    public void backspace(View v){
        try {
            String txt = display.getText().toString();
            txt = txt.substring(0, txt.length() - 1);
            display.setText(txt);
        } catch (Exception e){
            Toast t = Toast.makeText(getApplicationContext(), "Clique no C para calcular novamente", Toast.LENGTH_SHORT);
            t.show();
            System.out.printf(String.valueOf(e));
        }
    }

    public void setBt1(View b) {
        display.setText(display.getText() + "1");
    }
    public void setBt2(View b) {
        display.setText(display.getText() + "2");
    }
    public void setBt3(View b) {
        display.setText(display.getText() + "3");
    }
    public void setBt4(View b) {
        display.setText(display.getText() + "4");
    }
    public void setBt5(View b) {
        display.setText(display.getText() + "5");
    }
    public void setBt6(View b) {
        display.setText(display.getText() + "6");
    }
    public void setBt7(View b) {
        display.setText(display.getText() + "7");
    }
    public void setBt8(View b) {
        display.setText(display.getText() + "8");
    }
    public void setBt9(View b) {
        display.setText(display.getText() + "9");
    }
    public void setBt0(View b) {
        display.setText(display.getText() + "0");
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
        display = findViewById(R.id.display);
        conta = findViewById(R.id.conta);
        cleanAll = findViewById(R.id.clean);
        backspace = findViewById(R.id.backspace);
        virgula = findViewById(R.id.virgula);
        firstValue = Double.NaN;
        finalValue = null;
        operation = ' ';

        try {
            FileInputStream Input = openFileInput("LastNumber.txt");
            InputStreamReader isr = new InputStreamReader(Input);
            BufferedReader br = new BufferedReader(isr);
            conta.setText(br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    @Override
    protected void onStop() {
        super.onStop();
        FileOutputStream Output = null;
        try {
            Output = openFileOutput("LastNumber.txt", Context.MODE_PRIVATE);
            Output.write(finalValue.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(Output != null){
                try {
                    Output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
