package principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaUsuarios sistema = new SistemaUsuarios();
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSistema de Usuarios");
            System.out.println("1. Login");
            System.out.println("2. Registrarse");
            System.out.println("3. Listar usuarios");
            System.out.println("4. Buscar usuario");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            String opcion = scan.nextLine();

            switch (opcion) {
                case "1" -> sistema.login(scan);
                case "2" -> sistema.registrarUsuario(scan);
                case "3" -> sistema.listarUsuarios();
                case "4" -> sistema.buscarUsuario(scan);
                case "5" -> continuar = false;
                default  -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("¡Hasta luego!");
        scan.close();
    }
}
