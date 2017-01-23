package edu.upc.eetac.dsa.lista_customizada.api;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import edu.upc.eetac.dsa.lista_customizada.Muntanyes;

/**
 * Created by pauli on 19/12/2016.
 */
public class Api_Manager {

    public final static String TAG="PokEETAC";
    //si se utiliza el emulador la IP:10.0.2.2
    private final static String BASE_URI = "http://10.0.2.2:8080/myapp/";

    /*private static Api_Manager instance;
    //La clase q proporciona Jersey para enviar peticiones a un servicio web Restful es Client
    private ClientConfig clientConfig = null;
    private Client client = null;*/


    public Api_Manager() {
/*        clientConfig = new ClientConfig();
        client = ClientBuilder.newClient(clientConfig);
        loadRoot();*/
    }

    public static List<Muntanyes> getProfemons() {
        Log.i(TAG, "* get Profemons!!!!!!");
        AsyncHttpClient client;
        client = new AsyncHttpClient();
        client.get(BASE_URI + "/ejemplo/all", null, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.i(TAG, responseString);
            }
        });
        return null;
    }
}
