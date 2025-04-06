package cine.models;

import java.util.ArrayList;
/**
 * Representa una pelicula proyectada en el cine
 * 
 * @autor Nicolas Agudelo Grajales
 */
public class Pelicula {
    private String nombre; 
    private double costoBase; 
    
    /**
     * Constructor de Pelicula
     *
     * @param nombre Nombre de la pelicula
     * @param costoBase Precio base de la entrada para esta pelicula
     */
    
    public Pelicula(String nombre, double costoBase) {
        this.nombre = nombre;
        this.costoBase = costoBase;
    }
    
    /**
     * Devuelve el nombre de la pelicula
     * @return Nombre de la pelicula
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la pelicula
     * @param nombre Nombre que se desea asignar a la pelicula
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el costo base de la pelicula
     * @return Costo base de la pelicula
     */
    public double getCostoBase() {
        return costoBase;
    }

    /**
     * Establece el costo base de la pelicula
     * @param costoBase Costo base que se desea asignar
     */
    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    } 
    
}
