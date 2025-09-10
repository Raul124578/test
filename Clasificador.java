import java.util.*;

public class Clasificador {
    private static final Set<String> PALABRAS_RESERVADAS = new HashSet<>(Arrays.asList(
        "if", "while", "for", "else", "return", "int", "float", "char", "void"
    ));

    public static String clasificar(String cadena) {
        if (PALABRAS_RESERVADAS.contains(cadena)) {
            return "Palabra reservada";
        }
        if (cadena.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return "Identificador";
        }
        if (cadena.matches("[\\{\\}\\(\\)]")) {
            return "Símbolo especial";
        }
        return "Error léxico";
    }
}


