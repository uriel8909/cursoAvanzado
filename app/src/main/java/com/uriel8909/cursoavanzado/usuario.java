package com.uriel8909.cursoavanzado;

public class usuario {
    private int id;
    private String nombre;
    private String password;
    private String genero;
    private String rol;
    private String correo;

    public usuario(int id, String nombre, String password, String genero, String rol, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.genero = genero;
        this.rol = rol;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
