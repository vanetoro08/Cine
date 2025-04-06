package cine.models;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representa una funcion de la tarde con un 10% de descuento
 * Hereda de la clase Funcion
 * 
 * @author Vanessa Toro Sepulveda
 */
public class FuncionTarde extends Funcion {
    /**
     * Constructor de FuncionTarde
     *
     * @param fechaHora Fecha y hora de la funcion
     * @param pelicula Pelicula que se proyectara
     * @param id Identificador unico de la función
     */
    
    public FuncionTarde(Date fechaHora,Pelicula pelicula, String id) {
        super(fechaHora,pelicula, id);
        this.porcentajeDescuento = 0.1;
    }
    
    /**
     * Calcula y retorna el precio con descuento del 10%
     *
     * @return Precio de la entrada con descuento
     */
    
    @Override
    public double aplicarDescuento() {
        double precioConDescuento = pelicula.getCostoBase() - (pelicula.getCostoBase() * porcentajeDescuento);
        return precioConDescuento;
    }

}
