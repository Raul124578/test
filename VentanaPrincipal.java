import java.awt.*;
import java.io.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JTextArea areaTexto;
    private JButton btnCargar, btnGuardar;
    private File archivoEntrada;
    private Contadores contadores = new Contadores();

    public VentanaPrincipal() {
        setTitle("Reconocedor de Tokens");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        btnCargar = new JButton("Cargar archivo");
        btnGuardar = new JButton("Guardar Salida.txt");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCargar);
        panelBotones.add(btnGuardar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnCargar.addActionListener(e -> cargarArchivo());
        btnGuardar.addActionListener(e -> guardarSalida());

        setVisible(true);
    }

    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            archivoEntrada = fileChooser.getSelectedFile();
            AnalizadorLexico analizador = new AnalizadorLexico(contadores);
            String resultado = analizador.procesarArchivo(archivoEntrada);
            areaTexto.setText(resultado);
        }
    }

    private void guardarSalida() {
        if (archivoEntrada != null) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("Salida.txt"))) {
                pw.write(areaTexto.getText());
                JOptionPane.showMessageDialog(this, "Archivo guardado como Salida.txt");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero carga un archivo.");
        }
    }
}
