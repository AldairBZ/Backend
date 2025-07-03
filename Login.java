import java.util.*;

public class Login {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();
            if (opcion.equals("1")) {
                registrarUsuario(sc);
            } else if (opcion.equals("2")) {
                loginUsuario(sc);
            } else if (opcion.equals("3")) {
                System.out.println("¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

    static void registrarUsuario(Scanner sc) {
        System.out.print("Elige un nombre de usuario: ");
        String username = sc.nextLine();
        System.out.print("Elige una contraseña: ");
        String password = sc.nextLine();
        if (SQL.registrarUsuario(username, password)) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("Ese usuario ya existe o hubo un error.");
        }
    }

    static void loginUsuario(Scanner sc) {
        System.out.print("Usuario: ");
        String username = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        if (SQL.loginUsuario(username, password)) {
            System.out.println("¡Login exitoso! Bienvenido, " + username + ".");
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}