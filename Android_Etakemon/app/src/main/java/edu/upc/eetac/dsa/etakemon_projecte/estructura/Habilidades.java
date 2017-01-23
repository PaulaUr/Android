package edu.upc.eetac.dsa.etakemon_projecte.estructura;

/**
 * Created by ivanm on 15/12/2016.
 */
public class Habilidades {

    public int idhabilidades;
    public String nombre;
    public int potencia;
    public String descripcion;

    public Habilidades(){
        super();
    }

    public Habilidades(int idhabilidades, String nombre, int potencia, String descripcion) {
        super();
        this.idhabilidades = idhabilidades;
        this.nombre = nombre;
        this.potencia = potencia;
        this.descripcion = descripcion;
    }

    public int getIdhabilidades() {
        return idhabilidades;
    }

    public void setIdhabilidades(int idhabilidades) {
        this.idhabilidades = idhabilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

