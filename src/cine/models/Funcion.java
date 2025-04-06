package cine.models;

import java.util.Date;

/**
 * Clase abstracta que representa una funcion
 * @author Vanessa Toro Sepulveda
 */
public abstract class Funcion {
    protected Date fechaHora;
    protected double porcentajeDescuento;
    protected Pelicula pelicula;
    protected String id;

    /**
     * Constructor para inicializar una funcion
     * 
     * @param fechaHora Fecha y hora de la funcion
     * @param pelicula  Pelicula proyectada
     * @param id        Identificador de la funcion
     */
    public Funcion(Date fechaHora, Pelicula pelicula, String id) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
        this.id = id;
    }

    /**
     * Aplica el descuento correspondiente al tipo de funcion
     * 
     * @return Precio con descuento aplicado
     */
    public abstract double aplicarDescuento();
    
    /**
     * Retorna la pelicula asociada a la funcion
     *
     * @return Pelicula de la funcion
     */
    public Pelicula getPelicula() {
        return pelicula;
    }
    
    /**
     * Retorna el identificador de la funcion
     *
     * @return Id de la funcion
     */
    public String getId() {
        return id;
    }
}
