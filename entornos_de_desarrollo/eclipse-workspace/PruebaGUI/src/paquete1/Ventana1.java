package paquete1;

import java.awt.EventQueue;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    private JTextArea textAreaDep;
    private JTextArea textAreaLoc;

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
        frame.setBounds(100, 100, 700, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 128));
        panel.setBounds(27, 76, 625, 292);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textFieldCod = new JTextField();
        textFieldCod.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCod.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldCod.setBackground(new Color(128, 128, 192));
        textFieldCod.setBounds(360, 70, 132, 35);
        panel.add(textFieldCod);
        textFieldCod.setColumns(10);

        textAreaDep = new JTextArea();
        textAreaDep.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textAreaDep.setBounds(360, 116, 173, 54);
        panel.add(textAreaDep);

        textAreaLoc = new JTextArea();
        textAreaLoc.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textAreaLoc.setBounds(360, 181, 173, 54);
        panel.add(textAreaLoc);

        JLabel locDep = new JLabel("Localidad Departamento:");
        locDep.setFont(new Font("Tahoma", Font.BOLD, 19));
        locDep.setBounds(42, 181, 293, 54);
        panel.add(locDep);
        
        JLabel lblNombreDepartamento = new JLabel("Nombre Departamento:");
        lblNombreDepartamento.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblNombreDepartamento.setBounds(42, 116, 293, 54);
        panel.add(lblNombreDepartamento);
        
        JLabel lblCdigoDepartamento = new JLabel("Código Departamento:");
        lblCdigoDepartamento.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblCdigoDepartamento.setBounds(42, 55, 293, 54);
        panel.add(lblCdigoDepartamento);

        JButton insertBtn = new JButton("Insertar Datos");
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String cod = textFieldCod.getText();
                    String dep = textAreaDep.getText();
                    String loc = textAreaLoc.getText();

                    String jsonData = String.format(
                        "{\"cod_dep\":\"%s\", \"nombre\":\"%s\", \"loc\":\"%s\"}",
                        cod, dep, loc
                    );

                    sendPostRequest(jsonData);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        insertBtn.setBounds(180, 402, 160, 38);
        frame.getContentPane().add(insertBtn);

        JButton cleanBtn = new JButton("Limpiar Datos");
        cleanBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldCod.setText("");
                textAreaDep.setText("");
                textAreaLoc.setText("");
            }
        });
        cleanBtn.setBounds(389, 402, 160, 38);
        frame.getContentPane().add(cleanBtn);

        JLabel textoTitulo = new JLabel("DATOS DE DEPARTAMENTOS");
        textoTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        textoTitulo.setForeground(new Color(0, 0, 255));
        textoTitulo.setBounds(189, 21, 395, 44);
        frame.getContentPane().add(textoTitulo);
    }

    private void sendPostRequest(String jsonData) throws Exception {
        URL url = new URL("http://localhost:4000/api/departamentos/departamentos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonData.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
    }
}
