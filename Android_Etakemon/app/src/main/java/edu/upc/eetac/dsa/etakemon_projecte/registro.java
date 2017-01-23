package edu.upc.eetac.dsa.etakemon_projecte;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;
import edu.upc.eetac.dsa.etakemon_projecte.apiClient.Api_Manager;
import edu.upc.eetac.dsa.etakemon_projecte.estructura.Usuario;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED_TYPE;

/**
 * Created by pauli on 16/01/2017.
 */

public class registro extends AppCompatActivity {

    //si se utiliza el emulador la IP:10.0.2.2
    //private final static String BASE_URL = "http://192.168.1.132:8080/myapp/";

    private EditText Usuario, Password, Nombre, Email;
    private static final String TAG = "Registro";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        Nombre = (EditText) findViewById(R.id.Nombre);
        Usuario = (EditText) findViewById(R.id.Usuario);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
    }

    public void registro1(View view) throws JSONException, UnsupportedEncodingException {
        final Usuario user = new Usuario();
       user.setNombre(Nombre.getText().toString());
     //   String nombre = Nombre.getText().toString();
        user.setNick(Usuario.getText().toString());
      //  String nick = Usuario.getText().toString();
       user.setEmail(Email.getText().toString());
       // String email = Email.getText().toString();
        user.setContraseña(Password.getText().toString());
        //String contraseña = Password.getText().toString();
        /*JSONObject param = new JSONObject();
        param.put("nombre",Nombre);
        param.put("nick",Usuario);
        param.put("email",Email);
        param.put("contraseña",Password);
        StringEntity entity = new StringEntity(param.toString());
        entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));*/
        //    final Gson gson = new Gson();
        // final String jsonInString = "{'Nick': ''}";


        System.out.println(Api_Manager.getObjectAsStringEntity(user));
        Api_Manager.post(this, "user/resgister/" , Api_Manager.getObjectAsStringEntity(user), "application/json", new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e(TAG,"error");

                    }
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {

                        Toast.makeText(registro.this, responseString + "!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(registro.this, Juego.class);
                        startActivity(intent);
                    }
                });


                //Api_Manager.post(this, "user/registro/" +nombre+ "/" +nick+ "/" +email+ "/"+contraseña,(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE)){


    }
}