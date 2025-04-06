package cine.main;

// @author vanes

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

public class Main {
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
            System.out.println("8. Generar factura");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opcion: ");
            opci = scanner.nextInt();
            scanner.nextLine();

            switch(opci) {
                case 1:
                    System.out.print("Nombre de la pelicula: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Costo base: ");
                    double costo = scanner.nextDouble();
                    scanner.nextLine();
                    cine.agregarPelicula(new Pelicula(nombre, costo));
                    System.out.println("Pelicula agregada");
                    break;

                case 2:
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
                    if (cine.getPeliculas().size() == 0) {
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
                    cine.mostrarUsuarios();
                    System.out.print("Ingrese el ID del usuario que va a comprar las boletas: ");
                    String idUsuarioComprador = scanner.nextLine();
                    Usuario usuarioComprador = null;

                    for (int i = 0; i < cine.getUsuarios().size(); i++) {
                        Usuario usu = cine.getUsuarios().get(i);
                        if (usu.getId().equals(idUsuarioComprador)) {
                            usuarioComprador = usu;
                            break;
                        }
                    }

                    if (usuarioComprador == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }

                    // 2. Seleccionar función
                    cine.mostrarFunciones();
                    System.out.print("Ingrese el ID de la funcion a la que desea ingresar: ");
                    String idFuncionVer = scanner.nextLine();
                    Funcion funcionSeleccionada = null;

                    for (int i = 0; i < cine.getFunciones().size(); i++) {
                        Funcion func = cine.getFunciones().get(i);
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
                    cine.mostrarPeliculas();
                    break;

                case 6:
                    cine.mostrarUsuarios();
                    break;

                case 7:
                    cine.mostrarFunciones();
                    break;

                case 8:
                    System.out.print("Ingrese el numero de venta: ");
                    int numVenta = scanner.nextInt();
                    scanner.nextLine();
                    cine.generarFactura(numVenta);
                    break;

                case 9:
                    break;

                default:
                    System.out.println("Ingrese otra opcion");
            }

        } while (opci != 9);

        scanner.close();
    }
}
