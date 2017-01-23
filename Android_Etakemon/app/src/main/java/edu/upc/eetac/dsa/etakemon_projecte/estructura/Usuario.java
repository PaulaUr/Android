package edu.upc.eetac.dsa.etakemon_projecte.estructura;

/**
 * Created by pauli on 16/01/2017.
 */

public class Usuario extends DAO{

    private Integer idUsuario;
    private String nombre;
    private String nick;
    private String contraseña;
    private String email;
    private  int batganadas;
    private int batjugadas;
    private int experiencia;


    public Usuario() {
        super();
    }

    public Usuario(String nick, String contraseña) {
        this.nick = nick;
        this.contraseña = contraseña;
    }

    public Usuario(int batganadas, int batjugadas, String contraseña, String email, int experiencia, Integer idUsuario, String nick, String nombre) {
        this.batganadas = batganadas;
        this.batjugadas = batjugadas;
        this.contraseña = contraseña;
        this.email = email;
        this.experiencia = experiencia;
        this.idUsuario = idUsuario;
        this.nick = nick;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getBatganadas() {
        return batganadas;
    }

    public void setBatganadas(int batganadas) {
        this.batganadas = batganadas;
    }

    public int getBatjugadas() {
        return batjugadas;
    }

    public void setBatjugadas(int batjugadas) {
        this.batjugadas = batjugadas;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }



    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
