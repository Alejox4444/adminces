package principal;

import java.util.Scanner;

public class Usuario {

    String nombre = "Yanis";
    String apellido = "Correa";
    String paisdenacimiento = "Uruguay";
    String email = "yaniscorrea@gmail.com";
    String contrasena = "12345";
    boolean esAdministrador = true;
    boolean esTesterJunior = false;
    boolean esTesterSenior = false;
    boolean esTesterLider = false;

    void main() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese 1 para loguearse o 2 para registrarse");
        String opcion = scan.nextLine();

        if (opcion.equals("1")) {
            login(scan);
        } else if (opcion.equals("2")) {
            registroUsuario(scan, email);
        } else {
            System.out.println("No existe la opción indicada");
        }
    }

    void login(Scanner scan){

        System.out.println("Ingrese email: ");
        String emailingresado = scan.nextLine();

        System.out.println("Ingrese contaseña: ");
        String contrasenaingresada = scan.nextLine();

        if (emailingresado.equals(email) && contrasena.equals(contrasenaingresada)) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Login incorrecto");
        }
    }

    void registroUsuario(Scanner scan, String email){

        System.out.println("Ingrese nombre: ");
        String nombreRegistrado = scan.nextLine();

        System.out.println("Ingrese apellido: ");
        String apellidoRegistrado = scan.nextLine();

        System.out.println("Ingrese email: ");
        String emailRegistrado = scan.nextLine();

        System.out.println("Ingrese contraseña: ");
        String contrasenaRegistrada = scan.nextLine();

        System.out.println("Ingrese contraseña nuevamente: ");
        String contrasenaRegistrada2 = scan.nextLine();

        System.out.println("Ingrese país de nacimiento: ");
        String paisdenacimientoRegistrado = scan.nextLine();

        if (contrasenaRegistrada.equals(contrasenaRegistrada2) && !emailRegistrado.equals(email)) {
            System.out.println("Registro de usuario administrador exitoso");
        } else if (emailRegistrado.equals(email)){
            System.out.println("Usuario ya existe");
        } else if (!contrasenaRegistrada.equals(contrasenaRegistrada2)) {
            System.out.println("La contraseña no coincide");
        }
    }
}