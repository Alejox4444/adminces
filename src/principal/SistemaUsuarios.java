package principal;

import java.util.Arrays;
import java.util.Scanner;

public class SistemaUsuarios {

    private Usuario[] usuarios = new Usuario[10];
    private int cantidad = 0;

    public SistemaUsuarios() {
        usuarios[cantidad++] = new Administrador("Yanis", "Correa", "Uruguay",
                "yaniscorrea@gmail.com", "12345");
        usuarios[cantidad++] = new Administrador("Leonardo", "Perez", "Uruguay",
                "leonardoperez@gmail.com", "12345");
        usuarios[cantidad++] = new Tester("Nahuel", "Torena", "Uruguay",
                "nahuel@gmail.com", "12345", "Tester Senior");
        usuarios[cantidad++] = new Tester("Dardo", "Deleon", "Uruguay",
                "dardo@gmail.com", "12345", "Tester Lider");
    }

    public boolean existeEmail(String email) {
        for (int i = 0; i < cantidad; i++) {
            if (usuarios[i].getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscarPorEmail(String email) {
        for (int i = 0; i < cantidad; i++) {
            if (usuarios[i].getEmail().equalsIgnoreCase(email)) {
                return usuarios[i];
            }
        }
        return usuarios[0];
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
            Usuario u = buscarPorEmail(emailIngresado);
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

        Usuario nuevo = null;
        boolean usuarioValido = true;

        while (usuarioValido) {
            System.out.print("Tipo de usuario (1 = Administrador, 2 = Tester): ");
            String tipo = scan.nextLine();

            switch (tipo) {
                case "1" -> {
                    nuevo = new Administrador(nombre, apellido, pais, email, contrasena);
                    usuarioValido = false;
                }
                case "2" -> {
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
                    nuevo = new Tester(nombre, apellido, pais, email, contrasena, nivelTester);
                    usuarioValido = false;
                }
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        usuarios[cantidad++] = nuevo;
        System.out.println("Usuario registrado exitosamente");
    }

    public void listarUsuarios() {
        System.out.println("\nUsuarios registrados:");
        Usuario[] cargados = Arrays.copyOf(usuarios, cantidad);
        for (Usuario u : cargados) {
            if (u.getTipo().equals("Administrador")) {
                System.out.println("[" + u.getTipo() + "] " + u.getNombre() + " " + u.getApellido() + " <" + u.getEmail() + ">");
            }else{
                System.out.println("[" + u.getNivelTester() + "] " + u.getNombre() + " " + u.getApellido() + " <" + u.getEmail() + ">");
            }
        }
    }

    public static void main(String[] args) {
        SistemaUsuarios sistema = new SistemaUsuarios();
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSistema de Usuarios");
            System.out.println("1. Login");
            System.out.println("2. Registrarse");
            System.out.println("3. Listar usuarios");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            String opcion = scan.nextLine();

            switch (opcion) {
                case "1" -> sistema.login(scan);
                case "2" -> sistema.registrarUsuario(scan);
                case "3" -> sistema.listarUsuarios();
                case "4" -> continuar = false;
                default  -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("¡Hasta luego!");
        scan.close();
    }
}