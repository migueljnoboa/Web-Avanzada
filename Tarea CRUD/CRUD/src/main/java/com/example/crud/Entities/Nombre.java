package com.example.crud.Entities;

public class Nombre {
    private int id;
    private String Nombre;

    public Nombre(int id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEditPath(){
        return "/edit/"+this.id;
    }

    public String getDelete(){
        return "/delete/"+this.id;
    }
}

