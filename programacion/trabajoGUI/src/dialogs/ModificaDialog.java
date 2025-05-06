package dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import modelo.Empresa;
import dao.AccesoTrabajadores;
import modelo.Trabajador;
import orden.*;

public class ModificaDialog extends JDialog implements ActionListener {
	private Set<Point> celdasColoreadas = new HashSet<>();

	Empresa empresa;
	JTable tabla;
	JButton cerrar, guardarCambios;
	ArrayList<Trabajador> lista;
	String[][] datos;

	public ModificaDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		setTitle("Listado Trabajadores");
		setSize(750, 700);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto" };
		lista = AccesoTrabajadores.obtenerTrabajadores();
		datos = AccesoTrabajadores.listarTrabajadores(lista);

		tabla = new JTable(new javax.swing.table.DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		});

		// Renderer personalizado para colorear una celda específica
		for (int i = 0; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value,
															   boolean isSelected, boolean hasFocus, int row, int column) {

					Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

					// Si la celda está en el conjunto de coloreadas
					if (celdasColoreadas.contains(new Point(row, column))) {
						c.setBackground(Color.RED);
					} else {
						c.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
					}

					return c;
				}
			});
		}



		ArrayList<String> puestosLista = AccesoTrabajadores.obtenerPuestos();
		JComboBox<String> comboPuestos = new JComboBox<>(puestosLista.toArray(new String[0]));
		TableColumn puestoColumn = tabla.getColumnModel().getColumn(6);
		puestoColumn.setCellEditor(new DefaultCellEditor(comboPuestos));

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

		guardarCambios = new JButton("Guardar Cambios");
		guardarCambios.addActionListener(this);
		add(guardarCambios);

		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(this);
		add(cerrar);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == guardarCambios) {
			int confirm = JOptionPane.showConfirmDialog(this,
					"¿Está seguro que desea modificar el/los trabajador(es)?",
					"Confirmación",
					JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				aplicarCambios();
			}
		}
		else if (e.getSource() == cerrar) {
			dispose();
		}
	}

	public void recargarLista() {
		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono", "Puesto" };
		ArrayList<Trabajador> lista = AccesoTrabajadores.obtenerTrabajadores();
		String[][] datos = AccesoTrabajadores.listarTrabajadores(lista);

		tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		});

		ArrayList<String> puestosLista = AccesoTrabajadores.obtenerPuestos();
		JComboBox<String> comboPuestos = new JComboBox<>(puestosLista.toArray(new String[0]));
		TableColumn puestoColumn = tabla.getColumnModel().getColumn(6);
		puestoColumn.setCellEditor(new DefaultCellEditor(comboPuestos));
	}

	private void recargarLista(String[][] datos, String[] columnas) {
		tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		});

		ArrayList<String> puestosLista = AccesoTrabajadores.obtenerPuestos();
		JComboBox<String> comboPuestos = new JComboBox<>(puestosLista.toArray(new String[0]));
		TableColumn puestoColumn = tabla.getColumnModel().getColumn(6);
		puestoColumn.setCellEditor(new DefaultCellEditor(comboPuestos));
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

	private void aplicarCambios() {
		javax.swing.table.TableModel model = tabla.getModel();

		for (int i = 0; i < model.getRowCount(); i++) {
			String oid = model.getValueAt(i, 0).toString();
			Trabajador tOriginal = AccesoTrabajadores.buscarTrabajadorOid(oid);

			String nuevoDni = model.getValueAt(i, 1).toString();
			String nuevoNombre = model.getValueAt(i, 2).toString();
			String nuevoApellidos = model.getValueAt(i, 3).toString();
			String nuevaDireccion = model.getValueAt(i, 4).toString();
			String nuevoTelefono = model.getValueAt(i, 5).toString();
			String nuevoPuesto = model.getValueAt(i, 6).toString();

			if (!tOriginal.getDni().equals(nuevoDni) ||
					!tOriginal.getNombre().equals(nuevoNombre) ||
					!tOriginal.getApellidos().equals(nuevoApellidos) ||
					!tOriginal.getDireccion().equals(nuevaDireccion) ||
					!tOriginal.getTelefono().equals(nuevoTelefono) ||
					!tOriginal.getPuesto().equals(nuevoPuesto)) {

				Trabajador tModificado = new Trabajador(
						nuevoDni,
						nuevoNombre,
						nuevoApellidos,
						nuevaDireccion,
						nuevoTelefono,
						nuevoPuesto
				);

				boolean[] resultado = AccesoTrabajadores.modificarTrabajador(tModificado, oid);
				System.out.println(Arrays.toString(resultado));
				if (resultado[0]) {
					JOptionPane.showMessageDialog(this, "Cambios aplicados correctamente.");
					recargarLista();
				} else {
					JOptionPane.showMessageDialog(this, "Existen errores en los campos marcados.");
					for (int j = 0; j < resultado.length; j++) {
						if (resultado[j]) {
							celdasColoreadas.add(new Point(i, j));
							tabla.repaint();
						}
					}
				}
			}
		}
	}
}
