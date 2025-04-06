package cine.models;

import java.util.ArrayList;
// @author vanes
public class Pelicula {
    private String nombre; 
    private double costoBase; 

    public Pelicula(String nombre, double costoBase) {
        this.nombre = nombre;
        this.costoBase = costoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
    
    
    
}
