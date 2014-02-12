package objetos;

public class Usuario
{
    private int IDUsuario;
    private String Login;
    private String Nombre;
    private String Apellidos;
    private String DNI;
    private String Email;
    private String pass;
    private String rol;

    public Usuario()
    {
        super();
    }

    public Usuario(int IDUsuario, String Login, String Nombre, String Apellidos, String DNI, String Email, String pass, String rol) {
        this.IDUsuario = IDUsuario;
        this.Login = Login;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.DNI = DNI;
        this.Email = Email;
        this.pass = pass;
        this.rol = rol;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
            this.Apellidos = Apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
            this.DNI = DNI;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo()
    {
        return "Usuario";
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        if (rol.equalsIgnoreCase("administrador")|| rol.equalsIgnoreCase("usuario"))
                this.rol = rol;
    }
}
