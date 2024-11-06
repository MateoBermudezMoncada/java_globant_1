import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        String[] productos = new String[10];
        int[] cantidades = new int[10];
        int numProductos = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de gestión de inventario de la tienda.");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar cantidad de un producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    if (numProductos < productos.length) {
                        System.out.print("Ingrese el nombre del producto: ");
                        productos[numProductos] = scanner.nextLine();

                        System.out.print("Ingrese la cantidad en stock: ");
                        cantidades[numProductos] = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        numProductos++;
                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("No se pueden agregar más productos. El inventario está lleno.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String productoActualizar = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (productos[i].equalsIgnoreCase(productoActualizar)) {
                            System.out.print("Ingrese la nueva cantidad en stock para " + productos[i] + ": ");
                            cantidades[i] = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            System.out.println("Cantidad actualizada exitosamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 3:
                    System.out.println("\nInventario de productos:");
                    for (int i = 0; i < numProductos; i++) {
                        System.out.println("Producto: " + productos[i] + " | Cantidad en stock: " + cantidades[i]);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema de inventario.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }
}
