package cine.models;

import java.util.Date;

// @author vanes
public class PrimeraFuncion extends Funcion{

    public PrimeraFuncion(Date fechaHora,Pelicula pelicula, String id) {
        super(fechaHora,pelicula, id);
        this.porcentajeDescuento = 0.5;
    }

    @Override
    public double aplicarDescuento() {
        double precioConDescuento = pelicula.getCostoBase() - (pelicula.getCostoBase() * porcentajeDescuento);
        return precioConDescuento;
    }
    
}
