// Clase que lleva el control de las cantidades de diferentes categorías léxicas encontradas
public class Contadores {
    // Variables internas que acumulan las cantidades encontradas
    private int reservadas = 0;       // Cantidad de palabras reservadas detectadas
    private int identificadores = 0;  // Cantidad de identificadores válidos
    private int simbolos = 0;         // Cantidad de símbolos especiales
    private int errores = 0;          // Cantidad de errores léxicos

    // Método que actualiza los contadores según la clasificación recibida
    public void actualizar(String clasificacion) {
        switch (clasificacion) {
            case "Palabra reservada": 
                reservadas++; 
                break;
            case "Identificador": 
                identificadores++; 
                break;
            case "Símbolo especial": 
                simbolos++; 
                break;
            default: 
                // Si no coincide con los casos anteriores, se contabiliza como error
                errores++; 
                break;
        }
    }

    // Método que devuelve un resumen formateado con los resultados del análisis
    public String getResumen() {
        return "======= RESUMEN =======\n" +
               "Palabras reservadas: " + reservadas + "\n" +
               "Identificadores    : " + identificadores + "\n" +
               "Símbolos especiales: " + simbolos + "\n" +
               "Errores léxicos    : " + errores + "\n";
    }

    // Método que reinicia todos los contadores a cero (para un nue
