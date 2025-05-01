/**
 * 
 */
package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import javax.swing.plaf.FileChooserUI;

import dao.AccesoTrabajadores;
import excepciones.ExcepcionCSV;
import excepciones.ExcepcionJSON;
import modelo.Empresa;

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
		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direcci�n", "Tel�fono", "Puesto" };
		String[][] datos = AccesoTrabajadores.listarTrabajadores();
		tabla = new JTable(datos, columnas);
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
}
