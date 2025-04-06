package cine.models;

/**
 * Representa un usuario adulto mayor con un descuento de 1000
 * Hereda de la clase Usuario
 * 
 * @author Vanessa Toro Sepulveda
 */
public class UsuarioMayor extends Usuario{
    /**
     * Constructor de UsuarioMayor
     *
     * @param nombre Nombre del usuario
     * @param id Documento de identidad
     * @param telefono Telefono del usuario
     */
    public UsuarioMayor(String nombre, String id, String telefono) {
        super(nombre, id, telefono);
        this.descuento = 1000;
    }
    
    /**
     * Aplica descuento fijo de 1000 unidades
     *
     * @param precio Precio base
     * @return Precio con descuento aplicado
     */
    @Override
    public double aplicarDescuento(double precio) {
        return precio - descuento;
    }

}
