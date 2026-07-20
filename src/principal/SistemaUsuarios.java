package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaUsuarios {

    private String PATRON_EMAIL = "^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$";
    private int LONGITUD_MINIMA_CONTRASENA = 5;

    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioActual;

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

    public Usuario buscarPorEmail(String email) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        throw new UsuarioNoEncontradoException("No existe un usuario con el email: " + email);
    }

    public void login(Scanner scan) {
        String emailIngresado = leerCampoObligatorio(scan, "Ingrese email: ", "email");
        String contrasenaIngresada = leerCampoObligatorio(scan, "Ingrese contraseña: ", "contraseña");

        try {
            Usuario u = buscarPorEmail(emailIngresado);
            if (!u.getContrasena().equals(contrasenaIngresada) || !(u instanceof Administrador)) {
                System.out.println("Email o contraseña incorrectos.");
            } else {
                usuarioActual = u;
                System.out.println("Login exitoso. Bienvenido/a " + u.getNombre() + " (" + u.getTipo() + ")");
            }
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Email o contraseña incorrectos.");
        }
    }

    public boolean esAdministradorLogueado() {
        return usuarioActual instanceof Administrador;
    }

    public void cerrarSesion() {
        usuarioActual = null;
        System.out.println("Sesión cerrada.");
    }

    private String leerCampoObligatorio(Scanner scan, String etiqueta, String nombreCampo) {
        while (true) {
            System.out.print(etiqueta);
            String valor = scan.nextLine();
            try {
                validarCampoObligatorio(valor, nombreCampo);
                return valor;
            } catch (DatosInvalidosException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void registrarAdministrador(Scanner scan) {
        String[] datos = leerDatosRegistro(scan);
        if (datos == null) {
            return;
        }
        usuarios.add(new Administrador(datos[0], datos[1], datos[2], datos[3], datos[4]));
        System.out.println("Administrador registrado exitosamente");
    }

    public void altaUsuarioTester(Scanner scan) {
        String[] datos = leerDatosRegistro(scan);
        if (datos == null) {
            return;
        }
        String nivelTester = elegirNivelTester(scan);
        usuarios.add(new Tester(datos[0], datos[1], datos[2], datos[3], datos[4], nivelTester));
        System.out.println("Tester registrado exitosamente");
    }

    private String[] leerDatosRegistro(Scanner scan) {
        String nombre = leerCampoObligatorio(scan, "Ingrese nombre: ", "nombre");
        String apellido = leerCampoObligatorio(scan, "Ingrese apellido: ", "apellido");
        String pais = leerCampoObligatorio(scan, "Ingrese país de nacimiento: ", "país de nacimiento");
        String email = leerEmailParaRegistro(scan);
        String contrasena = leerContrasenaParaRegistro(scan);

        System.out.print("Repita la contraseña: ");
        String contrasena2 = scan.nextLine();

        if (!contrasena.equals(contrasena2)) {
            System.out.println("Las contraseñas no coinciden.");
            return null;
        }

        return new String[]{nombre, apellido, pais, email, contrasena};
    }

    private String leerEmailParaRegistro(Scanner scan) {
        while (true) {
            String email = leerCampoObligatorio(scan, "Ingrese email: ", "email");
            if (!email.matches(PATRON_EMAIL)) {
                System.out.println("Error: el email no tiene un formato válido.");
                continue;
            }
            try {
                validarEmailNoDuplicado(email);
                return email;
            } catch (EmailDuplicadoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void validarEmailNoDuplicado(String email) throws EmailDuplicadoException {
        if (existeEmail(email)) {
            throw new EmailDuplicadoException("Ya existe un usuario con ese email.");
        }
    }

    private String leerContrasenaParaRegistro(Scanner scan) {
        while (true) {
            String contrasena = leerCampoObligatorio(scan, "Ingrese contraseña: ", "contraseña");
            if (contrasena.length() < LONGITUD_MINIMA_CONTRASENA) {
                System.out.println("Error: la contraseña debe tener al menos "
                        + LONGITUD_MINIMA_CONTRASENA + " caracteres.");
                continue;
            }
            return contrasena;
        }
    }

    private void validarCampoObligatorio(String valor, String nombreCampo) throws DatosInvalidosException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new DatosInvalidosException("El campo '" + nombreCampo + "' no puede estar vacío.");
        }
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
        if (!esAdministradorLogueado()) {
            System.out.println("Error: debe iniciar sesión como Administrador para listar usuarios.");
            return;
        }

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
        if (!esAdministradorLogueado()) {
            System.out.println("Error: debe iniciar sesión como Administrador para buscar usuarios.");
            return;
        }

        System.out.print("Ingrese el email del usuario a buscar: ");
        String email = scan.nextLine();

        try {
            Usuario u = buscarPorEmail(email);
            System.out.println("\nUsuario encontrado:");
            System.out.println(u.mostrarInfo());
            System.out.println("País de nacimiento: " + u.getPaisDeNacimiento());
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
