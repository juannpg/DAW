package colecciones.actividades.RepasoExamen;

public class Producto {
    private int codProducto;
    private String nombre;
    private double precio;

    public Producto(int codProducto, String nombre, double precio) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codProducto=" + codProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
