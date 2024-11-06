import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        final int MAX_ASISTENTES = 100;
        int entradasDisponibles = MAX_ASISTENTES;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de reservas de entradas para el evento.");
        System.out.println("Entradas totales disponibles: " + MAX_ASISTENTES);

        while (entradasDisponibles > 0) {
            System.out.print("¿Cuántas entradas desea reservar? ");
            int entradasReservadas = scanner.nextInt();

            if (entradasReservadas <= entradasDisponibles) {
                entradasDisponibles -= entradasReservadas;
                System.out.println("Reservaste " + entradasReservadas + " entradas. Entradas restantes: " + entradasDisponibles);
            } else {
                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + entradasDisponibles + " entradas.");
            }
        }

        System.out.println("El evento está lleno. No hay más entradas disponibles.");
        scanner.close();
    }
}

