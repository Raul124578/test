import java.util.*; 
// Importa utilidades de Java (colecciones, arrays, etc.) necesarias para manejar conjuntos y listas

// Clase encargada de clasificar cadenas en diferentes categorías léxicas
public class Clasificador {

    // Conjunto que almacena todas las palabras reservadas del lenguaje Java
    // Se usa un HashSet para que las búsquedas sean rápidas (O(1) promedio)
    private static final Set<String> PALABRAS_RESERVADAS = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte",
        "case", "catch", "char", "class", "const", "continue",
        "default", "do", "double", "else", "enum", "extends",
        "final", "finally", "float", "for", "goto", "if",
        "implements", "import", "instanceof", "int", "interface",
        "long", "native", "new", "package", "private", "protected",
        "public", "return", "short", "static", "strictfp", "super",
        "switch", "synchronized", "this", "throw", "throws",
        "transient", "try", "void", "volatile", "while"
    ));

    // Método que clasifica una cadena según las reglas definidas
    public static String clasificar(String cadena) {
        // Si la cadena es nula o vacía, no es válida → error léxico
        if (cadena == null || cadena.isEmpty()) return "Error léxico";

        // Caso 1: verificar si la cadena es una palabra reservada de Java
        if (PALABRAS_RESERVADAS.contains(cadena)) {
            return "Palabra reservada";
        }

        // Caso 2: verificar si es un identificador válido
        // Un identificador debe iniciar con letra o guion bajo, 
        // seguido de letras, números o guiones bajos
        if (cadena.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return "Identificador";
        }

        // Caso 3: signos de agrupación como (), {}, []
        if (cadena.equals("(") || cadena.equals(")") ||
            cadena.equals("{") || cadena.equals("}")) {
            return "Signo de agrupación";
        }

        // Caso 4: operadores aritméticos básicos
        if (cadena.equals("=") || cadena.equals("+") || cadena.equals("-") ||
            cadena.equals("*") || cadena.equals("/") || cadena.equals("%")) {
            return "Operador aritmético";
        }

        // Caso 5: símbolos especiales comunes
        if (cadena.equals(";") || cadena.equals(",") || cadena.equals(".")) {
            return "Símbolo especial";
        }
        
        // Caso 6: números enteros (secuencia de dígitos)
        if (cadena.matches("[0-9]+")) {
            return "Número";
        }

        // Caso 7: operador punto (para acceso a miembros: objeto.metodo)
        if (cadena.equals(".")) {
            return "Operador de acceso";
        }

        // Caso 8: punto y coma (fin de instrucción en Java)
        if (cadena.equals(";")) {
            return "Símbolo especial";
        }

        // Caso 9: comentarios de una sola línea
        if (cadena.startsWith("//")) {
            return "Comentario";
        }

        // Si no coincide con ninguna regla anterior → error léxico
        return "Error léxico";
    }
}
