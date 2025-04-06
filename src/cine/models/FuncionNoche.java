package cine.models;

// @author vanes


import java.util.Date;
// @author vanes
public class FuncionNoche extends Funcion{

    public FuncionNoche(Date fechaHora) {
        super(fechaHora);
        this.porcentajeDescuento = 0;
    }    

    @Override
    public double aplicarDescuento(double precio) {
        return precio;
    }
}
