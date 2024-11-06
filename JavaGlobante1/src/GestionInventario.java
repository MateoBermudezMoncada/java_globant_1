import java.util.ArrayList;
import java.util.Scanner;

class Ejercicio4 {
    String nombre;
    int cantidad;

    public Ejercicio4(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public boolean estaAgotado() {
        return cantidad == 0;
    }

    @Override
    public String toString() {
        String estado = estaAgotado() ? "[Agotado]" : "[En stock: " + cantidad + "]";
        return nombre + " " + estado;
    }
}

public class GestionInventario {
    public static void main(String[] args) {
        ArrayList<Ejercicio4> inventario = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de inventario.");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Eliminar producto agotado");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la cantidad en stock: ");
                    int cantidad = scanner.nextInt();
                    inventario.add(new Ejercicio4(nombre, cantidad));
                    System.out.println("Producto agregado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < inventario.size(); i++) {
                        if (inventario.get(i).nombre.equalsIgnoreCase(nombreEliminar) && inventario.get(i).estaAgotado()) {
                            inventario.remove(i);
                            System.out.println("Producto eliminado del inventario.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado o aún en stock.");
                    }
                    break;

                case 3:
                    System.out.println("\nInventario actual:");
                    for (Ejercicio4 producto : inventario) {
                        System.out.println(producto);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema de gestión de inventario.");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
        System.out.println("\nEstado final del inventario:");
        for (Ejercicio4 producto : inventario) {
            System.out.println(producto);
        }
    }
}
