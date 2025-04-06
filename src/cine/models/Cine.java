package cine.models;
import java.util.ArrayList;
import java.util.Random;
/**
 * Representa el sistema de un cine, donde se gestionan películas, funciones,
 * usuarios, ventas y facturas
 * 
 * @author Nicolas Agudelo Grajales
 */
public class Cine {
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Funcion> funciones = new ArrayList<Funcion>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
 
    /**
     * Agrega una nueva pelicula al sistema
     * @param peliculaNueva Pelicula a agregar
     */    
    public void agregarPelicula(Pelicula peliculaNueva){
        this.peliculas.add(peliculaNueva);
    }
  
    /**
     * Actualiza una pelicula existente en el sistema
     * @param peliculaActualizada Nueva informacion de la pelicula
     * @param nombreBuscar Nombre de la pelicula a actualizar
     */    
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
    
    /**
     * Elimina una pelicula del sistema por nombre
     * @param nombreBuscar Nombre de la pelicula a eliminar
     */    
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

    /**
     * Agrega un nuevo usuario al sistema
     * @param usuarioNuevo Usuario a agregar
     */    
    public void agregarUsuario(Usuario usuarioNuevo){
        this.usuarios.add(usuarioNuevo);
    }

    /**
     * Actualiza los datos de un usuario existente
     * @param usuarioActualizado Usuario con datos actualizados
     * @param id Id del usuario a actualizar
     */    
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
    
    /**
     * Elimina un usuario del sistema por su id
     * @param usuarioActualizado Objeto usuario
     * @param id ID del usuario a eliminar
     */    
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
    
    /**
     * Muestra todas las peliculas registradas en el sistema
     */    
    public void mostrarPeliculas(){
        System.out.println("peliculas:");
        for(int i= 0 ; i<this.peliculas.size() ; i++){
            Pelicula pelicula = this.peliculas.get(i);
            System.out.println( i+1 +") " + pelicula.getNombre());
        }
    }
    
    /**
     * Muestra todos los usuarios registrados.
     */    
    public void mostrarUsuarios(){
        System.out.println("usuarios: ");
        for(int i= 0 ; i<this.usuarios.size() ; i++){
            Usuario usuario = this.usuarios.get(i);
            System.out.println( (i+1) +" nombre:" + usuario.nombre + " id: " + usuario.id + " telefono: " + usuario.telefono);
        }
    }
    
    /**
     * Agrega una función al sistema.
     * @param funcionNueva Función a agregar.
     */
    public void agregarFuncion(Funcion funcionNueva){
        this.funciones.add(funcionNueva);
    }

    /**
     * Actualiza una función existente por ID.
     * @param funcionNueva Nueva información de la función.
     * @param idBuscar ID de la función a actualizar.
     */    
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
    
    /**
     * Elimina una función del sistema por ID.
     * @param idBuscar ID de la función a eliminar.
     */    
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

    /**
     * Muestra todas las funciones disponibles.
     */    
    public void mostrarFunciones(){
        for (int i=0; i<this.funciones.size(); i++){
            Funcion funcion = this.funciones.get(i);
            Pelicula pelicula = funcion.getPelicula();
            System.out.println("Funcion #" + (i + 1));
            System.out.println("id: " + funcion.id);
            System.out.println("Pelicula: " + pelicula.getNombre());
            System.out.println("Costo base: $" + pelicula.getCostoBase());       
            System.out.println("");
        }
    }
    
    /**
     * Realiza la venta de boletas para una funcion a una lista de usuarios
     * 
     * @param usuarios Lista de usuarios que compraran boletas
     * @param funcion Funcion para la que se realiza la venta
     */    
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
            boletaNueva.calcularValorBoleta();
            venta.agregarBoleta(boletaNueva);
        }
        Factura facturaNueva = new Factura(venta);
        System.out.println("venta #"+ venta.getNumVenta());
        this.facturas.add(facturaNueva);  
    }

    /**
     * Genera y muestra la factura correspondiente a una venta
     * @param numVenta Numero de venta
     */    
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

    /**
     * Devuelve la lista de peliculas
     * @return Lista de peliculas
     */
    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * Devuelve la lista de funciones
     * @return Lista de funciones
     */    
    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }

    /**
     * Devuelve la lista de usuarios
     * @return Lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    /**
     * Devuelve la lista de facturas generadas
     * @return Lista de facturas
     */
    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
    
}
