package cine.models;

import java.util.Date;

/**
 * Representa la primera funcion del dia con un 50% de descuento
 * Hereda de la clase Funcion
 * 
 * @autor Vanessa Toro Sepulveda
 */
public class PrimeraFuncion extends Funcion{
    /**
     * Constructor de PrimeraFuncion
     *
     * @param fechaHora Fecha y hora de la funcion
     * @param pelicula Pelicula que se proyectara
     * @param id Identificador unico de la funcion
     */
    public PrimeraFuncion(Date fechaHora,Pelicula pelicula, String id) {
        super(fechaHora,pelicula, id);
        this.porcentajeDescuento = 0.5;
    }
    
    /**
     * Calcula y retorna el precio con 50% de descuento
     *
     * @return Precio de la entrada con descuento
     */
    @Override
    public double aplicarDescuento() {
        double precioConDescuento = pelicula.getCostoBase() - (pelicula.getCostoBase() * porcentajeDescuento);
        return precioConDescuento;
    }
    
}
