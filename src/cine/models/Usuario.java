package cine.models;

/**
 * Clase abstracta que representa un usuario del sistema de cine
 * 
 * @author Vanessa Toro Sepulveda
 */
public abstract class Usuario {
    protected int descuento;
    protected String nombre;
    protected String id;
    protected String telefono;
    /**
     * Constructor de Usuario
     *
     * @param nombre Nombre del usuario
     * @param id Documento de identidad del usuario
     * @param telefono Número de contacto del usuario
     */
    
    public Usuario(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }
    
    /**
     * Aplica el descuento correspondiente al tipo de usuario
     *
     * @param precio Precio base antes de descuento
     * @return Precio con descuento aplicado
     */    
    public abstract double aplicarDescuento(double precio);

    public String getId() {
        return id;
    }
        
    
}
