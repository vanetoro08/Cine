package cine.models;

// @author vanes
public class Boleta {
    private int id; 
    private Funcion funcionSeleccionada; 
    private Usuario usuario; 
    private double valorBoleta = 0; 
    
    public void calcularValorBoleta(){
        Pelicula pelicula = this.funcionSeleccionada.pelicula;
        this.valorBoleta += this.usuario.aplicarDescuento(this.funcionSeleccionada.aplicarDescuento(pelicula.getCostoBase()));
    }

    public double getValorBoleta() {
        return valorBoleta;
    }
    
}
