package paquete1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Ventana1 {

	private JFrame frame;
	private JTextField textFieldCod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(27, 33, 369, 158);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textFieldCod = new JTextField();
		textFieldCod.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCod.setBackground(new Color(255, 0, 255));
		textFieldCod.setBounds(206, 39, 58, 19);
		panel.add(textFieldCod);
		textFieldCod.setColumns(10);
		
		JTextArea textAreaDep = new JTextArea();
		textAreaDep.setBounds(206, 68, 130, 22);
		panel.add(textAreaDep);
		
		JTextArea textAreaLoc = new JTextArea();
		textAreaLoc.setBounds(206, 100, 130, 22);
		panel.add(textAreaLoc);
		
		JLabel codDep = new JLabel("Código Departamento:");
		codDep.setFont(new Font("Tahoma", Font.BOLD, 11));
		codDep.setBounds(42, 42, 132, 13);
		panel.add(codDep);
		
		JLabel nomDep = new JLabel("Nombre Departamento:");
		nomDep.setFont(new Font("Tahoma", Font.BOLD, 11));
		nomDep.setBounds(42, 74, 132, 13);
		panel.add(nomDep);
		
		JLabel locDep = new JLabel("Localidad Departamento:");
		locDep.setFont(new Font("Tahoma", Font.BOLD, 11));
		locDep.setBounds(42, 106, 154, 13);
		panel.add(locDep);
		
		JButton insertBtn = new JButton("Insertar Datos");
		insertBtn.setBounds(55, 211, 134, 21);
		frame.getContentPane().add(insertBtn);
		
		JButton cleanBtn = new JButton("Limpiar Datos");
		cleanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("SE HA PULSADO EL BOTON LIMPIAR");
			}
		});
		cleanBtn.setBounds(239, 211, 134, 21);
		frame.getContentPane().add(cleanBtn);
		
		JLabel textoTitulo = new JLabel("DATOS DE DEPARTAMENTOS");
		textoTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		textoTitulo.setForeground(new Color(0, 0, 255));
		textoTitulo.setBounds(129, 10, 177, 13);
		frame.getContentPane().add(textoTitulo);
	}
}
