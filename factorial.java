import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        // Definir variables
        int vNumero;
        int vFactorial;
        int vContador;

        // Inicialización
        vContador = 1;
        vFactorial = 1;

        // Leer número
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        vNumero = sc.nextInt();

        // Repetir hasta que vContador > vNumero
        do {
            vFactorial = vFactorial * vContador;
            vContador = vContador + 1;
        } while (vContador <= vNumero);

        // Mostrar resultado
        System.out.println("El factorial de " + vNumero + " es: " + vFactorial);

        sc.close();
    }
}
