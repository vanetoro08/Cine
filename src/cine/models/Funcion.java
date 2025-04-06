package cine.models;

// @author vanes

import java.util.Date;

public abstract class Funcion {
    protected Date fechaHora;
    protected double porcentajeDescuento;
    protected Pelicula pelicula; 
    protected String id; 
    
    public Funcion(Date fechaHora,Pelicula pelicula, String id) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
        this.id = id; 
    }    
    
    public abstract double aplicarDescuento();
    
    public Pelicula getPelicula(){
        return pelicula;
    }

    public String getId() {
        return id;
    }
    
    
}
