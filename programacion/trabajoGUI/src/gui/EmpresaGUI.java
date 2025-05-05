
package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import dao.AccesoTrabajadores;
import dialogs.AltaDialog;
import dialogs.BajaDialog;
import dialogs.ListarDialog;
import dialogs.ModificaDialog;
import dialogs.VerDialog;
import ficheros.FicheroDatos;
import modelo.Empresa;
import modelo.Trabajador;

/**
 * 
 * @author usuario
 *
 */
public class EmpresaGUI extends JFrame implements ActionListener {

	Empresa empresa;
	
	JButton altaTrabajador;
	JButton bajaTrabajador;
	JButton modificaTrabajador;
	JButton buscaTrabajador;
	JButton listarTrabajadores;
	JButton salir;

	public EmpresaGUI() {
		super("Gestión de personal");

		FicheroDatos.insertarTrabajadoresAlIniciar("ficheroDatos\\empresa.dat");

		setSize(800, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 2));
		setLocationRelativeTo(null);
		altaTrabajador = new JButton("Añadir Trabajador");
		altaTrabajador.addActionListener(this);
		altaTrabajador.setIcon(new ImageIcon("images/addUser.png"));
		add(altaTrabajador);

		bajaTrabajador = new JButton("Borrar Trabajador");
		bajaTrabajador.addActionListener(this);		
		bajaTrabajador.setIcon(new ImageIcon("images/removeUser.png"));
		add(bajaTrabajador);

		modificaTrabajador = new JButton("Modificar Trabajador");
		modificaTrabajador.addActionListener(this);
		modificaTrabajador.setIcon(new ImageIcon("images/editUser.png"));
		add(modificaTrabajador);

		buscaTrabajador = new JButton("Buscar Trabajador");
		buscaTrabajador.addActionListener(this);
		buscaTrabajador.setIcon(new ImageIcon("images/searchUser.png"));
		add(buscaTrabajador);

		listarTrabajadores = new JButton("Listar Trabajadores");
		listarTrabajadores.addActionListener(this);
		Image image = new ImageIcon("images/list.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		listarTrabajadores.setIcon(new ImageIcon(image));
		add(listarTrabajadores);

		salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setIcon(new ImageIcon("images/exit.png"));
		add(salir);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == altaTrabajador) {
			new AltaDialog(empresa);
		} else if (e.getSource() == bajaTrabajador) {
			new BajaDialog(empresa);
		} else if (e.getSource() == modificaTrabajador) {
			new ModificaDialog(empresa);
		} else if (e.getSource() == buscaTrabajador) {
			new VerDialog(empresa);
		} else if (e.getSource() == listarTrabajadores) {
			new ListarDialog(empresa);
		}
		else if (e.getSource() == salir) {
			FicheroDatos.escribirTrabajadores("ficheroDatos\\empresa.dat", AccesoTrabajadores.obtenerTrabajadores());
			System.exit(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new EmpresaGUI();
	}
}
