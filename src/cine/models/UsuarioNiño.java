package cine.models;

/**
 * Representa un usuario niño con un descuento de 500
 * Hereda de la clase Usuario
 * 
 * @autor Vanessa Toro Sepulveda
 */
public class UsuarioNiño extends Usuario{
    /**
     * Constructor de UsuarioNiño
     *
     * @param nombre Nombre del usuario
     * @param id Documento de identidad
     * @param telefono Telefono del usuario
     */
    public UsuarioNiño(String nombre, String id, String telefono) {
        super(nombre, id, telefono);
        this.descuento = 500;
    }
    
    /**
     * Aplica descuento fijo de 500 unidades
     *
     * @param precio Precio base
     * @return Precio con descuento aplicado
     */
    @Override
    public double aplicarDescuento(double precio) {
        return precio - descuento;
    }

}
