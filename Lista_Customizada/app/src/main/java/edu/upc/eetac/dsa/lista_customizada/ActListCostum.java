package edu.upc.eetac.dsa.lista_customizada;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 18/12/2016.
 */
public class ActListCostum extends ListActivity {
    //Array de dades
    String[] arrayMontains;
            //"Montseny", "Mont Perdut", "Dôme de Neige", "Pica d'Estats","Pedraforca", "Montardo" };

    String[] arrayAltitude;
//            "1705", "3355", "4015", "3143", "2506", "2833"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        client.get("/monnnn/all", textHandle)

        final String TAG = "ejemplo";
        String BASE_URL = "http://10.0.2.2:8080/lista";
       // String BASE_URL = "http://localhost:8080/myapp/juego";

        Log.i(TAG, "*get Profemons!!!!!!");
        AsyncHttpClient client;
        client = new AsyncHttpClient();
        client.get(BASE_URL + "/ejemplo/all", null, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Type listType = new TypeToken<ArrayList<Muntanyes>>() {
                }.getType();

                List<Muntanyes> locationResults = new Gson().fromJson(responseString, listType);

                  String [] arrayMontains = new String[locationResults.size()];
                String [] arrayAltitude = new String[locationResults.size()];
                int i=0;
                for(Muntanyes m: locationResults){
                    arrayMontains[i] = m.getName();
                    arrayAltitude[i] = m.getAltitude();
                    i++;
                }
                setListAdapter(new ElmeuArrayAdapter(ActListCostum.this, arrayMontains));
                Log.i(TAG, responseString);
            }
            //crea o llama al adaptador
            //)   setListAdapter(new ElmeuArrayAdapter(this, arrayMontains));
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String selectedValue = (String) getListAdapter().getItem(position);
        Intent showMuntanyaInfo = new Intent(ActListCostum.this, MuntanyaActivity.class);
        showMuntanyaInfo.putExtra("muntanyaTitol", selectedValue);
        //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
        showMuntanyaInfo.putExtra("muntanyaInfo", arrayAltitude[position]);
        startActivity(showMuntanyaInfo);

        //agafa els items seleccionats
       /* String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();*/
    }
}
