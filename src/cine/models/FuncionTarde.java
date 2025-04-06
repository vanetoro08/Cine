package cine.models;
import java.util.ArrayList;
import java.util.Date;

// @author vanes
public class FuncionTarde extends Funcion {

    public FuncionTarde(Date fechaHora) {
        super(fechaHora);
        this.porcentajeDescuento = 0.1;
    }

    @Override
    public double aplicarDescuento(double precio) {
        double precioConDescuento = precio - (precio * porcentajeDescuento);
        return precioConDescuento;
    }

}
