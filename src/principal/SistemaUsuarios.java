package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaUsuarios {

    private List<Usuario> usuarios = new ArrayList<>();

    public SistemaUsuarios() {
        usuarios.add(new Administrador("Yanis", "Correa", "Uruguay",
                "yaniscorrea@gmail.com", "12345"));
        usuarios.add(new Administrador("Leonardo", "Perez", "Uruguay",
                "leonardoperez@gmail.com", "12345"));
        usuarios.add(new Tester("Nahuel", "Torena", "Uruguay",
                "nahuel@gmail.com", "12345", "Tester Senior"));
        usuarios.add(new Tester("Dardo", "Deleon", "Uruguay",
                "dardo@gmail.com", "12345", "Tester Lider"));
    }

    public boolean existeEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return usuarios.get(0);
    }

    public boolean validarCredenciales(String email, String contrasena) {
        if (!existeEmail(email)) {
            return false;
        }
        Usuario u = buscarPorEmail(email);
        return u.getContrasena().equals(contrasena);
    }

    public void login(Scanner scan) {
        System.out.print("Ingrese email: ");
        String emailIngresado = scan.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contrasenaIngresada = scan.nextLine();

        if (validarCredenciales(emailIngresado, contrasenaIngresada)) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }
    }

    public void registrarUsuario(Scanner scan) {
        System.out.print("Ingrese nombre: ");
        String nombre = scan.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = scan.nextLine();

        System.out.print("Ingrese país de nacimiento: ");
        String pais = scan.nextLine();

        System.out.print("Ingrese email: ");
        String email = scan.nextLine();

        if (existeEmail(email)) {
            System.out.println("Ya existe un usuario con ese email.");
            return;
        }

        System.out.print("Ingrese contraseña: ");
        String contrasena = scan.nextLine();

        System.out.print("Repita la contraseña: ");
        String contrasena2 = scan.nextLine();

        if (!contrasena.equals(contrasena2)) {
            System.out.println("Las contraseñas no coinciden.");
            return;
        }

        boolean usuarioValido = true;

        while (usuarioValido) {
            System.out.print("Tipo de usuario (1 = Administrador, 2 = Tester): ");
            String tipo = scan.nextLine();

            switch (tipo) {
                case "1" -> {
                    usuarios.add(new Administrador(nombre, apellido, pais, email, contrasena));
                    usuarioValido = false;
                }
                case "2" -> {
                    String nivelTester = elegirNivelTester(scan);
                    usuarios.add(new Tester(nombre, apellido, pais, email, contrasena, nivelTester));
                    usuarioValido = false;
                }
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        System.out.println("Usuario registrado exitosamente");
    }

    private String elegirNivelTester(Scanner scan) {
        boolean nivelValido = true;
        String nivelTester = "";
        while (nivelValido) {
            System.out.println("Nivel del tester:");
            System.out.println("  1. Tester Junior");
            System.out.println("  2. Tester Senior");
            System.out.println("  3. Tester Líder");
            System.out.print("Opción: ");
            String opcionTester = scan.nextLine();

            switch (opcionTester) {
                case "1" -> { nivelTester = "Tester Junior"; nivelValido = false; }
                case "2" -> { nivelTester = "Tester Senior"; nivelValido = false; }
                case "3" -> { nivelTester = "Tester Líder";  nivelValido = false; }
                default  -> System.out.println("Opción no válida, intente nuevamente.");
            }
        }
        return nivelTester;
    }

    public void listarUsuarios() {
        System.out.println("\nUsuarios registrados:");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u.mostrarInfo());
        }
    }

    public void buscarUsuario(Scanner scan) {
        System.out.print("Ingrese el email del usuario a buscar: ");
        String email = scan.nextLine();

        if (!existeEmail(email)) {
            System.out.println("No se encontró ningún usuario con ese email.");
        } else {
            Usuario u = buscarPorEmail(email);
            System.out.println("\nUsuario encontrado:");
            System.out.println(u.mostrarInfo());
            System.out.println("País de nacimiento: " + u.getPaisDeNacimiento());
        }
    }
}
