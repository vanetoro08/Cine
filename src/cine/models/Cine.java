package cine.models;
import java.util.ArrayList;
import java.util.Random;
// @author vanes
public class Cine {
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Funcion> funciones = new ArrayList<Funcion>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    
    public void agregarPelicula(Pelicula peliculaNueva){
        this.peliculas.add(peliculaNueva);
    }
    
    public void actualizarPelicula(Pelicula peliculaActualizada, String nombreBuscar){
        for (int i = 0 ; i<this.peliculas.size(); i++){
            Pelicula pelicula = this.peliculas.get(i);
            if(nombreBuscar.equals(pelicula.getNombre())){
                this.peliculas.set(i, peliculaActualizada);
                return; 
            }
        }
        System.out.println("pelicula no encontrada");
    }
    public void eliminarPelicula( String nombreBuscar){
        for (int i = 0 ; i<this.peliculas.size(); i++){
            Pelicula pelicula = this.peliculas.get(i);
            if(nombreBuscar.equals(pelicula.getNombre())){
                this.peliculas.remove(i);
                return; 
            }
        }
        System.out.println("pelicula no encontrada");
    }
    
    public void agregarUsuario(Usuario usuarioNuevo){
        this.usuarios.add(usuarioNuevo);
    }
    public void actualizarUsuario(Usuario usuarioActualizado, String id){
        for (int i = 0 ; i<this.usuarios.size(); i++){
            Usuario usuario = this.usuarios.get(i);
            if(id.equals(usuario.id)){
                this.usuarios.set(i, usuarioActualizado);
                return; 
            }
        }
        System.out.println("usuario no encontrado");
    }
    public void eliminarUsuario(Usuario usuarioActualizado, String id){
        for (int i = 0 ; i<this.usuarios.size(); i++){
            Usuario usuario = this.usuarios.get(i);
            if(id.equals(usuario.id)){
                this.usuarios.remove(i);
                return; 
            }
        }
        System.out.println("usuario no encontrado");
    }
    
    public void mostrarPeliculas(){
        System.out.println("peliculas:");
        for(int i= 0 ; i<this.peliculas.size() ; i++){
            Pelicula pelicula = this.peliculas.get(i);
            System.out.println( i+1 +") " + pelicula.getNombre());
        }
    }
    public void mostrarUsuarios(){
        System.out.println("usuarios: ");
        for(int i= 0 ; i<this.usuarios.size() ; i++){
            Usuario usuario = this.usuarios.get(i);
            System.out.println( i+1 +") nombre:" + usuario.nombre + " id: " + usuario.id + " telefono: " + usuario.telefono);
        }
    }
    
    public void agregarFuncion(Funcion funcionNueva){
        this.funciones.add(funcionNueva);
    }
    
    public void actualizarFuncion(Funcion funcionNueva, String idBuscar){
        for (int i = 0 ; i<this.funciones.size(); i++){
            Funcion funcion = this.funciones.get(i);
            if(idBuscar.equals(funcion.id)){
                this.funciones.set(i, funcionNueva);
                return; 
            }
        }
        System.out.println("funcion no encontrada");
    }
    public void eliminarFuncion( String idBuscar){
        for (int i = 0 ; i<this.funciones.size(); i++){
            Funcion funcion = this.funciones.get(i);
            if(idBuscar.equals(funcion.id)){
                this.funciones.remove(i);
                return; 
            }
        }
        System.out.println("funcion no encontrada");
    }
    
    public void mostrarFunciones(){
        for (int i=0; i<this.funciones.size(); i++){
            Funcion funcion = this.funciones.get(i);
            Pelicula pelicula = funcion.getPelicula();
            System.out.println("");
        }
    }
    
    public void venderBoletas(ArrayList<Usuario> usuarios , Funcion funcion){
        Venta venta= new Venta();
        for(int i = 0 ; i<usuarios.size(); i++ ){
            Usuario usuario = usuarios.get(i);
            Random aleatorio = new Random(System.currentTimeMillis());
            int idAleatorio = aleatorio.nextInt(10000);
            for(int j= 0; j<venta.getBoletas().size(); j++){
                Boleta boleta = venta.getBoletas().get(i);
                if(idAleatorio==boleta.getId()){
                    aleatorio.setSeed(System.currentTimeMillis());
                    idAleatorio = aleatorio.nextInt(10000);
                }
            }
            Boleta boletaNueva = new Boleta( idAleatorio, funcion , usuario);
            venta.agregarBoleta(boletaNueva);
        }
        Factura facturaNueva = new Factura(venta);
        System.out.println("venta #"+ venta.getNumVenta());
        this.facturas.add(facturaNueva);  
    }
    public void generarFactura(int numVenta){
        for(int i=0; i< facturas.size(); i++){
            Factura factura = facturas.get(i);
            Venta venta = factura.getVenta();
            if(numVenta == venta.getNumVenta()){
                factura.mostrarDetalles();
                return; 
            }
        }
    }
}
