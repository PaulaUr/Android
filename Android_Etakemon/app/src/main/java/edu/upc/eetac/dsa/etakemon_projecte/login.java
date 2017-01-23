package edu.upc.eetac.dsa.etakemon_projecte;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.entity.mime.content.StringBody;
import edu.upc.eetac.dsa.etakemon_projecte.apiClient.Api_Manager;
import edu.upc.eetac.dsa.etakemon_projecte.estructura.Usuario;

import static android.R.attr.password;


/**
 * Created by pauli on 16/01/2017.
 */

public class login extends AppCompatActivity {


    private EditText Usuario,Password;
    private static final String TAG="LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Usuario =(EditText)findViewById(R.id.Usuario);
        Password =(EditText)findViewById(R.id.Password);
}

    public void jugar(View view) throws UnsupportedEncodingException {

        final Usuario user= new Usuario();
        user.setNick(Usuario.getText().toString());
        user.setContraseña(Password.getText().toString());

        Api_Manager.post(this, "user/login/", Api_Manager.getObjectAsStringEntity(user), "application/json", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            Log.e(TAG,"error");
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
              //  Log.i(TAG, "Success logging in: " + responseString);
                //convert JSON to Java object-deserializando JSON a un objeto propio
                //    final Gson gson = new Gson();
                // final String jsonInString = "{'Nick': ''}";
                  //  responseString = gson.fromJson("\"mensaje\"",String.class);
                // final Usuario user = gson.fromJson(jsonInString, Usuario.class);
                Toast.makeText(login.this, responseString + "!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this, Juego.class);
                startActivity(intent);
            }
         });
}
    public void registrar(View view){
        Intent intent1 = new Intent(this, registro.class);
        startActivity(intent1);
    }
    public void recuperar(View view){
        Intent intent= new Intent(this, registro.class);
        startActivity(intent);
    }




    }
