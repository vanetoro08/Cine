package cine.models;
import java.util.ArrayList;
import java.util.Date;

// @author vanes
public class FuncionTarde extends Funcion {

    public FuncionTarde(Date fechaHora,Pelicula pelicula) {
        super(fechaHora,pelicula);
        this.porcentajeDescuento = 0.1;
    }

    @Override
    public double aplicarDescuento() {
        double precioConDescuento = pelicula.getCostoBase() - (pelicula.getCostoBase() * porcentajeDescuento);
        return precioConDescuento;
    }

}
