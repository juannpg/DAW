package herencia.actividades.A2X02_Bebidas;

public abstract class Bebida {
    private static int total;
    protected int codigo;
    protected String nombre;

    public Bebida(String nombre) {
        total++;
        this.codigo = Bebida.total;
        this.nombre = nombre;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Bebida{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio='" + String.format("%.2f", this.calcularPrecio()) + '\'' +
                '}';
    }
}
