package principal;

public class Tester extends Usuario {

    private String nivelTester;

    public Tester(String nombre, String apellido, String paisDeNacimiento,
                  String email, String contrasena, String nivelTester) {
        super(nombre, apellido, paisDeNacimiento, email, contrasena);
        this.nivelTester = nivelTester;
    }

    public String getNivelTester() { return nivelTester; }
    public void setNivelTester(String nivelTester) { this.nivelTester = nivelTester; }

    @Override
    public String getTipo() {
        return "Tester";
    }

    @Override
    public String mostrarInfo() {
        return "[" + getNivelTester() + "] " + getNombre() + " " + getApellido() + " <" + getEmail() + ">";
    }
}