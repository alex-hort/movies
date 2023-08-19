public class Pelicula {

        private String autor;
        private String genero;
        private String director;
        private int anio;
        private double duracion;
        private int clave;
        private String nombre;
        private double tamano;

        // Constructor

        public Pelicula(String nombre, int clave, double tamano, String genero, String director, int anio, double duracion, String autor) {
            this.nombre = nombre;
            this.clave = clave;
            this.tamano = tamano;
            this.genero = genero;
            this.director = director;
            this.anio = anio;
            this.duracion = duracion;
            this.autor = autor;
        }

        // Métodos getters y setters

        public double getTamano() {
            return tamano;
        }

        public void setTamano(double tamano) {
            this.tamano = tamano;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getClave() {
            return clave;
        }

        public void setClave(int clave) {
            this.clave = clave;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public double getDuracion() {
            return duracion;
        }

        public void setDuracion(double duracion) {
            this.duracion = duracion;
        }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
        public String toString() {
            return "Pelicula" +
                    "autor='" + autor + '\'' +
                    ", genero='" + genero + '\'' +
                    ", director='" + director + '\'' +
                    ", anio=" + anio +
                    ", duracion=" + duracion +
                    ", clave=" + clave +
                    ", nombre='" + nombre + '\'' +
                    ", tamano=" + tamano
                    ;
        }
    public String formatoArchivo() {
        return nombre + "|" + genero + "|" + director + "|" + autor + "|" + anio + "|" + duracion + "|" + clave + "|" + tamano;
    }

}
