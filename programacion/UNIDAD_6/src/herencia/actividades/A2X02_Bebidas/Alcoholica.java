package herencia.actividades.A2X02_Bebidas;

public abstract class Alcoholica extends Bebida {
    protected double graduacion;

    public Alcoholica(String nombre, double graduacion) {
        super(nombre);
        this.graduacion = graduacion;
    }
}
