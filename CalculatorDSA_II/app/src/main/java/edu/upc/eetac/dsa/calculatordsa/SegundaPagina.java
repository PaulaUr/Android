package edu.upc.eetac.dsa.calculatordsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 05/12/2016.
 */
public class SegundaPagina extends AppCompatActivity {

    TextView textView3;
    String listaConcatenar;
    String[] trozos;
    List<String> lista = new ArrayList<>();
    StringBuffer texto= new StringBuffer();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial);

    textView3 = (TextView) findViewById(R.id.textView3);
    Bundle intentdata = getIntent().getExtras();

    String listaConcatenar = intentdata.getString("valor1");
        //textView3.setText(txtpas);
    trozos = listaConcatenar.split(",");

        for(int i=0;i<trozos.length; i++)
        {
            lista.add(trozos[i]);
        }
        for(int i=0;i<lista.size();i++){

            texto.append(i+ ": " +lista.get(i)+ "\r\n");
        }
        textView3.setText(texto.toString());
}
    public void volver(View view){

        Intent devolver = getIntent();
        editText =(EditText) findViewById(R.id.fila);
        String fila = editText.getText().toString();

        try {
            int i = Integer.parseInt(fila);
            devolver.putExtra("fila", lista.get(i).toString());
            setResult(RESULT_OK, devolver);
            finish();
            //startActivity(devolver);
        }catch (Exception e){
            setResult(RESULT_CANCELED,devolver);
            finish();
        }

    }
    public void Borrar(View view){
        Intent actividad3 = new Intent(SegundaPagina.this, TerceraPagina.class);
        startActivityForResult(actividad3,101);
    }

    protected  void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Intent intent = getIntent();
        if((requestCode == 101) && (resultCode == Activity.RESULT_OK)){
            lista.clear();
            setResult(222,intent);
            finish();
        }

    }

}
