/**
 *
 */
package dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Empresa;
import modelo.Trabajador;
import dao.AccesoTrabajadores;
import regex.RegEx;

/**
 *
 * @author usuario
 *
 */
public class VerDialog extends JDialog implements ActionListener {

    /**
     * Elementos del JFrame
     */

    JLabel etiquetaDni;
    JTextField areaDni;
    String dni = "";
    JPanel pDni;
    JButton aceptar;
    JButton cancelar;
    JPanel pBotones;
    JPanel pTrabajador;
    JLabel lId;
    JLabel lDni;
    JLabel lNombre;
    JLabel lApellidos;
    JLabel lDireccion;
    JLabel lTelefono;
    JLabel lPuesto;
    JPanel pTitulo;
    JLabel etiquetaTitulo;
    Empresa empresa;

    public VerDialog(Empresa empresa) {
        this.empresa = empresa;
        setResizable(false);
        // t�tulo del di�log
        setTitle("Buscar Trabajador");
        setSize(300, 350);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        pTitulo = new JPanel();
        etiquetaTitulo = new JLabel("Introduce el DNI del trabajador que desea buscar");
        pTitulo.add(etiquetaTitulo);
        add(pTitulo);

        // una fila por JPanel
        pDni = new JPanel();
        // Se crean los elementos y se añaden
        etiquetaDni = new JLabel("DNI                 ");
        areaDni = new JTextField(15);
        // Se añaden al JPanel
        pDni.add(etiquetaDni);
        pDni.add(areaDni);
        add(pDni);

        pTrabajador = new JPanel();
        pTrabajador.setLayout(new GridLayout(7, 1));
        lId = new JLabel();
        lDni = new JLabel();
        lNombre = new JLabel();
        lApellidos = new JLabel();
        lDireccion = new JLabel();
        lTelefono = new JLabel();
        lPuesto = new JLabel();
        pTrabajador.add(lId);
        pTrabajador.add(lDni);
        pTrabajador.add(lNombre);
        pTrabajador.add(lApellidos);
        pTrabajador.add(lDireccion);
        pTrabajador.add(lTelefono);
        pTrabajador.add(lPuesto);
        add(pTrabajador);

        pBotones = new JPanel();
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
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == aceptar) {
            dni = areaDni.getText();
            if (comprobarErrores()) {
                Trabajador trabajador = AccesoTrabajadores.buscarTrabajador(dni);
                if (trabajador != null) {
                    lId.setText("ID: " + trabajador.getIdentificador().toString());
                    lDni.setText("DNI: " + trabajador.getDni());
                    lNombre.setText("Nombre: " + trabajador.getNombre());
                    lApellidos.setText("Apellidos: " + trabajador.getApellidos());
                    lDireccion.setText("Direccion: " + trabajador.getDireccion());
                    lTelefono.setText("Telefono: " + trabajador.getTelefono());
                    lPuesto.setText("Puesto: " + trabajador.getPuesto());
                } else {
                    JOptionPane.showMessageDialog(null, "El DNI introducido no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    areaDni.setText("");
                }
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
        } else if (!RegEx.dniBien(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI debe ser válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
