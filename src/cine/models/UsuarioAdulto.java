package cine.models;

/**
 * Representa un usuario adulto que no tiene descuento
 * Hereda de la clase Usuario
 * 
 * @author Vanessa Toro Sepulveda
 */
public class UsuarioAdulto extends Usuario{
    /**
     * Constructor de UsuarioAdulto
     *
     * @param nombre Nombre del usuario
     * @param id Documento de identidad
     * @param telefono Telefono del usuario
     */
    public UsuarioAdulto(String nombre, String id, String telefono) {
        super(nombre, id, telefono);
        this.descuento = 0;
    }
    
    /**
     * No se aplica descuento para adultos
     *
     * @param precio Precio base
     * @return Precio sin descuento
     */
    @Override
    public double aplicarDescuento(double precio) {
        return precio;
    }

}
