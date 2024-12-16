package herencia.actividades.A2X02_Bebidas;

public abstract class Bebida implements Comparable<Bebida> {
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

    public int compareTo(Bebida b) {
        return this.nombre.compareTo(b.nombre);
    }
}
