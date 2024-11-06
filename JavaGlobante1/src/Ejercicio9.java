import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        String[] empleados = new String[5];
        int[] calificaciones = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de evaluación de desempeño para empleados.");

        // Ingreso de nombres y calificaciones
        for (int i = 0; i < empleados.length; i++) {
            System.out.print("Ingrese el nombre del empleado " + (i + 1) + ": ");
            empleados[i] = scanner.nextLine();

            System.out.print("Ingrese la calificación de desempeño (1-10) para " + empleados[i] + ": ");
            int calificacion;
            while (true) {
                calificacion = scanner.nextInt();
                if (calificacion >= 1 && calificacion <= 10) {
                    break;
                } else {
                    System.out.print("Calificación inválida. Ingrese una calificación entre 1 y 10: ");
                }
            }
            calificaciones[i] = calificacion;
            scanner.nextLine(); // Limpiar el buffer
        }

        // Encontrar calificación más alta y más baja
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < calificaciones.length; i++) {
            if (calificaciones[i] > calificaciones[maxIndex]) {
                maxIndex = i;
            }
            if (calificaciones[i] < calificaciones[minIndex]) {
                minIndex = i;
            }
        }

        // Mostrar resultados
        System.out.println("\nResultados de la evaluación de desempeño:");
        System.out.println("Empleado con la calificación más alta: " + empleados[maxIndex] + " con " + calificaciones[maxIndex]);
        System.out.println("Empleado con la calificación más baja: " + empleados[minIndex] + " con " + calificaciones[minIndex]);

        scanner.close();
    }
}
