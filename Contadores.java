public class Contadores {
    private int reservadas = 0;
    private int identificadores = 0;
    private int simbolos = 0;
    private int errores = 0;

    public void actualizar(String clasificacion) {
        switch (clasificacion) {
            case "Palabra reservada": reservadas++; break;
            case "Identificador": identificadores++; break;
            case "Símbolo especial": simbolos++; break;
            default: errores++; break;
        }
    }

    public String getResumen() {
        return "======= RESUMEN =======\n" +
               "Palabras reservadas: " + reservadas + "\n" +
               "Identificadores    : " + identificadores + "\n" +
               "Símbolos especiales: " + simbolos + "\n" +
               "Errores léxicos    : " + errores + "\n";
    }

    public void reset() {
        reservadas = identificadores = simbolos = errores = 0;
    }
}

