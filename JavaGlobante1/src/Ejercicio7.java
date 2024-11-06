import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        ArrayList<String> reservas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de reservas del restaurante.");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar una reserva");
            System.out.println("2. Cancelar una reserva");
            System.out.println("3. Ver lista de reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente para la reserva: ");
                    String nombreReserva = scanner.nextLine();
                    reservas.add(nombreReserva);
                    System.out.println("Reserva agregada exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del cliente para cancelar la reserva: ");
                    String nombreCancelar = scanner.nextLine();
                    if (reservas.remove(nombreCancelar)) {
                        System.out.println("Reserva cancelada exitosamente.");
                    } else {
                        System.out.println("No se encontró ninguna reserva para ese nombre.");
                    }
                    break;

                case 3:
                    System.out.println("\nLista de reservas confirmadas:");
                    if (reservas.isEmpty()) {
                        System.out.println("No hay reservas confirmadas.");
                    } else {
                        for (String reserva : reservas) {
                            System.out.println("- " + reserva);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema de reservas.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        System.out.println("\nLista final de reservas confirmadas:");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas confirmadas.");
        } else {
            for (String reserva : reservas) {
                System.out.println("- " + reserva);
            }
        }

        scanner.close();
    }
}
