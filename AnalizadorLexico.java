// Probando 1 23


import java.io.*; // Importa librerías necesarias para manejo de archivos

// Definición de la clase AnalizadorLexico
public class AnalizadorLexico {
    // Objeto que lleva el control de las estadísticas de los elementos encontrados
    private Contadores contadores;

    // Constructor: recibe un objeto Contadores ya inicializado
    public AnalizadorLexico(Contadores contadores) {
        this.contadores = contadores;
    }

    // Método principal: procesa un archivo de entrada y devuelve un informe como String
    public String procesarArchivo(File archivoEntrada) {
        StringBuilder resultado = new StringBuilder(); // Acumula los resultados en una cadena
        contadores.reset(); // Reinicia los contadores antes de analizar un nuevo archivo

        // Manejo de lectura de archivo con BufferedReader (se cierra automáticamente con try-with-resources)
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;        // Almacena la línea leída del archivo
            int numeroLinea = 1; // Contador para identificar el número de línea actual

            // Bucle que recorre el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Separa cada línea en "cadenas" usando espacios en blanco como delimitador
                String[] cadenas = linea.split("\\s+");
                int columna = 1; // Variable para llevar el número de columna dentro de la línea

                // Recorre cada cadena encontrada en la línea
                for (String cadena : cadenas) {
                    if (cadena.isEmpty()) continue; // Ignora cadenas vacías

                    // Clasifica la cadena según reglas definidas en la clase Clasificador
                    String clasificacion = Clasificador.clasificar(cadena);

                    // Formatea y guarda en el resultado la información:
                    // línea, columna, cadena y su clasificación
                    resultado.append(
                        String.format("Línea %d, Columna %d: %-15s --> %s%n",
                                numeroLinea, columna, cadena, clasificacion)
                    );

                    // Actualiza los contadores según la clasificación obtenida
                    contadores.actualizar(clasificacion);

                    // Aumenta el valor de la columna considerando la longitud de la cadena más un espacio
                    columna += cadena.length() + 1;
                }
                // Avanza al siguiente número de línea
                numeroLinea++;
            }

            // Al final del archivo, agrega un resumen de los contadores al resultado
            resultado.append("\n").append(contadores.getResumen());

        } catch (IOException e) {
            // Si ocurre un error al leer el archivo, se guarda el mensaje de error
            resultado.append("Error al leer archivo: ").append(e.getMessage());
        }

        // Retorna todo el resultado generado como cadena de texto
        return resultado.toString();
    }
}
