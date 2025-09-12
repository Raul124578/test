import java.util.*;

public class Clasificador {

    
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

    public static String clasificar(String cadena) {
        if (cadena == null || cadena.isEmpty()) return "Error léxico";

        
        if (PALABRAS_RESERVADAS.contains(cadena)) {
            return "Palabra reservada";
        }

        
        if (cadena.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return "Identificador";
        }

       
        if (cadena.equals("(") || cadena.equals(")") ||
            cadena.equals("{") || cadena.equals("}")) {
            return "Signo de agrupación";
        }

        
        if (cadena.equals("=") || cadena.equals("+") || cadena.equals("-") ||
            cadena.equals("*") || cadena.equals("/") || cadena.equals("%")) {
            return "Operador aritmético";
        }

        
        if (cadena.equals(";") || cadena.equals(",") || cadena.equals(".")) {
            return "Símbolo especial";
        }
        
        if (cadena.matches("[0-9]+")) {
            return "Número";
        }

        // Operador punto
        if (cadena.equals(".")) {
            return "Operador de acceso";
        }

        // Punto y coma
        if (cadena.equals(";")) {
            return "Símbolo especial";
        }
         // Comentario de una sola línea
        
    if (cadena.startsWith("//")) {
         return "Comentario";
    }





        
        return "Error léxico";
    }
}



