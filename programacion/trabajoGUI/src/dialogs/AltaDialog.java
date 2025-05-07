package dialogs;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Trabajador;
import dao.AccesoTrabajadores;
import regex.RegEx;

public class AltaDialog extends JDialog implements ActionListener, ItemListener {

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

	String dni = "";
	String nombre = "";
	String apellidos = "";
	String direccion = "";
	String telefono = "";
	String puesto = "";

	JPanel pDni;
	JPanel pNombre;
	JPanel pApellidos;
	JPanel pDireccion;
	JPanel pTelefono;
	JPanel pPuesto;
	JPanel pBotones;

	public AltaDialog() {
		setResizable(false);
		setTitle("Alta Trabajador");
		setSize(300, 350);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		pDni = new JPanel();
		pNombre = new JPanel();
		pApellidos = new JPanel();
		pDireccion = new JPanel();
		pTelefono = new JPanel();
		pPuesto = new JPanel();
		pBotones = new JPanel();

		etiquetaDni = new JLabel("DNI                 ");
		areaDni = new JTextField(15);
		pDni.add(etiquetaDni);
		pDni.add(areaDni);

		etiquetaNombre = new JLabel("Nombre         ");
		areaNombre = new JTextField(15);
		pNombre.add(etiquetaNombre);
		pNombre.add(areaNombre);

		etiquetaApellidos = new JLabel("Apellidos      ");
		areaApellidos = new JTextField(15);
		pApellidos.add(etiquetaApellidos);
		pApellidos.add(areaApellidos);

		etiquetaDireccion = new JLabel("Direccion      ");
		areaDireccion = new JTextField(15);
		pDireccion.add(etiquetaDireccion);
		pDireccion.add(areaDireccion);

		etiquetaTelefono = new JLabel("Telefono       ");
		areaTelefono = new JTextField(15);
		pTelefono.add(etiquetaTelefono);
		pTelefono.add(areaTelefono);

		etiquetaPuesto = new JLabel("Puesto                         ");
		pPuesto.add(etiquetaPuesto);
		comboPuesto = new JComboBox();
		ArrayList<String> puestos = AccesoTrabajadores.obtenerPuestos();
		comboPuesto.addItem("Seleccione");
		for (String p : puestos) {
			comboPuesto.addItem(p);
		}
		comboPuesto.addItemListener(this);
		pPuesto.add(comboPuesto);

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

		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		puesto = comboPuesto.getSelectedItem().toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aceptar) {
			dni = areaDni.getText();
			nombre = areaNombre.getText();
			apellidos = areaApellidos.getText();
			direccion = areaDireccion.getText();
			telefono = areaTelefono.getText();
			if (comprobarErrores()) {
				Trabajador t = new Trabajador(dni, nombre, apellidos, direccion, telefono, puesto);
				if (AccesoTrabajadores.altaTrabajador(t)) {
					JOptionPane.showMessageDialog(null, "Datos introducidos correctamente");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "El DNI del trabajador que quiere introducir ya existe",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} else if (e.getSource() == cancelar) {
			dispose();
		}
	}

	public boolean comprobarErrores() {
		if (dni.equals("") || dni.length() != 9) {
			JOptionPane.showMessageDialog(null, "El DNI debe tener longitud 9", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!RegEx.dniBien(dni)) {
			JOptionPane.showMessageDialog(null, "El DNI debe ser válido", "Error", JOptionPane.ERROR_MESSAGE);
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
		} else if (telefono.length() != 9) {
			JOptionPane.showMessageDialog(null, "El tel�fono debe tener longitud 9", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!RegEx.telefonoBien(telefono)) {
			JOptionPane.showMessageDialog(null, "El tel�fono debe ser válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}else if (puesto.equals("") || puesto.equalsIgnoreCase("seleccione")) {
			JOptionPane.showMessageDialog(null, "Debe introducir el puesto del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
