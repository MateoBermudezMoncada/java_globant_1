import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Ejercicio5 {
    String nombreUsuario;
    String contrasena;
    String correo;

    public Ejercicio5(String nombreUsuario, String contrasena, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario + " | Correo: " + correo;
    }
}

public class RegistroUsuarios {
    public static void main(String[] args) {
        ArrayList<Ejercicio5> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de registro de usuarios.");

        boolean continuarRegistro = true;
        while (continuarRegistro) {
            System.out.print("\nIngrese el nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();

            String contrasena;
            while (true) {
                System.out.print("Ingrese la contraseña: ");
                contrasena = scanner.nextLine();

                if (esContrasenaValida(contrasena)) {
                    break;
                } else {
                    System.out.println("La contraseña debe tener al menos 8 caracteres, una letra mayúscula y un número.");
                }
            }

            System.out.print("Ingrese el correo electrónico: ");
            String correo = scanner.nextLine();

            usuarios.add(new Ejercicio5(nombreUsuario, contrasena, correo));
            System.out.println("Usuario registrado exitosamente.");

            System.out.print("¿Desea registrar otro usuario? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuarRegistro = false;
            }
        }

        System.out.println("\nLista de usuarios registrados:");
        for (Ejercicio5 usuario : usuarios) {
            System.out.println(usuario);
        }

        scanner.close();
    }

    // Método para validar la contraseña
    private static boolean esContrasenaValida(String contrasena) {
        if (contrasena.length() < 8) {
            return false;
        }
        boolean tieneMayuscula = Pattern.compile("[A-Z]").matcher(contrasena).find();
        boolean tieneNumero = Pattern.compile("[0-9]").matcher(contrasena).find();
        return tieneMayuscula && tieneNumero;
    }
}
