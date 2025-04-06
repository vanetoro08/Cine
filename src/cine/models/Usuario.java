package cine.models;

// @author vanes
public abstract class Usuario {
    protected int descuento;
    protected String nombre;
    protected String id;
    protected String telefono;

    public Usuario(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }
    
    public abstract double aplicarDescuento(double precio);
    
}
