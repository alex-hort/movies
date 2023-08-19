import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Catalogo_Pelis {
    private ArrayList<Pelicula> listaNormal;
    private ArrayList<Pelicula> listaDescargas; // Cambiado a Pelicula


    public Catalogo_Pelis() {
        this.listaNormal = new ArrayList<>();
        this.listaDescargas = new ArrayList<>();

    }

    public void agregarPelicula(Pelicula pelicula) {
        listaNormal.add(pelicula);
    }

    public void mostrarListaNormal() {
        if (listaNormal.size() == 0) {
            System.out.println("La lista de películas está vacía.");
        } else {
            System.out.println("Lista de películas:");
            for (Pelicula pelicula : listaNormal) {
                System.out.println(pelicula.toString());
            }
           // System.out.printf("%-8s|%-30s|-30s|%-8s|%-8s|%-30s|-30s\n", "Nombre", "Genero", "Director", "Año", "Duracion", "Clave", "Tamaño");
           // System.out.println("|------------|----------------|----------------|---------------|--------------––|--------------|-------------|");
        }
    }
    public Pelicula buscarPeliculaPorClave(int clave) {
        for (Pelicula pelicula : listaNormal) {
            if (pelicula.getClave() == clave) {
                return pelicula;
            }
        }
        return null;
    }

    public Pelicula buscarPeliculaPorNombre(String nombre) {
        for (Pelicula pelicula : listaNormal) {
            if (pelicula.getNombre().equalsIgnoreCase(nombre)) {
                return pelicula;
            }
        }
        return null;
    }

    public void borrarPelicula(Pelicula pelicula) {
        listaNormal.remove(pelicula);
        listaDescargas.remove(pelicula);
    }

    public void ordenarPorNombre() {
        listaNormal.sort((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
    }



    public void descargarPelicula(Pelicula pelicula) {
        int tamanoDescargas = calcularTamanoDescargas();
        if (tamanoDescargas + pelicula.getTamano() > 1024) {
            System.out.println("No hay espacio para descargar más películas");
            return;
        }
        if (listaDescargas.contains(pelicula)) {
            System.out.println("La película ya se encuentra en la lista de descargas");
            return;
        }
        listaDescargas.add(pelicula);
        System.out.println("Película descargada con éxito");
    }
    public void borrarPeliculaDescargada(Pelicula pelicula) {
        listaDescargas.remove(pelicula);
    }


    public void mostrarListaDescargas() {
        System.out.println("----- Lista de Descargas -----");
        for (Pelicula pelicula : listaDescargas) {
            System.out.println(pelicula);
        }
        System.out.println("------------------------------");
    }

    private int calcularTamanoDescargas() {
        int tamanoDescargas = 0;
        for (Pelicula pelicula : listaDescargas) { // Cambiado a listaDescargas
            tamanoDescargas += pelicula.getTamano();
        }
        return tamanoDescargas;
    }

    public void salir() {
        System.out.println("¡ADIOS!");
        System.exit(0);
    }

    public void pedirDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la película: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la clave de la película: ");
        int clave = scanner.nextInt();
        System.out.print("Ingrese el tamaño de la película en MB: ");
        double tamano = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese el genero de la pelicula: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese el director de la pelicula: ");
        String director = scanner.nextLine();
        System.out.print("Ingrese el año de lanzamiento de la pelicula: ");
        int anio = scanner.nextInt();
        System.out.print("Duración: ");
        double duracion = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el autor de la Pelicula: ");
        String autor= scanner.nextLine();

        Pelicula datos1 = new Pelicula(nombre,clave,tamano,genero,director,anio,duracion,autor);
        listaNormal.add(datos1);
    }
    public void setListaNormal(ArrayList<Pelicula> listaNormal) {
        this.listaNormal = listaNormal;
    }
    public ArrayList<Pelicula>getListaNormal(){
        return listaNormal;
    }
    public void setListaDescargas(ArrayList<Pelicula> listaDescargas) {
        this.listaDescargas = listaDescargas;
    }
    public ArrayList<Pelicula>getListaDescargas(){
        return listaDescargas;
    }
}
