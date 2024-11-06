import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        int[] respuestas = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Encuesta de satisfacción del cliente (califique de 1 a 5).");

        // Solicitar calificaciones a los clientes
        for (int i = 0; i < respuestas.length; i++) {
            System.out.print("Ingrese la calificación de satisfacción del cliente " + (i + 1) + " (1-5): ");
            int calificacion;
            while (true) {
                calificacion = scanner.nextInt();
                if (calificacion >= 1 && calificacion <= 5) {
                    break;
                } else {
                    System.out.print("Calificación inválida. Ingrese una calificación entre 1 y 5: ");
                }
            }
            respuestas[i] = calificacion;
        }

        // Calcular el promedio de satisfacción y contar las calificaciones máximas
        int suma = 0;
        int conteoMaximas = 0;

        for (int calificacion : respuestas) {
            suma += calificacion;
            if (calificacion == 5) {
                conteoMaximas++;
            }
        }

        double promedio = (double) suma / respuestas.length;

        // Mostrar resultados
        System.out.println("\nResultados de la encuesta:");
        System.out.printf("Promedio de satisfacción: %.2f%n", promedio);
        System.out.println("Número de clientes que dieron la calificación máxima (5): " + conteoMaximas);

        scanner.close();
    }
}
