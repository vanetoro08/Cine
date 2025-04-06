package cine.models;
import java.util.ArrayList;
import java.util.Date;

// @author vanes
public class PrimeraFuncion extends Funcion{

    public PrimeraFuncion(Date fechaHora) {
        super(fechaHora);
        this.porcentajeDescuento = 0.5;
    }

    @Override
    public double aplicarDescuento(double precio) {
        double precioConDescuento = precio - (precio * porcentajeDescuento);
        return precioConDescuento;
    }
    
}
