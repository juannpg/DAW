/**
 * 
 */
package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import javax.swing.plaf.FileChooserUI;

import dao.AccesoTrabajadores;
import excepciones.ExcepcionCSV;
import excepciones.ExcepcionJSON;
import modelo.Empresa;
import modelo.Trabajador;
import orden.*;

/**
 * 
 * @author usuario
 *
 */
public class ListarDialog extends JDialog implements ActionListener {

	Empresa empresa;
	JTable tabla;
	JButton cerrar;
	JButton exportarCsv;
	JButton exportarJson;
	JFileChooser fc;
	ArrayList<Trabajador> lista;
	String[][] datos;

	public ListarDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		// t�tulo del di�log
		setTitle("Listado Trabajadores");
		// tama�o
		setSize(750, 700);
		setLayout(new FlowLayout());
		// colocaci�n en el centro de la pantalla
		setLocationRelativeTo(null);

		// Crea un JTable, cada fila será un trabajador
		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
		lista = AccesoTrabajadores.obtenerTrabajadores();
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

		cerrar = new JButton("Cerrar");
		exportarCsv = new JButton("Exportar a CSV");
		exportarJson = new JButton("Exportar a JSON");
		cerrar.addActionListener(this);
		exportarCsv.addActionListener(this);
		exportarJson.addActionListener(this);
		add(exportarCsv);
		add(exportarJson);
		add(cerrar);

		fc = new JFileChooser();

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cerrar) {
			dispose();
		} if (e.getSource() == exportarCsv) {
			int result = fc.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				String ruta = fc.getSelectedFile().getAbsolutePath();
				try {
					AccesoTrabajadores.exportarCsv(ruta);
					JOptionPane.showMessageDialog(null, "Trabajadores exportados correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} catch (ExcepcionCSV ecsv) {
					JOptionPane.showMessageDialog(null, "Error al exportar a CSV: " + ecsv.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} if (e.getSource() == exportarJson) {
			int result = fc.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				String ruta = fc.getSelectedFile().getAbsolutePath();
				try {
					AccesoTrabajadores.exportarJson(ruta);
					JOptionPane.showMessageDialog(null, "Trabajadores exportados correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
				    dispose();
				} catch (ExcepcionJSON ejson) {
					JOptionPane.showMessageDialog(null, "Error al exportar a CSV: " + ejson.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
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
			lista.sort(new TrabajadoresPorOid());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas);
			break;
		case "dni":
			String[] columnas2 = { "Identificador", "DNI ▼", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
			lista.sort(new TrabajadoresPorDni());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas2);
			break;
		case "nombre":
			String[] columnas3 = { "Identificador", "DNI", "Nombre ▼", "Apellidos", "Direccion", "Telefono", "Puesto" };
			lista.sort(new TrabajadoresPorNombre());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas3);
			break;
		case "apellidos":
			String[] columnas4 = { "Identificador", "DNI", "Nombre", "Apellidos ▼", "Direccion", "Telefono", "Puesto" };
			lista.sort(new TrabajadoresPorApellidos());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas4);
			break;
		case "direccion":
			String[] columnas5 = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion ▼", "Telefono", "Puesto" };
			lista.sort(new TrabajadoresPorDireccion());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas5);
			break;
		case "telefono":
			String[] columnas6 = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono ▼", "Puesto" };
			lista.sort(new TrabajadoresPorTelefono());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas6);
			break;
		case "puesto":
			String[] columnas7 = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto ▼" };
			lista.sort(new TrabajadoresPorPuesto());
			datos = AccesoTrabajadores.listarTrabajadores(lista);
			recargarLista(datos, columnas7);
			break;
		}
	}
}
