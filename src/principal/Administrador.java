package principal;

public class Administrador extends Usuario {

    public Administrador(String nombre, String apellido, String paisDeNacimiento,
                         String email, String contrasena) {
        super(nombre, apellido, paisDeNacimiento, email, contrasena);
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}