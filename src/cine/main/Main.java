package cine.main;

import cine.models.Cine;
import cine.models.Funcion;
import cine.models.FuncionNoche;
import cine.models.FuncionTarde;
import cine.models.Pelicula;
import cine.models.PrimeraFuncion;
import cine.models.Usuario;
import cine.models.UsuarioAdulto;
import cine.models.UsuarioMayor;
import cine.models.UsuarioNiño;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase principal del programa del cine.
 * Permite gestionar películas, funciones, usuarios, venta de boletas y facturacion
 * a traves de un menu
 * 
 * @author Vanessa Toro Sepulveda
 */

public class Main {

    /**
     * Método principal que ejecuta el menu del sistema de cine para realizar operaciones sobre
     * películas, funciones, usuarios y ventas.
     *
     */
    public static void main(String[] args) {
        Cine cine = new Cine();
        Scanner scanner = new Scanner(System.in);
        int opci = 0;

        do {
            System.out.println("1. Agregar pelicula");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Agregar funcion");
            System.out.println("4. Vender boletas");
            System.out.println("5. Mostrar peliculas");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Mostrar funciones");
            System.out.println("8. Eliminar pelicula");
            System.out.println("9. Eliminar usuario");
            System.out.println("10. Eliminar funcion");
            System.out.println("11. Generar factura");
            System.out.println("12. Salir");
            System.out.print("Ingrese una opcion: ");
            opci = scanner.nextInt();
            scanner.nextLine();

            switch(opci) {
                case 1:
                    /**
                     * Agrega una nueva pelicula solicitando nombre y costo base
                     */
                    System.out.print("Nombre de la pelicula: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Costo base: ");
                    double costo = scanner.nextDouble();
                    scanner.nextLine();
                    cine.agregarPelicula(new Pelicula(nombre, costo));
                    System.out.println("Pelicula agregada");
                    break;

                case 2:
                    /**
                     * Agrega un nuevo usuario solicitando sus datos personales y tipo (niño, adulto o mayor)
                     */
                    System.out.print("Nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Id: ");
                    String id = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.println("Tipo de usuario:" 
                            + "\n 1. Niño"
                            + "\n 2. Adulto"
                            + "\n 3. Mayor");

                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Usuario usuario;
                    if (tipo == 1) {
                        usuario = new UsuarioNiño(nombreUsuario, id, telefono);
                    } else if (tipo == 2) {
                        usuario = new UsuarioAdulto(nombreUsuario, id, telefono);
                    } else {
                        usuario = new UsuarioMayor(nombreUsuario, id, telefono);
                    }
                    cine.agregarUsuario(usuario);
                    System.out.println("Usuario agregado");
                    break;

                case 3:
                    /**
                     * Agrega una nueva funcion (Primera, Tarde o Noche) para una pelicula existente
                     */
                    if (cine.getPeliculas().isEmpty()) {
                        System.out.println("No hay peliculas");
                        break;
                    }

                    cine.mostrarPeliculas();
                    System.out.print("Ingrese el numero de la pelicula: ");
                    int numPel = scanner.nextInt() - 1;
                    scanner.nextLine();

                    Pelicula peliElegida = cine.getPeliculas().get(numPel);

                    System.out.print("Id de funcion: ");
                    String idFuncion = scanner.nextLine();

                    System.out.println("Tipo de funcion: "
                            + "\n 1. Primera"
                            + "\n 2. Tarde"
                            + "\n 3. Noche");

                    int tipoFuncion = scanner.nextInt();
                    scanner.nextLine();

                    Funcion funcion = null;
                    Date fecha = new Date();

                    switch (tipoFuncion) {
                        case 1:
                            funcion = new PrimeraFuncion(fecha, peliElegida, idFuncion);
                            break;
                        case 2:
                            funcion = new FuncionTarde(fecha, peliElegida, idFuncion);
                            break;
                        case 3:
                            funcion = new FuncionNoche(fecha, peliElegida, idFuncion);
                            break;
                    }

                    cine.agregarFuncion(funcion);
                    System.out.println("Funcion agregada");
                    break;

                case 4:
                    /**
                     * Vende boletas a un usuario para una funcion especifica
                     */
                    cine.mostrarUsuarios();
                    System.out.print("Ingrese el ID del usuario que va a comprar las boletas: ");
                    String idUsuarioComprador = scanner.nextLine();
                    Usuario usuarioComprador = null;

                    for (Usuario usu : cine.getUsuarios()) {
                        if (usu.getId().equals(idUsuarioComprador)) {
                            usuarioComprador = usu;
                            break;
                        }
                    }

                    if (usuarioComprador == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }

                    cine.mostrarFunciones();
                    System.out.print("Ingrese el ID de la funcion a la que desea ingresar: ");
                    String idFuncionVer = scanner.nextLine();
                    Funcion funcionSeleccionada = null;

                    for (Funcion func : cine.getFunciones()) {
                        if (func.getId().equals(idFuncionVer)) {
                            funcionSeleccionada = func;
                            break;
                        }
                    }

                    if (funcionSeleccionada == null) {
                        System.out.println("Funcion no encontrada");
                        break;
                    }

                    System.out.print("Cuantas boletas son para la funcion?: ");
                    int cantidadBoletas = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<Usuario> usuariosVenta = new ArrayList<>();
                    for (int i = 0; i < cantidadBoletas; i++) {
                        usuariosVenta.add(usuarioComprador);
                    }

                    cine.venderBoletas(usuariosVenta, funcionSeleccionada);
                    System.out.println("Boletas vendidas");
                    break;

                case 5:
                    /** Muestra todas las peliculas disponibles */
                    cine.mostrarPeliculas();
                    break;

                case 6:
                    /** Muestra todos los usuarios registrados */
                    cine.mostrarUsuarios();
                    break;

                case 7:
                    /** Muestra todas las funciones creadas */
                    cine.mostrarFunciones();
                    break;

                case 8:
                    /** Elimina una pelicula por nombre */
                    cine.mostrarPeliculas();
                    System.out.print("Ingrese el nombre de la pelicula a eliminar: ");
                    String nombrePeliEliminar = scanner.nextLine();
                    cine.eliminarPelicula(nombrePeliEliminar);
                    System.out.println("Pelicula eliminada");
                    break;

                case 9:
                    /** Elimina un usuario por id */
                    cine.mostrarUsuarios();
                    System.out.print("Ingrese el id del usuario a eliminar: ");
                    String idUsuarioEliminar = scanner.nextLine();
                    cine.eliminarUsuario(null, idUsuarioEliminar);
                    System.out.println("Usuario eliminado");
                    break;

                case 10:
                    /** Elimina una función por id */
                    cine.mostrarFunciones();
                    System.out.print("Ingrese el id de la función a eliminar: ");
                    String idFuncionEliminar = scanner.nextLine();
                    cine.eliminarFuncion(idFuncionEliminar);
                    System.out.println("Funcion eliminada");
                    break;

                case 11:
                    /** Genera la factura para una venta especifica */
                    System.out.print("Ingrese el numero de venta: ");
                    int numVenta = scanner.nextInt();
                    scanner.nextLine();
                    cine.generarFactura(numVenta);
                    break;

                default:
                    System.out.println("Ingrese otra opcion");
            }

        } while (opci != 12);

        scanner.close();
    }
}

