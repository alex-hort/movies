import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Archivo {
    private String nombreArchivo;
    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public void crearArchivo() {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try (PrintWriter salidaArchivo = new PrintWriter(nombreArchivo)) {
                System.out.println("El archivo " + nombreArchivo + " se ha creado.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void escribirArchivo(ArrayList<Pelicula> listaNormal) {
        try (PrintWriter salidaArchivo = new PrintWriter(nombreArchivo)) {
            for (Pelicula peliculaX : listaNormal) {
                salidaArchivo.println(peliculaX.formatoArchivo());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Pelicula> leerDeArchivo() {
        ArrayList<Pelicula> listaNormal = new ArrayList<>();
        try (Scanner leerArchivo = new Scanner(new File(nombreArchivo))) {
            while (leerArchivo.hasNext()) {
                String linea = leerArchivo.nextLine();
                String[] valores = linea.split("\\|");
                String nombre = valores[0];
                String genero = valores[1];
                String director = valores[2];
                String titulo = valores[3];
                int anio = Integer.parseInt(valores[4]);
                double duracion = Double.parseDouble(valores[5]);
                int clave = Integer.parseInt(valores[6]);
                double tamano = Double.parseDouble(valores[7]);
                Pelicula peliculaX = new Pelicula(nombre, clave, tamano, genero, director, anio, duracion, titulo);
                listaNormal.add(peliculaX);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaNormal;
    }
}