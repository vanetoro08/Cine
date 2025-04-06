package cine.models;

// @author vanes

import java.util.Date;

public abstract class Funcion {
    protected Date fechaHora;
    protected double porcentajeDescuento;
    protected Pelicula pelicula; 
    
    public Funcion(Date fechaHora) {
        this.fechaHora = fechaHora;
    }    
    
    public abstract double aplicarDescuento(double precio);
}
