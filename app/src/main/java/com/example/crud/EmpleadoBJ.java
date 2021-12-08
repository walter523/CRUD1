package com.example.crud;

public class EmpleadoBJ {
    public int idem;
    public String nombre1;
    public String Edad1;
    public String telefono1;

    public EmpleadoBJ(int idem, String nombre1, String edad1, String telefono1) {
        this.idem = idem;
        this.nombre1 = nombre1;
        Edad1 = edad1;
        this.telefono1 = telefono1;
    }

    public int getIdem() {
        return idem;
    }

    public void setIdem(int idem) {
        this.idem = idem;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getEdad1() {
        return Edad1;
    }

    public void setEdad1(String edad1) {
        Edad1 = edad1;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }
}
