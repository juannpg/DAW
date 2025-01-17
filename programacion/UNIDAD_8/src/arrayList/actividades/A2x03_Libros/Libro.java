package arrayList.actividades.A2x03_Libros;

public class Libro {
    private int isbn;
    private String titulo;
    private String escritor;
    private int agnoPublicacion;
    private int stock;
    private double euros;

    public Libro(int isbn, String titulo, String escritor, int agnoPublicacion, int stock, double euros) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.escritor = escritor;
        this.agnoPublicacion = agnoPublicacion;
        this.stock = stock;
        this.euros = euros;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", escritor='" + escritor + '\'' +
                ", agnoPublicacion=" + agnoPublicacion +
                ", stock=" + stock +
                ", euros=" + euros +
                '}';
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public int getAgnoPublicacion() {
        return agnoPublicacion;
    }

    public void setAgnoPublicacion(int agnoPublicacion) {
        this.agnoPublicacion = agnoPublicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getEuros() {
        return euros;
    }

    public void setEuros(double euros) {
        this.euros = euros;
    }
}
