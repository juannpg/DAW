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
public class ModificaDialog extends JDialog implements ActionListener {

	Empresa empresa;
	JTable tabla;
	JButton cerrar, borrar;

	public ModificaDialog(Empresa empresa) {
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

		borrar = new JButton("Modificar");
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

				new ModificaSubDialog(empresa, dni, this);
			} else {
				JOptionPane.showMessageDialog(this, "Por favor selecciona un trabajador.");
			}
		} else if (e.getSource() == cerrar) {
			dispose();
		}
	}
}
