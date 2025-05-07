package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.AccesoTrabajadores;
import excepciones.ExcepcionCSV;
import excepciones.ExcepcionJSON;
import modelo.Trabajador;
import orden.*;

public class ListarDialog extends JDialog implements ActionListener {

	JTable tabla;
	JButton cerrar;
	JButton exportarCsv;
	JButton exportarJson;
	JFileChooser fc;

	String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono", "Puesto" };
	ArrayList<Trabajador> lista = AccesoTrabajadores.obtenerTrabajadores();
	String[][] datos = AccesoTrabajadores.listarTrabajadores(lista);

	public ListarDialog() {
		setResizable(false);
		setTitle("Listado Trabajadores");
		setSize(750, 700);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

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

	public void recargarLista() {
		this.lista = AccesoTrabajadores.obtenerTrabajadores();
		this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);

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
