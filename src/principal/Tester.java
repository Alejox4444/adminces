package principal;

public class Tester extends Usuario {

    private String nivelTester;

    public Tester(String nombre, String apellido, String paisDeNacimiento,
                  String email, String contrasena, String nivelTester) {
        super(nombre, apellido, paisDeNacimiento, email, contrasena);
        this.nivelTester = nivelTester;
    }
    @Override
    public String getNivelTester() { return nivelTester; }
    public String getTipo() {
        return "Tester";
    }
}