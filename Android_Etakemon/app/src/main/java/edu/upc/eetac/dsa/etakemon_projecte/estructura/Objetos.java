package edu.upc.eetac.dsa.etakemon_projecte.estructura;

/**
 * Created by ivanm on 15/12/2016.
 */
public class Objetos {

    public int idobjetos;
    public String nombre;
    public String descripcion;

    public Objetos(){
        super();
    }

    public Objetos(int idobjetos, String nombre, String descripcion) {
        super();
        this.idobjetos = idobjetos;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdobjetos() {
        return idobjetos;
    }

    public void setIdobjetos(int idobjetos) {
        this.idobjetos = idobjetos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
