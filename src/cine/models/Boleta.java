package cine.models;

// @author vanes
public class Boleta {
    private int id; 
    private Funcion funcionSeleccionada; 
    private Usuario usuario; 
    private double valorBoleta = 0;

    public Boleta(int id, Funcion funcionSeleccionada, Usuario usuario) {
        this.id = id;
        this.funcionSeleccionada = funcionSeleccionada;
        this.usuario = usuario;
    }
        
    
    public double calcularValorBoleta(){
        
    }

    public int getId() {
        return id;
    }
       
    
}
