package edu.upc.eetac.dsa.lista_customizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buto1 = (Button) findViewById(R.id.buto1);

        buto1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, ActListCostum.class);
                startActivity(intent1);
            }
        });

    }
}
