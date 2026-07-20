package principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaUsuarios sistema = new SistemaUsuarios();
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            boolean esAdmin = sistema.esAdministradorLogueado();

            System.out.println("\nSistema de Usuarios");
            if (esAdmin) {
                System.out.println("1. Listar usuarios");
                System.out.println("2. Buscar usuario");
                System.out.println("3. Dar de alta usuario Tester");
                System.out.println("4. Cerrar sesión");
                System.out.println("5. Salir");
            } else {
                System.out.println("1. Login");
                System.out.println("2. Registrar usuario administrador");
                System.out.println("3. Salir");
            }
            System.out.print("Opción: ");
            String opcion = scan.nextLine();

            try {
                if (esAdmin) {
                    switch (opcion) {
                        case "1" -> sistema.listarUsuarios();
                        case "2" -> sistema.buscarUsuario(scan);
                        case "3" -> sistema.altaUsuarioTester(scan);
                        case "4" -> sistema.cerrarSesion();
                        case "5" -> continuar = false;
                        default  -> System.out.println("Opción no válida.");
                    }
                } else {
                    switch (opcion) {
                        case "1" -> sistema.login(scan);
                        case "2" -> sistema.registrarAdministrador(scan);
                        case "3" -> continuar = false;
                        default  -> System.out.println("Opción no válida.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }

        System.out.println("¡Hasta luego!");
        scan.close();
    }
}
