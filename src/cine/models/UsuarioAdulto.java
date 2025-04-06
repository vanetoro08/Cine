package cine.models;

// @author vanes
public class UsuarioAdulto extends Usuario{

    public UsuarioAdulto(String nombre, String id, String telefono) {
        super(nombre, id, telefono);
        this.descuento = 0;
    }

    @Override
    public double aplicarDescuento(double precio) {
        return precio;
    }

}
