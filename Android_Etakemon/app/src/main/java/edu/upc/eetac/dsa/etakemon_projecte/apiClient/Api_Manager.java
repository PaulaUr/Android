package edu.upc.eetac.dsa.etakemon_projecte.apiClient;

import android.content.Context;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.Form;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by pauli on 17/01/2017.
 */

public class Api_Manager {

    private final static String TAG="Etakemon";
    //si se utiliza el emulador la IP:10.0.2.2
    private final static String BASE_URL = "http://10.193.184.73:8080/myapp/";

    /*private static Api_Manager instance;
    //La clase q proporciona Jersey para enviar peticiones a un servicio web Restful es Client
    private ClientConfig clientConfig = null;
    private Client client = null;*/

   private static AsyncHttpClient client = new AsyncHttpClient();

    public static StringEntity getObjectAsStringEntity(Object object){

        StringEntity entity = null;
        try{

            entity = new StringEntity(new Gson().toJson(object)); //convert JavaObject to Json and assign to a String

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return entity;
    }


    public static  void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static  void post(Context context, String url, StringEntity entity,String contentType, AsyncHttpResponseHandler responseHandler){
        client.post(context,getAbsoluteUrl(url),entity, contentType, responseHandler);


    }

    private static String getAbsoluteUrl(String relativeUrl){
        return BASE_URL +relativeUrl;
    }



}
