package clases;

import orden.SocioCuotaDni;

import java.util.*;

public class ClubDeportivo {
    private String nombre;
    private TreeMap<String, Socio> mapaSocios;

    public ClubDeportivo(String nombre) {
        this.nombre = nombre;
        this.mapaSocios = new TreeMap<>();
    }

    @Override
    public String toString() {
        return "ClubDeportivo{" + "\n" +
                "\tnombre='" + nombre + '\'' + "\n" +
                "\tmapaSocios={\n\t\t" + mapaSocios + "\n" +
                "\t}\n}";
    }

    public boolean estaVacion() {
        return this.mapaSocios.isEmpty();
    }

    public void insertarSocio(Socio s) {
        this.mapaSocios.putIfAbsent(s.getDni(), s);
    }

    public boolean estaSocio(String dni) {
        return this.mapaSocios.containsKey(dni);
    }

    public LinkedList<Socio> obtenerSociosMaxCuotas() {
        TreeSet<Socio> setSocios = new TreeSet<>(new SocioCuotaDni());
        setSocios.addAll(this.mapaSocios.values());

        double cuotaMax = setSocios.getFirst().calcularCuotaMensual();
        LinkedList<Socio> linked = new LinkedList<>();
        for (Socio s : setSocios) {
            if (s.calcularCuotaMensual() == cuotaMax) {
                linked.add(s);
            } else break;
        }

        return linked;
    }
}
