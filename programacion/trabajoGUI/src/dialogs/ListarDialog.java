/**
 * 
 */
package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		String[][] datos = empresa.listarTrabajadores();
		tabla = new JTable(datos, columnas);
		// Mete la tabla en un JCrollPane
		JScrollPane jsp = new JScrollPane(tabla);
		jsp.setPreferredSize(new Dimension(700, 600));
		add(jsp);

		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(this);
		add(cerrar);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cerrar) {
			dispose();
		}
	}

}
