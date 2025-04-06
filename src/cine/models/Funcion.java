package cine.models;

// @author vanes

import java.util.Date;

public abstract class Funcion {
    protected Date fechaHora;
    protected double porcentajeDescuento;
    protected Pelicula pelicula; 
    
    public Funcion(Date fechaHora,Pelicula pelicula) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
    }    
    
    public abstract double aplicarDescuento();
    
    public Pelicula getPelicula(){
        return pelicula;
    }
}
