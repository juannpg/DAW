package clases;

import java.util.HashMap;

public class ClubDeportivo {
    private String nombre;
    private HashMap<String, Socio> mapaSocios;

    public ClubDeportivo(String nombre) {
        this.nombre = nombre;
        this.mapaSocios = new HashMap<>();
    }

    @Override
    public String toString() {
        return "clases.ClubDeportivo{" + "\n" +
                "\tnombre='" + nombre + '\'' + "\n" +
                "\tmapaSocios=" + mapaSocios + "\n" +
                '}';
    }

    public void insertarSocio(Socio s) {
        this.mapaSocios.putIfAbsent(s.getDni(), s);
    }

    public boolean estaSocio(String dni) {
        return this.mapaSocios.containsKey(dni);
    }
}
