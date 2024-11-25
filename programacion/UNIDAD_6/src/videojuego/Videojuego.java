package videojuego;

public class Videojuego {
    private static int total;

    private int codigo;
    private String titulo;
    private float precio;
    private int stock;

    public Videojuego(String titulo, float precio) {
        total++;

        this.titulo = titulo;
        this.precio = precio;
        this.stock = 10;
        this.codigo = total;
    }

    public String toString() {
        return "Videojuego{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", precio=%.2f" + precio +
                ", stock=" + stock +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
