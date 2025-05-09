package dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import modelo.Trabajador;
import dao.AccesoTrabajadores;
import orden.*;

public class VerDialog extends JDialog implements ActionListener, ItemListener {

    JLabel etiquetaDni;
    JTextField areaDni;
    JLabel etiquetaNombre;
    JTextField areaNombre;
    JLabel etiquetaApellidos;
    JTextField areaApellidos;
    JLabel etiquetaDireccion;
    JTextField areaDireccion;
    JLabel etiquetaTelefono;
    JTextField areaTelefono;
    JLabel etiquetaPuesto;
    JComboBox comboPuesto;

    String dni = "";
    String nombre = "";
    String apellidos = "";
    String direccion = "";
    String telefono = "";
    String puesto = "";

    JPanel contenedorInputs;
    JPanel pDni;
    JPanel pNombre;
    JPanel pApellidos;
    JPanel pDireccion;
    JPanel pTelefono;
    JPanel pPuesto;
    JPanel pBotones;
    JTable tabla;

    JButton aceptar;
    JButton cancelar;
    JPanel pTitulo;
    JLabel etiquetaTitulo;

    String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono", "Puesto" };
    ArrayList<Trabajador> lista = AccesoTrabajadores.obtenerTrabajadores();
    String[][] datos = AccesoTrabajadores.listarTrabajadores(lista);

    @Override
    public void itemStateChanged(ItemEvent e) {
        puesto = comboPuesto.getSelectedItem().toString();
    }

    public VerDialog() {
        setResizable(false);
        setTitle("Buscar Trabajador");
        setSize(750, 900);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        contenedorInputs = new JPanel();
        contenedorInputs.setLayout(new BoxLayout(contenedorInputs, BoxLayout.Y_AXIS));

        pTitulo = new JPanel();
        etiquetaTitulo = new JLabel("Introduce los datos por los que deseas filtrar");
        pTitulo.add(etiquetaTitulo);
        contenedorInputs.add(pTitulo);

        pDni = new JPanel();
        pNombre = new JPanel();
        pApellidos = new JPanel();
        pDireccion = new JPanel();
        pTelefono = new JPanel();
        pPuesto = new JPanel();
        pBotones = new JPanel();

        etiquetaDni = new JLabel("DNI                 ");
        areaDni = new JTextField(15);
        pDni.add(etiquetaDni);
        pDni.add(areaDni);

        etiquetaNombre = new JLabel("Nombre         ");
        areaNombre = new JTextField(15);
        pNombre.add(etiquetaNombre);
        pNombre.add(areaNombre);

        etiquetaApellidos = new JLabel("Apellidos      ");
        areaApellidos = new JTextField(15);
        pApellidos.add(etiquetaApellidos);
        pApellidos.add(areaApellidos);

        etiquetaDireccion = new JLabel("Direccion      ");
        areaDireccion = new JTextField(15);
        pDireccion.add(etiquetaDireccion);
        pDireccion.add(areaDireccion);

        etiquetaTelefono = new JLabel("Telefono       ");
        areaTelefono = new JTextField(15);
        pTelefono.add(etiquetaTelefono);
        pTelefono.add(areaTelefono);

        etiquetaPuesto = new JLabel("Puesto                         ");
        pPuesto.add(etiquetaPuesto);
        comboPuesto = new JComboBox();
        ArrayList<String> puestos = AccesoTrabajadores.obtenerPuestos();
        comboPuesto.addItem("Seleccione");
        for (String p : puestos) {
            comboPuesto.addItem(p);
        }
        comboPuesto.addItemListener(this);
        pPuesto.add(comboPuesto);


        contenedorInputs.add(pDni);
        contenedorInputs.add(pNombre);
        contenedorInputs.add(pApellidos);
        contenedorInputs.add(pDireccion);
        contenedorInputs.add(pTelefono);
        contenedorInputs.add(pPuesto);

        pBotones = new JPanel();
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        pBotones.add(aceptar);

        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(this);
        pBotones.add(cancelar);

        contenedorInputs.add(pBotones);
        add(contenedorInputs);

        this.lista = new ArrayList<>();
        this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
        tabla = new JTable(this.datos, this.columnas);
        tabla.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = tabla.columnAtPoint(evt.getPoint());
                String nombreColumna = tabla.getColumnName(col).toLowerCase();
                ordenarLista(nombreColumna);
            }
        });
        JScrollPane jsp = new JScrollPane(tabla);
        jsp.setPreferredSize(new Dimension(700, 600));
        add(jsp);

        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            dni = areaDni.getText();
            nombre = areaNombre.getText();
            apellidos = areaApellidos.getText();
            direccion = areaDireccion.getText();
            telefono = areaTelefono.getText();
            Trabajador tBuscar = new Trabajador(dni, nombre, apellidos, direccion, telefono, puesto);
            this.lista = AccesoTrabajadores.buscarTrabajadaroesPorVariosCampos(tBuscar);

            if (!this.lista.isEmpty()) {
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
            } else {
                JOptionPane.showMessageDialog(null, "No se han encontrado trabajadores con esos datos", "Error", JOptionPane.ERROR_MESSAGE);
                this.datos = null;
                recargarLista();
            }
        } else if (e.getSource() == cancelar) {
            dispose();
        }

    }

    public void recargarLista() {
        tabla.setModel(new javax.swing.table.DefaultTableModel(this.datos, this.columnas));
    }

    public void ordenarLista(String columna) {
        lista = AccesoTrabajadores.obtenerTrabajadores();
        switch (columna) {
            case "identificador":
                this.columnas = new String[] {
                        "Identificador ▼", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto"
                };
                this.lista.sort(new TrabajadoresPorOid());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
            case "dni":
                this.columnas = new String[] {
                        "Identificador", "DNI ▼", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto"
                };
                this.lista.sort(new TrabajadoresPorDni());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
            case "nombre":
                this.columnas = new String[] {
                        "Identificador", "DNI", "Nombre ▼", "Apellidos", "Direccion", "Telefono", "Puesto"
                };
                this.lista.sort(new TrabajadoresPorNombre());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
            case "apellidos":
                this.columnas = new String[] {
                        "Identificador", "DNI", "Nombre", "Apellidos ▼", "Direccion", "Telefono", "Puesto"
                };
                this.lista.sort(new TrabajadoresPorApellidos());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
            case "direccion":
                this.columnas = new String[] {
                        "Identificador", "DNI", "Nombre", "Apellidos", "Direccion ▼", "Telefono", "Puesto"
                };
                this.lista.sort(new TrabajadoresPorDireccion());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
            case "telefono":
                this.columnas = new String[] {
                        "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono ▼", "Puesto"
                };
                this.lista.sort(new TrabajadoresPorTelefono());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
            case "puesto":
                this.columnas = new String[] {
                        "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto ▼"
                };
                this.lista.sort(new TrabajadoresPorPuesto());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista();
                break;
        }
    }
}
