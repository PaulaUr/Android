package edu.upc.eetac.dsa.calculatordsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by pauli on 10/12/2016.
 */
public class TerceraPagina extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial2);
    }

    public void noBorrar(){
        Intent intent = getIntent();
        setResult(RESULT_CANCELED,intent);
        finish();
    //retorna a SegundaPagina;

    }
    public void siBorrar(){
        Intent intent = getIntent();
        setResult(RESULT_OK,intent);
        EditText editText = (EditText) findViewById(R.id.num1);
        editText.setText("0");
        EditText editText1 = (EditText) findViewById(R.id.num2);
        editText1.setText("0");
        EditText editText2 = (EditText) findViewById(R.id.resultado);
        editText2.setText("0");
        finish();
        //retorna a MainActivity
    }
}
