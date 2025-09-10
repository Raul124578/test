import java.io.*;

public class AnalizadorLexico {
    private Contadores contadores;

    public AnalizadorLexico(Contadores contadores) {
        this.contadores = contadores;
    }

    public String procesarArchivo(File archivoEntrada) {
        StringBuilder resultado = new StringBuilder();
        contadores.reset();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                String[] cadenas = linea.split("\\s+");
                int columna = 1;

                for (String cadena : cadenas) {
                    if (cadena.isEmpty()) continue;

                    String clasificacion = Clasificador.clasificar(cadena);

                    resultado.append(
                        String.format("Línea %d, Columna %d: %-15s --> %s%n",
                                numeroLinea, columna, cadena, clasificacion)
                    );

                    contadores.actualizar(clasificacion);
                    columna += cadena.length() + 1;
                }
                numeroLinea++;
            }

            resultado.append("\n").append(contadores.getResumen());

        } catch (IOException e) {
            resultado.append("Error al leer archivo: ").append(e.getMessage());
        }

        return resultado.toString();
    }
}

