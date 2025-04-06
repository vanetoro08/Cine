package cine.models;

// @author vanes
public class UsuarioMayor extends Usuario{

    public UsuarioMayor(String nombre, String id, String telefono) {
        super(nombre, id, telefono);
        this.descuento = 1000;
    }

    @Override
    public double aplicarDescuento(double precio) {
        return precio - descuento;
    }

}
