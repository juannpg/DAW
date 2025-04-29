/**
 * 
 */
package dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Empresa;
import dao.AccesoTrabajadores;

/**
 * 
 * @author usuario
 *
 */
public class BajaDialog extends JDialog implements ActionListener {

	Empresa empresa;
	JTable tabla;
	JButton cerrar, borrar;

	public BajaDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		setTitle("Listado Trabajadores");
		setSize(750, 700);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono", "Puesto" };
		String[][] datos = AccesoTrabajadores.listarTrabajadores();
		tabla = new JTable(datos, columnas);
		JScrollPane jsp = new JScrollPane(tabla);
		jsp.setPreferredSize(new Dimension(700, 600));
		add(jsp);

		borrar = new JButton("Borrar");
		borrar.addActionListener(this);
		add(borrar);

		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(this);
		add(cerrar);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == borrar) {
			int filaSeleccionada = tabla.getSelectedRow();
			if (filaSeleccionada != -1) {
				String dni = tabla.getValueAt(filaSeleccionada, 1).toString();
				int confirmacion = JOptionPane.showConfirmDialog(
						this,
						"¿Estás seguro de que deseas borrar al trabajador con DNI: " + dni + "?",
						"Confirmar borrado",
						JOptionPane.OK_CANCEL_OPTION
				);

				if (confirmacion == JOptionPane.OK_OPTION) {
					boolean borrado = AccesoTrabajadores.bajaTrabajador(dni);
					if (borrado) {
						JOptionPane.showMessageDialog(this, "Trabajador borrado correctamente.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(this, "El trabajador no existe.");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Borrado cancelado.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Por favor selecciona un trabajador.");
			}
		} else if (e.getSource() == cerrar) {
			dispose();
		}
	}
}
