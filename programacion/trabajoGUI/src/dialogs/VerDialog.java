/**
 *
 */
package dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import modelo.Empresa;
import modelo.Trabajador;
import dao.AccesoTrabajadores;
import orden.*;
import regex.RegEx;

/**
 *
 * @author usuario
 *
 */
public class VerDialog extends JDialog implements ActionListener, ItemListener {

    /**
     * Elementos del JFrame
     */

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
    Empresa empresa;

    ArrayList<Trabajador> lista;
    String[][] datos;

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        puesto = comboPuesto.getSelectedItem().toString();
    }

    public VerDialog(Empresa empresa) {
        this.empresa = empresa;
        setResizable(false);
        // t�tulo del di�log
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

        // una fila por JPanel
        pDni = new JPanel();
        pNombre = new JPanel();
        pApellidos = new JPanel();
        pDireccion = new JPanel();
        pTelefono = new JPanel();
        pPuesto = new JPanel();
        pBotones = new JPanel();

        // Se crean los elementos y se añaden
        etiquetaDni = new JLabel("DNI                 ");
        areaDni = new JTextField(15);
        // Se añaden al JPanel
        pDni.add(etiquetaDni);
        pDni.add(areaDni);

        // Se crean los elementos y se añaden
        etiquetaNombre = new JLabel("Nombre         ");
        areaNombre = new JTextField(15);
        // Se añaden al JPanel
        pNombre.add(etiquetaNombre);
        pNombre.add(areaNombre);

        // Se crean los elementos y se a�aden
        etiquetaApellidos = new JLabel("Apellidos      ");
        areaApellidos = new JTextField(15);
        // Se añaden al JPanel
        pApellidos.add(etiquetaApellidos);
        pApellidos.add(areaApellidos);

        // Se crean los elementos y se añaden
        etiquetaDireccion = new JLabel("Direccion      ");
        areaDireccion = new JTextField(15);
        // Se añaden al JPanel
        pDireccion.add(etiquetaDireccion);
        pDireccion.add(areaDireccion);

        // Se crean los elementos y se a�aden
        etiquetaTelefono = new JLabel("Telefono       ");
        areaTelefono = new JTextField(15);
        // Se añaden al JPanel
        pTelefono.add(etiquetaTelefono);
        pTelefono.add(areaTelefono);

        // Se crean los elementos y se añaden
        etiquetaPuesto = new JLabel("Puesto                         ");
        pPuesto.add(etiquetaPuesto);
        // lista desplegable
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

        String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
        lista = new ArrayList<>();
        datos = AccesoTrabajadores.listarTrabajadores(lista);
        tabla = new JTable(datos, columnas);
        tabla.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = tabla.columnAtPoint(evt.getPoint());
                String nombreColumna = tabla.getColumnName(col).toLowerCase();
                ordenarLista(nombreColumna);
            }
        });
        // Mete la tabla en un JCrollPane
        JScrollPane jsp = new JScrollPane(tabla);
        jsp.setPreferredSize(new Dimension(700, 600));
        add(jsp);

        // Visible
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == aceptar) {
            dni = areaDni.getText();
            nombre = areaNombre.getText();
            apellidos = areaApellidos.getText();
            direccion = areaDireccion.getText();
            telefono = areaTelefono.getText();
            String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
            Trabajador tBuscar = new Trabajador(dni, nombre, apellidos, direccion, telefono, puesto);
            this.lista = AccesoTrabajadores.buscarTrabajadaroesPorVariosCampos(tBuscar);

            if (!this.lista.isEmpty()) {
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas);
            } else {
                JOptionPane.showMessageDialog(null, "No se han encontrado trabajadores con esos datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelar) {
            dispose();
        }

    }

    public void recargarLista(String[][] datos, String[] columnas) {
        tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    public void ordenarLista(String columna) {
        lista = AccesoTrabajadores.obtenerTrabajadores();
        switch (columna) {
            case "identificador":
                String[] columnas = { "Identificador ▼", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
                this.lista.sort(new TrabajadoresPorOid());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas);
                break;
            case "dni":
                String[] columnas2 = { "Identificador", "DNI ▼", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
                this.lista.sort(new TrabajadoresPorDni());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas2);
                break;
            case "nombre":
                String[] columnas3 = { "Identificador", "DNI", "Nombre ▼", "Apellidos", "Direccion", "Telefono", "Puesto" };
                this.lista.sort(new TrabajadoresPorNombre());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas3);
                break;
            case "apellidos":
                String[] columnas4 = { "Identificador", "DNI", "Nombre", "Apellidos ▼", "Direccion", "Telefono", "Puesto" };
                this.lista.sort(new TrabajadoresPorApellidos());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas4);
                break;
            case "direccion":
                String[] columnas5 = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion ▼", "Telefono", "Puesto" };
                this.lista.sort(new TrabajadoresPorDireccion());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas5);
                break;
            case "telefono":
                String[] columnas6 = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono ▼", "Puesto" };
                this.lista.sort(new TrabajadoresPorTelefono());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas6);
                break;
            case "puesto":
                String[] columnas7 = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto ▼" };
                this.lista.sort(new TrabajadoresPorPuesto());
                this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
                recargarLista(this.datos, columnas7);
                break;
        }
    }
}
