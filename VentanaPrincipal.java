import java.awt.*;          // Importa clases de AWT (para layouts, componentes gráficos básicos, etc.)
import java.io.*;           // Importa clases de entrada/salida (para leer y escribir archivos).
import javax.swing.*;       // Importa las clases de Swing (JFrame, JButton, JTextArea, etc.).

// La clase VentanaPrincipal extiende de JFrame, por lo que es una ventana gráfica.
public class VentanaPrincipal extends JFrame {

    // Componentes gráficos y variables que usará la ventana.
    private JTextArea areaTexto;            // Área de texto para mostrar el contenido procesado.
    private JButton btnCargar, btnGuardar, btnSalir;  // Botones de acción.
    private File archivoEntrada;            // Archivo que el usuario seleccione.
    private Contadores contadores = new Contadores(); // Objeto para manejar los conteos (definido en otra clase).

    // Constructor: se ejecuta al crear la ventana.
    public VentanaPrincipal() {
        setTitle("Reconocedor de Tokens");       // Título de la ventana.
        setSize(600, 400);                       // Tamaño inicial de la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Al cerrar la ventana, la aplicación termina.
        setLocationRelativeTo(null);             // Centra la ventana en la pantalla.

        areaTexto = new JTextArea();             // Se crea el área de texto.
        areaTexto.setEditable(false);            // No se puede editar manualmente.
        JScrollPane scroll = new JScrollPane(areaTexto); // Barra de desplazamiento para el área de texto.

        // Creación de botones con el texto que se mostrará.
        btnCargar = new JButton("Cargar archivo");
        btnGuardar = new JButton("Guardar Salida.txt");
        btnSalir = new JButton("Salir");

        // Panel que contendrá los botones.
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCargar);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnSalir); 

        // Se agregan los componentes principales a la ventana.
        add(scroll, BorderLayout.CENTER);   // El área de texto con scroll ocupa el centro.
        add(panelBotones, BorderLayout.SOUTH); // Los botones van en la parte inferior.

        // Asignación de acciones a los botones con expresiones lambda.
        btnCargar.addActionListener(e -> cargarArchivo());    // Al hacer clic, abre un archivo.
        btnGuardar.addActionListener(e -> guardarSalida());   // Al hacer clic, guarda el contenido.
        btnSalir.addActionListener(e -> salirAplicacion());   // Al hacer clic, sale de la app.

        setVisible(true);  // Hace visible la ventana al usuario.
    }

    // Método para cargar un archivo y procesarlo con el analizador.
    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser(); // Cuadro de diálogo para elegir archivo.
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            archivoEntrada = fileChooser.getSelectedFile();  // Se guarda el archivo elegido.
            AnalizadorLexico analizador = new AnalizadorLexico(contadores); // Se crea el analizador.
            String resultado = analizador.procesarArchivo(archivoEntrada);  // Procesa el archivo.
            areaTexto.setText(resultado); // Muestra el resultado en el área de texto.
        }
    }

    // Método para guardar el contenido del área de texto en un archivo llamado "Salida.txt".
    private void guardarSalida() {
        if (archivoEntrada != null) { // Solo si ya se cargó un archivo previamente.
            try (PrintWriter pw = new PrintWriter(new FileWriter("Salida.txt"))) {
                pw.write(areaTexto.getText()); // Escribe el contenido del área de texto en el archivo.
                JOptionPane.showMessageDialog(this, "Archivo guardado como Salida.txt");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero carga un archivo."); // Aviso si no hay archivo cargado.
        }
    }

    // Método para salir de la aplicación, preguntando antes al usuario.
    private void salirAplicacion() {
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Desea salir de la aplicación?",  // Mensaje de confirmación.
            "Confirmar salida",                // Título del cuadro de diálogo.
            JOptionPane.YES_NO_OPTION          // Opciones: Sí o No.
        );

        if (opcion == JOptionPane.YES_OPTION) {
            dispose();       // Cierra la ventana actual.
            System.exit(0);  // Termina la aplicación por completo.
        }
    }
}
