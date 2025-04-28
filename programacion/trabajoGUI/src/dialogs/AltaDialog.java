/**
 *
 */
package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Empresa;
import modelo.Trabajador;
import org.bson.types.ObjectId;
import dao.AccesoTrabajadores;

/**
 *
 * @author usuario
 *
 */
public class AltaDialog extends JDialog implements ActionListener, ItemListener {

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
	JButton aceptar;
	JButton cancelar;
	/**
	 * Variables a las que se pasar� el contenido de los JTextField y del combo box
	 */
	String dni = "";
	String nombre = "";
	String apellidos = "";
	String direccion = "";
	int telefono = 0;
	String puesto = "";

	JPanel pDni;
	JPanel pNombre;
	JPanel pApellidos;
	JPanel pDireccion;
	JPanel pTelefono;
	JPanel pPuesto;
	JPanel pBotones;

	Empresa empresa;

	public AltaDialog(Empresa empresa) {
		this.empresa = empresa;
		setResizable(false);
		// t�tulo del di�log
		setTitle("Alta Trabajador");
		setSize(300, 350);
		setLayout(new FlowLayout());

		setLocationRelativeTo(null);

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
		comboPuesto.addItem("Elija Puesto");
		comboPuesto.addItem("Programador");
		comboPuesto.addItem("Analista");
		comboPuesto.addItem("Arquitecto");
		comboPuesto.addItem("Jefe de Proyecto");
		comboPuesto.addItemListener(this);
		pPuesto.add(comboPuesto);

		// Añadir al JDialog los JPanel
		add(pDni);
		add(pNombre);
		add(pApellidos);
		add(pDireccion);
		add(pTelefono);
		add(pPuesto);

		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		pBotones.add(aceptar);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		pBotones.add(cancelar);

		add(pBotones);

		// Visible
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		puesto = comboPuesto.getSelectedItem().toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == aceptar) {
			try {
				dni = areaDni.getText();
				nombre = areaNombre.getText();
				apellidos = areaApellidos.getText();
				direccion = areaDireccion.getText();
				telefono = Integer.parseInt(areaTelefono.getText());
				if (comprobarErrores()) {
					Trabajador t = new Trabajador(dni, nombre, apellidos, direccion, telefono, puesto);
					if (AccesoTrabajadores.altaTrabajador(t)) {
						JOptionPane.showMessageDialog(null, "Datos introducidos correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "El ID del trabajador que quiere introducir ya existe",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "El ID debe ser un n�mero entero", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == cancelar) {
			dispose();
		}

	}

	/**
	 * M�todo que comprueba si no hay ning�n campo vac�o o si la longitud de los
	 * campos es la correcta
	 *
	 * @return
	 */
	public boolean comprobarErrores() {
		if (dni.equals("") || dni.length() != 9) {
			JOptionPane.showMessageDialog(null, "El DNI debe tener longitud 9", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir el nombre del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (apellidos.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir los apellidos del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (direccion.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir la direcci�n del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (telefono < 100000000 || telefono > 999999999) {
			JOptionPane.showMessageDialog(null, "El tel�fono debe tener longitud 9", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (puesto.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir el puesto del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
