package cine.models;
import java.util.ArrayList;
// @author vanes
public class Cine {
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Funcion> funciones = new ArrayList<Funcion>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    
    public void agregarPelicula(Pelicula peliculaNueva){
        this.peliculas.add(peliculaNueva);
    }
    
    public void actualizarPelicula(Pelicula peliculaNueva, String nombreBuscar){
        for (int i = 0 ; i<this.peliculas.size(); i++){
            Pelicula pelicula = this.peliculas.get(i);
            if(nombreBuscar.equals(pelicula.getNombre())){
                this.peliculas.set(i, peliculaNueva);
                return; 
            }
        }
        //si no se encuentra, entonces excepcion...
    }
    public void eliminarPelicula( String nombreBuscar){
        for (int i = 0 ; i<this.peliculas.size(); i++){
            Pelicula pelicula = this.peliculas.get(i);
            if(nombreBuscar.equals(pelicula.getNombre())){
                this.peliculas.remove(i);
                return; 
            }
        }
        //si no se encuentra, entonces excepcion...
    }
    
    
    
    
}
