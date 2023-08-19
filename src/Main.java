import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Catalogo_Pelis catalogoP1 = new Catalogo_Pelis();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Archivo archivoLN = new Archivo("Lista Original");
        archivoLN.crearArchivo();
        catalogoP1.setListaNormal(archivoLN.leerDeArchivo());

        Archivo archivoLD= new Archivo("Lista Descargas");
        archivoLD.crearArchivo();
        catalogoP1.setListaDescargas(archivoLD.leerDeArchivo());


        int opcion = 0;

        do {
            System.out.println("\n\nMENU PRINCIPAL   ):");
            System.out.println("1. Agregar película");
            System.out.println("2. Mostrar lista de películas");
            System.out.println("3. Buscar película por clave");
            System.out.println("4. Buscar película por nombre");
            System.out.println("5. Borrar lista película");
            System.out.println("6. Ordenar películas por nombre");
            System.out.println("7. Descargar película");
            System.out.println("8. Mostrar lista de descargas");
            System.out.println("9. Borrar película descargada");
            System.out.println("10. SALIR");
            System.out.print("\nIngrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    catalogoP1.pedirDatos();
                    archivoLN.escribirArchivo(catalogoP1.getListaNormal());

                    break;
                case 2:
                    catalogoP1.mostrarListaNormal();
                    break;
                case 3:
                    System.out.print("Ingrese la clave de la película: ");
                    int clave = scanner.nextInt();
                    Pelicula peliculaPorClave = catalogoP1.buscarPeliculaPorClave(clave);
                    if (peliculaPorClave == null) {
                        System.out.println("No se encontró la película con esa clave.");
                    } else {
                        System.out.println(peliculaPorClave.toString());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la película: ");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();

                    // Reemplaza scanner.next() con scanner.nextLine().
                    Pelicula peliculaPorNombre = catalogoP1.buscarPeliculaPorNombre(nombre);
                    if (peliculaPorNombre == null) {
                        System.out.println("No se encontró la película con ese nombre.");
                    } else {
                        System.out.println(peliculaPorNombre.toString());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la clave de la película a borrar: ");
                    int claveBorrar = scanner.nextInt();
                    Pelicula peliculaBorrar = catalogoP1.buscarPeliculaPorClave(claveBorrar);
                    if (peliculaBorrar == null) {
                        System.out.println("No se encontró la película con esa clave.");
                    } else {
                        catalogoP1.borrarPelicula(peliculaBorrar);
                        archivoLN.escribirArchivo(catalogoP1.getListaNormal());
                        System.out.println("Película borrada con éxito.");
                    }
                    break;
                case 6:
                   catalogoP1.ordenarPorNombre();
                    archivoLN.escribirArchivo(catalogoP1.getListaNormal());
                    System.out.println("La lista de películas ha sido ordenada por nombre.");
                    break;
                case 7:
                    System.out.print("Ingrese la clave de la película a descargar: ");
                    int claveDescargar = scanner.nextInt();
                    Pelicula peliculaDescargar = catalogoP1.buscarPeliculaPorClave(claveDescargar);
                    if (peliculaDescargar == null) {
                        System.out.println("No se encontró la película con esa clave.");
                    } else {
                        catalogoP1.descargarPelicula(peliculaDescargar);
                    }

                    break;
                case 8:
                    catalogoP1.mostrarListaDescargas();
                    archivoLD.escribirArchivo(catalogoP1.getListaDescargas());
                    break;

                case 9:
                    System.out.print("Ingrese la clave de la película descargada a borrar: ");
                    int claveBorrarDescargada = scanner.nextInt();
                    Pelicula peliculaBorrarDescargada = catalogoP1.buscarPeliculaPorClave(claveBorrarDescargada);
                    if (peliculaBorrarDescargada == null) {
                        System.out.println("No se encontró la película con esa clave.");
                    } else {
                        catalogoP1.borrarPeliculaDescargada(peliculaBorrarDescargada);
                        archivoLD.escribirArchivo(catalogoP1.getListaDescargas());
                        System.out.println("Película descargada borrada con éxito.");
                    }
                    break;
                case 10:
                    catalogoP1.salir();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        }while (opcion!=10);
    }
}
