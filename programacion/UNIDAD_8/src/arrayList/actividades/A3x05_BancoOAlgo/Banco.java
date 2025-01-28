package arrayList.actividades.A3x05_BancoOAlgo;

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

    public boolean insertarCliente(Cliente c) {
        return this.clientes.add(c);
    }

    public boolean eliminarPorDNI(String dni) {
        return this.clientes.remove(new Cliente(dni));
    }

    private boolean estaDNI(String dni) {
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

    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente c1 = new Cliente("723456789A", "Juan Perez", new Fecha(1, 1, 2005), "juanperez@gmail.com", "Calle 1, 123", 1000.00);
        Cliente c2 = new Cliente("223456789B", "Juan Perez", new Fecha(2, 1, 2000), "juanperez@gmail.com", "Calle 1, 123", 1000.00);
        Cliente c3 = new Cliente("323456789C", "Angel Perez", new Fecha(1, 1, 2005), "juanperez@gmail.com", "Calle 1, 123", 1000.00);

        banco.insertarCliente(c1);
        banco.insertarCliente(c2);
        banco.insertarCliente(c3);

        System.out.println(banco);
        System.out.println(banco.consultarTodosDNIAscendente());
        System.out.println(banco.consultarTodosNombreAscendente());
        System.out.println(banco.consultarTodosNacimientoAscendente());
    }

}
