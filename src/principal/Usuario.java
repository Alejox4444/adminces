package principal;

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String paisDeNacimiento;
    private String email;
    private String contrasena;

    public Usuario(String nombre, String apellido, String paisDeNacimiento,
                   String email, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.paisDeNacimiento = paisDeNacimiento;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getPaisDeNacimiento() { return paisDeNacimiento; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setPaisDeNacimiento(String pais) { this.paisDeNacimiento = pais; }
    public void setEmail(String email) { this.email = email; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public abstract String getTipo();
    public abstract String mostrarInfo();
}