package edu.upc.eetac.dsa.calculatordsa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //public class MainAticity extends AppCompatActivity implements onClickListener{}

    private EditText oper1,oper2;
    public float mostrar;
    List<String> llista = new ArrayList<>();
    StringBuffer buffer= new StringBuffer();



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

        //llista.add(mostrar);


    }

    public void resultat(View view){//onClick

         String mResultat = String.valueOf(mostrar);
        // buffer.append(mResultat);



        EditText editText = (EditText) findViewById(R.id.resultado);
        //editText.setText(" " +mostrar);
        editText.setText(" " +mResultat);

    }
    public void Esborrar(View view){
        EditText editText = (EditText) findViewById(R.id.num1);
        editText.setText("0");
        EditText editText1 = (EditText) findViewById(R.id.num2);
        editText1.setText("0");
        EditText editText2 = (EditText) findViewById(R.id.resultado);
        editText2.setText("0");
    }
    public void Historial(View view){

       // buffer.append(mostrar);

        Intent intent = new Intent(this, SegundaPagina.class);
        intent.putExtra("valor1", buffer.toString());
        startActivity(intent);

      //  TextView text = (TextView) findViewById(R.id.resultado);
       // String message = text.toString();
       // intent.putExtra();

    }

    public void sumar(View view){
        //convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1+n2;
        mostrar = sum;
        String mResultat = String.valueOf(mostrar);

        buffer.append(n1+"+"+n2+ "=" +mResultat +",");


    }
    public void restar(View v){
//convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1-n2;
        mostrar =sum;

        String mResultat = String.valueOf(mostrar);
        buffer.append(n1+" - "+n2+ "= " +mResultat +",");
    }
    public void multiplicar(View v){
//convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1*n2;
        mostrar =sum;

        String mResultat = String.valueOf(mostrar);
        buffer.append(n1+" x "+n2+ "= " +mResultat +",");

    }
    public void dividir(View v){
//convertimos a número los valores introducidos y operamos
        float n1=Float.parseFloat(oper1.getText().toString());
        float n2=Float.parseFloat(oper2.getText().toString());
        float sum=n1/n2;
        mostrar = sum;

        String mResultat = String.valueOf(mostrar);
        buffer.append(n1+" / "+n2+ "= " +mResultat +",");
    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if((requestCode==100)&&(resultCode== Activity.RESULT_OK)){
            Bundle result = data.getExtras();
            String result1 = result.getString("fila");
            EditText editText = (EditText) findViewById(R.id.num1);
            EditText editText1 = (EditText) findViewById(R.id.num2);
            RadioGroup radioGroup= (RadioGroup) findViewById(R.id.groupRadio);
            TextView textRes=(TextView)findViewById(R.id.resultado);
            String[] result2 =null;
            String[] result3 = result.getString("fila").split("=");
            if(result3[0].contains(" + ")){
                result2 = result3[0].split(" + ");
                radioGroup.check(R.id.radioButton);
            }
            if (result3[0].contains(" - "))
            {
                result2 = result3[0].split("-");
                radioGroup.check(R.id.radioButton2);
            }
            if (result3[0].contains("x"))
            {
                result2 = result3[0].split("x");
                radioGroup.check(R.id.radioButton3);
            }
            if (result3[0].contains("/"))
            {
                result2 = result3[0].split("/");
                radioGroup.check(R.id.radioButton4);
            }
            editText.setText(result2[1]);
            editText1.setText(result2[0]);
            textRes.setText("0");

        }else if(resultCode == 222){
            this.buffer.setLength(0);
            EditText editText =(EditText)findViewById(R.id.num1);
            EditText editText1=(EditText) findViewById(R.id.num2);
            TextView result =(TextView)findViewById(R.id.resultado);
            editText.setText("0");
            editText1.setText("0");
            result.setText("0");

        }
    }

}
