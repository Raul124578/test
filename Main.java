import javax.swing.SwingUtilities;  
// Importa la clase SwingUtilities, que contiene métodos útiles
// para manejar la parte gráfica (Swing) en Java, asegurando
// que las interfaces se ejecuten en el hilo correcto (Event Dispatch Thread).

public class Main {
    public static void main(String[] args) {
        // El método main es el punto de entrada del programa.
        // Aquí comienza la ejecución de la aplicación.

        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
        // invokeLater se usa para asegurarse de que la creación
        // y manipulación de la interfaz gráfica ocurra en el hilo
        // especial de Swing (Event Dispatch Thread).
        // Dentro de invokeLater, se usa una expresión lambda que
        // crea un nuevo objeto de tipo VentanaPrincipal.
        // Esto significa que, cuando corras el programa, se abrirá
        // una ventana definida en esa clase (VentanaPrincipal).
    }
}

