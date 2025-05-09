package dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import dao.AccesoTrabajadores;
import modelo.Trabajador;
import orden.*;

public class ModificaDialog extends JDialog implements ActionListener {
	private Set<Point> celdasColoreadas = new HashSet<>();

	JTable tabla;
	JButton cerrar, guardarCambios;

	String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono", "Puesto" };
	ArrayList<Trabajador> lista = AccesoTrabajadores.obtenerTrabajadores();
	String[][] datos = AccesoTrabajadores.listarTrabajadores(lista);

	public ModificaDialog() {

		setResizable(false);
		setTitle("Listado Trabajadores");
		setSize(750, 700);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		tabla = new JTable(new javax.swing.table.DefaultTableModel(this.datos, this.columnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		});

		for (int i = 0; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value,
															   boolean isSelected, boolean hasFocus, int row, int column) {

					Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

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
		tabla.setModel(new javax.swing.table.DefaultTableModel(this.datos, this.columnas) {
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
				this.columnas = new String[]{
						"Identificador ▼", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto"
				};
				this.lista.sort(new TrabajadoresPorOid());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
			break;
			case "dni":
				this.columnas = new String[]{
						"Identificador", "DNI ▼", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto"
				};
				this.lista.sort(new TrabajadoresPorDni());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
			break;
			case "nombre":
				this.columnas = new String[]{
						"Identificador", "DNI", "Nombre ▼", "Apellidos", "Direccion", "Telefono", "Puesto"
				};
				this.lista.sort(new TrabajadoresPorNombre());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
			break;
			case "apellidos":
				this.columnas = new String[]{
						"Identificador", "DNI", "Nombre", "Apellidos ▼", "Direccion", "Telefono", "Puesto"
				};
				this.lista.sort(new TrabajadoresPorApellidos());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
			break;
			case "direccion":
				this.columnas = new String[]{
						"Identificador", "DNI", "Nombre", "Apellidos", "Direccion ▼", "Telefono", "Puesto"
				};
				this.lista.sort(new TrabajadoresPorDireccion());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
			break;
			case "telefono":
				this.columnas = new String[]{
						"Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono ▼", "Puesto"
				};
				this.lista.sort(new TrabajadoresPorTelefono());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
			break;
			case "puesto":
				this.columnas = new String[]{
						"Identificador", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Puesto ▼"
				};
				this.lista.sort(new TrabajadoresPorPuesto());
				this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
				recargarLista();
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
				if (resultado[0]) {
					JOptionPane.showMessageDialog(this, "Cambios aplicados correctamente en el trabajador con dni " + tModificado.getDni());
					this.lista = AccesoTrabajadores.obtenerTrabajadores();
					this.datos = AccesoTrabajadores.listarTrabajadores(this.lista);
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
