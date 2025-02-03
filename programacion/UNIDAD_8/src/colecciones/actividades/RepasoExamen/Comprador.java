package colecciones.actividades.RepasoExamen;

import java.util.LinkedHashSet;
import java.util.Set;

public class Comprador extends Usuario {
    private String tarjetaPago;
    private String direccionEnvio;
    private Set<Producto> productosFavs;

    public Comprador(String correo, String nombre, String apellido1, String apellido2, String contraseña, String tarjetaPago, String direccionEnvio) {
        super(correo, nombre, apellido1, apellido2, contraseña);
        this.tarjetaPago = tarjetaPago;
        this.direccionEnvio = direccionEnvio;
        this.productosFavs = new LinkedHashSet<>();
    }

    @Override
    public String toString() {
        return "Comprador{\n" +
                "\ttarjetaPago='" + tarjetaPago + '\'' + "\n" +
                "\tdireccionEnvio='" + direccionEnvio + '\'' + "\n" +
                "\tproductosFavs=" + productosFavs + "\n" +
                super.toString();
    }

    public String getTarjetaPago() {
        return tarjetaPago;
    }

    public void setTarjetaPago(String tarjetaPago) {
        this.tarjetaPago = tarjetaPago;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Set<Producto> getProductosFavs() {
        return productosFavs;
    }

    public void setProductosFavs(Set<Producto> productosFavs) {
        this.productosFavs = productosFavs;
    }
}
