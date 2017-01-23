package edu.upc.eetac.dsa.etakemon_projecte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portada);

    }

    public void entrar(View view){
        Intent in1 = new Intent(this, login.class);
        startActivity(in1);
    }

}
