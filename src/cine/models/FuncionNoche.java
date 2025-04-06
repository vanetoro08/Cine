package cine.models;

import java.util.Date;

/**
 * Representa una funcion nocturna sin descuento aplicado
 * Hereda de la clase Funcion
 * 
 * @author Vanessa Toro Sepulveda
 */
public class FuncionNoche extends Funcion {
    /**
     * Constructor de FuncionNoche
     *
     * @param fechaHora Fecha y hora de la funcion
     * @param pelicula Pelicula que se proyectara
     * @param id Identificador único de la función
     */
    
    public FuncionNoche(Date fechaHora, Pelicula pelicula, String id) {
        super(fechaHora, pelicula, id);
        this.porcentajeDescuento = 0;
    }
    
    /**
     * Retorna el precio sin aplicar descuento
     *
     * @return Precio de la entrada sin descuento
     */
    @Override
    public double aplicarDescuento() {
        return pelicula.getCostoBase();
    }
}
