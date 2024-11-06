import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        char[][] asientos = new char[5][5];
        Scanner scanner = new Scanner(System.in);

        // Inicializar la matriz de asientos como disponibles ('O')
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                asientos[i][j] = 'O';
            }
        }

        System.out.println("Bienvenido al sistema de reservas de asientos del cine.");
        boolean continuar = true;

        while (continuar) {
            mostrarAsientos(asientos);

            System.out.print("Ingrese la fila (1-5) del asiento que desea reservar: ");
            int fila = scanner.nextInt() - 1;

            System.out.print("Ingrese la columna (1-5) del asiento que desea reservar: ");
            int columna = scanner.nextInt() - 1;

            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                System.out.println("Selección inválida. Intente nuevamente.");
            } else if (asientos[fila][columna] == 'X') {
                System.out.println("Este asiento ya está ocupado. Por favor, elija otro asiento.");
            } else {
                asientos[fila][columna] = 'X';
                System.out.println("Asiento reservado exitosamente.");
            }

            System.out.print("¿Desea reservar otro asiento? (s/n): ");
            char respuesta = scanner.next().charAt(0);
            if (respuesta != 's' && respuesta != 'S') {
                continuar = false;
            }
        }

        System.out.println("\nEstado final de los asientos:");
        mostrarAsientos(asientos);
        scanner.close();
    }

    // Método para mostrar la disposición de los asientos
    private static void mostrarAsientos(char[][] asientos) {
        System.out.println("\nEstado actual de los asientos (O = Disponible, X = Ocupado):");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }
}
