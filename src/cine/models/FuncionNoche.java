package cine.models;

// @author vanes


import java.util.Date;
// @author vanes
public class FuncionNoche extends Funcion{

    public FuncionNoche(Date fechaHora,Pelicula pelicula, String id) {
        super(fechaHora,pelicula, id);
        this.porcentajeDescuento = 0;
    }    

    @Override
    public double aplicarDescuento() {
        double precioConDescuento = pelicula.getCostoBase() - (pelicula.getCostoBase() * porcentajeDescuento);
        return precioConDescuento;
    }
}
