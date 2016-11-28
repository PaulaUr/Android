package edu.upc.eetac.dsa.calculatordsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //public class MainAticity extends AppCompatActivity implements onClickListener{}

    private EditText oper1,oper2;
    private float mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*bt = (button) findViewByid(R.id.button1)
        * bt onClickListener(new onClickListener(this)){
        * @public void onClick(View v){
        * //q fer amb el click
        * }
        * }*/

        oper1=(EditText)findViewById(R.id.num1);
        oper2=(EditText)findViewById(R.id.num2);
    }

    public void resultat(View view){//onClick
        EditText editText = (EditText) findViewById(R.id.resultado);
        editText.setText(" "+mostrar);

    }
    public void Esborrar(View view){
        EditText editText = (EditText) findViewById(R.id.num1);
        editText.setText("0");
        EditText editText1 = (EditText) findViewById(R.id.num2);
        editText1.setText("0");
        EditText editText2 = (EditText) findViewById(R.id.resultado);
        editText2.setText("0");
    }

    public void sumar(View view){
        //convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1+n2;
        mostrar = sum;
    }
    public void restar(View v){
//convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1-n2;
        mostrar =sum;
    }
    public void multiplicar(View v){
//convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1*n2;
        mostrar =sum;
    }
    public void dividir(View v){
//convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1/n2;
        mostrar= sum;
    }

}
