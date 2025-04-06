package cine.models;

// @author vanes
public class UsuarioNiño extends Usuario{

    public UsuarioNiño(String nombre, String id, String telefono) {
        super(nombre, id, telefono);
        this.descuento = 500;
    }

    @Override
    public double aplicarDescuento(double precio) {
        return precio - descuento;
    }

}
