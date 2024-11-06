import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        final int MAX_TAREAS = 10;
        String[] tareas = new String[MAX_TAREAS]; // Arreglo para almacenar hasta 10 tareas
        boolean[] completadas = new boolean[MAX_TAREAS]; // Arreglo para marcar tareas completadas
        int contadorTareas = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la lista de tareas pendientes.");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar una nueva tarea");
            System.out.println("2. Marcar una tarea como completada");
            System.out.println("3. Mostrar lista de tareas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    if (contadorTareas < MAX_TAREAS) {
                        System.out.print("Ingrese la nueva tarea: ");
                        tareas[contadorTareas] = scanner.nextLine();
                        completadas[contadorTareas] = false;
                        contadorTareas++;
                        System.out.println("Tarea agregada exitosamente.");
                    } else {
                        System.out.println("No se pueden agregar más tareas. La lista está llena.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el número de la tarea que desea marcar como completada (1-" + contadorTareas + "): ");
                    int numeroTarea = scanner.nextInt();
                    if (numeroTarea > 0 && numeroTarea <= contadorTareas) {
                        completadas[numeroTarea - 1] = true;
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("Número de tarea inválido.");
                    }
                    break;

                case 3:
                    System.out.println("\nLista de tareas:");
                    for (int i = 0; i < contadorTareas; i++) {
                        String estado = completadas[i] ? "[Completada]" : "[Pendiente]";
                        System.out.println((i + 1) + ". " + tareas[i] + " " + estado);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo de la aplicación de lista de tareas.");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
        System.out.println("\nEstado final de la lista de tareas:");
        for (int i = 0; i < contadorTareas; i++) {
            String estado = completadas[i] ? "[Completada]" : "[Pendiente]";
            System.out.println((i + 1) + ". " + tareas[i] + " " + estado);
        }
    }
}
