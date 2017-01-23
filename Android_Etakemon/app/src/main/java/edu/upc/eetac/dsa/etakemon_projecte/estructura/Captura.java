package edu.upc.eetac.dsa.etakemon_projecte.estructura;

import java.sql.Date;

/**
 * Created by ivanm on 15/12/2016.
 */
public class Captura {

    public int idcaptura;
    public int idusuarios;
    public int idetakemons;
    public int idhabilidads;
    public int vida;
    public int ataque;
    public int defensa;
    Date fecha;

    public Captura(){
        super();
    }

    public Captura(int idcaptura, int idusuarios, int idetakemons, int idhabilidads, int vida, int ataque, int defensa, Date fecha) {
        super();
        this.idcaptura = idcaptura;
        this.idusuarios = idusuarios;
        this.idetakemons = idetakemons;
        this.idhabilidads = idhabilidads;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.fecha = fecha;
    }

    public int getIdcaptura() {
        return idcaptura;
    }

    public void setIdcaptura(int idcaptura) {
        this.idcaptura = idcaptura;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getIdetakemons() {
        return idetakemons;
    }

    public void setIdetakemons(int idetakemons) {
        this.idetakemons = idetakemons;
    }

    public int getIdhabilidads() {
        return idhabilidads;
    }

    public void setIdhabilidads(int idhabilidads) {
        this.idhabilidads = idhabilidads;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
