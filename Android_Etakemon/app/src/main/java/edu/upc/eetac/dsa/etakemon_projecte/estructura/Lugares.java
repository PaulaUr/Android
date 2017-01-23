package edu.upc.eetac.dsa.etakemon_projecte.estructura;

/**
 * Created by ivanm on 15/12/2016.
 */
public class Lugares extends  DAO{

    public int idlugares;
    public String nombre;
    public double latitud;
    public double longitud;

    public Lugares(){
        super();
    }

    public Lugares(int idlugares, double latitud, double longitud, String nombre) {
        this.idlugares = idlugares;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
    }



    public int getIdlugares() {
        return idlugares;
    }

    public void setIdlugares(int idlugares) {
        this.idlugares = idlugares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
