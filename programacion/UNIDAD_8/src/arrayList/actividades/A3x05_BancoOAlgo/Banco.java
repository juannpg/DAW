package arrayList.actividades.A3x05_BancoOAlgo;

import arrayList.actividades.A3x05_BancoOAlgo.orden.OrdenDNIAscendente;
import arrayList.actividades.A3x05_BancoOAlgo.orden.OrdenNacimientoAscendente;
import arrayList.actividades.A3x05_BancoOAlgo.orden.OrdenNombreAscendente;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Banco {
    private Set<Cliente> clientes;

    public Banco() {
        this.clientes = new HashSet<>();
    }

    public Banco(TreeSet<Cliente> t) {
        this.clientes = t;
    }

    @Override
    public String toString() {
        String strClientes = "Banco {\n";
        for (Cliente c : this.clientes) {
            strClientes = strClientes.concat("\t" + c.toString() + "\n");
        }
        strClientes = strClientes.concat("}");
        return strClientes;
    }

    public void insertarCliente(Cliente c) {
        this.clientes.add(c);
    }

    public boolean eliminarPorDNI(String dni) {
        return this.clientes.remove(new Cliente(dni));
    }

    public boolean estaDNI(String dni) {
        return this.clientes.contains(new Cliente(dni));
    }

    public Cliente consultarPorDNI(String dni) {
        for (Cliente c : this.clientes) {
            if (estaDNI(dni)) {
                return c;
            }
        }

        return null;
    }

    public boolean estaVacio() {
        return this.clientes.isEmpty();
    }

    public Banco consultarTodosDNIAscendente() {
        TreeSet<Cliente> t = new TreeSet<>(new OrdenDNIAscendente());
        t.addAll(this.clientes);
        return new Banco(t);
    }

    public Banco consultarTodosNombreAscendente() {
        TreeSet<Cliente> t = new TreeSet<>(new OrdenNombreAscendente());
        t.addAll(this.clientes);
        return new Banco(t);
    }

    public Banco consultarTodosNacimientoAscendente() {
        TreeSet<Cliente> t = new TreeSet<>(new OrdenNacimientoAscendente());
        t.addAll(this.clientes);
        return new Banco(t);
    }
}
