import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserte su edad: ");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("acceso permitido");
        } else {
            System.out.println("acceso denegado");
        }
        scanner.close();
    }
}
