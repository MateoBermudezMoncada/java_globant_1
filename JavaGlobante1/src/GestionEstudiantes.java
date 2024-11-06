import java.util.ArrayList;
import java.util.Scanner;

class Ejercicio8 {
    String nombre;
    double promedio;

    public Ejercicio8(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Promedio: " + promedio;
    }
}

public class GestionEstudiantes {
    public static void main(String[] args) {
        ArrayList<Ejercicio8> estudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de estudiantes.");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar nuevo estudiante");
            System.out.println("2. Mostrar lista de estudiantes");
            System.out.println("3. Buscar estudiante por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el promedio del estudiante: ");
                    double promedio = scanner.nextDouble();

                    estudiantes.add(new Ejercicio8(nombre, promedio));
                    System.out.println("Estudiante agregado exitosamente.");
                    break;

                case 2:
                    System.out.println("\nLista de estudiantes:");
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Ejercicio8 estudiante : estudiantes) {
                            System.out.println(estudiante);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del estudiante a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    boolean encontrado = false;
                    for (Ejercicio8 estudiante : estudiantes) {
                        if (estudiante.nombre.equalsIgnoreCase(nombreBusqueda)) {
                            System.out.println("Estudiante encontrado: " + estudiante);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró un estudiante con ese nombre.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema de gestión de estudiantes.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }
}
