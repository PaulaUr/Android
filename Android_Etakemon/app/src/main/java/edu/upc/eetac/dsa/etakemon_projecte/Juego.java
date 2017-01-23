package edu.upc.eetac.dsa.etakemon_projecte;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import edu.upc.eetac.dsa.etakemon_projecte.apiClient.Api_Manager;
import edu.upc.eetac.dsa.etakemon_projecte.estructura.Etakemon;
import edu.upc.eetac.dsa.etakemon_projecte.estructura.Lugares;

/**
 * Created by pauli on 17/01/2017.
 */

public class Juego extends AppCompatActivity implements OnMarkerClickListener, OnMapClickListener, OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener {
    private static final String TAG = "Juego";


    private static final LatLng Etakemon1 = new LatLng(41.27564,1.98520);
    private static final LatLng Etakemon2= new LatLng(41.27551,1.98611);
    private static final LatLng Etakemon3= new LatLng(41.27606,1.98678);
     private static final LatLng Etakemon4= new LatLng(41.27629,1.98931);
    private GoogleMap mMap;
    ;

    private Marker mSelectedMarker;

    int id;
    String name;
    double lat, lon;
    Lugares lugares= new Lugares();
    List<Lugares> localizaciones = new ArrayList<Lugares>();

    Location location;
//    LatLng latLng;

    // /String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        new OnMapAndViewReadyListener(mapFragment, this);

    }

    public void onMapReady(GoogleMap map) {

        mMap = map;

        Api_Manager.get("juego/location", null, new JsonHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e(TAG, "error");

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray responseString) {
                for (int j = 0; j < responseString.length(); j++) {
                    try {
                        id = Integer.parseInt(responseString.getJSONObject(j).get("idlugares").toString());
                        name = responseString.getJSONObject(j).get("nombre").toString();
                        lat = Double.parseDouble(responseString.getJSONObject(j).get("latitud").toString());
                        lon = Double.parseDouble(responseString.getJSONObject(j).get("longitud").toString());
                        Lugares etakolugar = new Lugares();
                        etakolugar.setIdlugares(id);
                        etakolugar.setNombre(name);
                        etakolugar.setLatitud(lat);
                        etakolugar.setLongitud(lon);
                        localizaciones.add(etakolugar);
                        //  Log.e(" "+localizaciones);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                   /* int i = 0;
                    while (i < localizaciones.size()) {

                        Lugares lugar = localizaciones.get(i);
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(lugar.getLatitud(), lugar.getLongitud()))
                                .title(lugar.getNombre())
                        );
                    }
                    i++;*/
                }
            }
        });
        // Hide the zoom controls.
        mMap.getUiSettings().setZoomControlsEnabled(false);
        // Add lots of markers to the map.
        addMarkersToMap();
        // Set listener for marker click event.  See the bottom of this class for its behavior.
        mMap.setOnMarkerClickListener(this);
        // Set listener for map click event.  See the bottom of this class for its behavior.
        mMap.setOnMapClickListener(this);
        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localized.
        map.setContentDescription("Demo showing how to close the info window when the currently"
                + " selected marker is re-tapped.");
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(Etakemon1)
                .include(Etakemon3)
                .include(Etakemon2)
                .include(Etakemon4)
                .build();

//        LatLng latLng = new LatLng(lat,lon);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 19f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,50));
       //
      //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 19f));

    }



    private void addMarkersToMap() {
        /*int i = 0;
        while (i < localizaciones.size()) {

            Lugares lugar = localizaciones.get(i);
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lugar.getLatitud(), lugar.getLongitud()))
                    .title(lugar.getNombre())
            );

        }
        i++;*/

        mMap.addMarker(new MarkerOptions()
                .position(Etakemon3)
                .title("etakemon acuatico")
                .snippet("Habilidad de nadar"))
                ;

        mMap.addMarker(new MarkerOptions()
                .position(Etakemon1)
                .title("etakemon de tierra")
                .snippet("habilidad de correr"));

        mMap.addMarker(new MarkerOptions()
                .position(Etakemon2)
                .title("etakemon pulga")
                .snippet("habilidad saltar"));

        mMap.addMarker(new MarkerOptions()
                .position(Etakemon4)
                .title("etakemon caballito de mar")
                .snippet("habilidad de volar"));
    }



    @Override
    public void onMapClick(LatLng latLng) {
        // Any showing info window closes when the map is clicked.
        // Clear the currently selected marker.
        mSelectedMarker = null;

    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        // The user has re-tapped on the marker which was already showing an info window.
        if (marker.equals(mSelectedMarker)) {
            // The showing info window has already been closed - that's the first thing to happen
            // when any marker is clicked.
            // Return true to indicate we have consumed the event and that we do not want the
            // the default behavior to occur (which is for the camera to move such that the
            // marker is centered and for the marker's info window to open, if it has one).
            mSelectedMarker = null;
            return true;

        }
        mSelectedMarker = marker;

        return false;
    }
/*extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) { //metodo para administrar el objeto GooglMap
        mMap = googleMap;

      //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(41.275,1.986),4));
     //   mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.etakemon4)).anchor(0.0f,1.0f).position(new LatLng(41.275,1.986)));


// Add a marker in Sydney and move the camera
        LatLng castelldefels = new LatLng(41.275, 1.986);
        mMap.addMarker(new MarkerOptions().position(castelldefels).title("Marker in EETAC-Castelldefels"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(castelldefels));
    */

}
