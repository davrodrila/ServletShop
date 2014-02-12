package utiles;


import java.sql.*;
import conexiones.Conexiones;

public class util
{
    public static boolean comprobarPermiso(int idusu, String rolreq)
    {
        boolean existe=true;
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sqlcad = "SELECT * FROM usuarios where IDUsuario=" +idusu;
            ResultSet rs = st.executeQuery(sqlcad);
            if (rs.first())
            {
                ResultSet p = st.executeQuery("Select * from roles where IDUsuario="+idusu);
                String permiso = p.getString("Rol");
                if (permiso.equalsIgnoreCase(rolreq) || permiso.equalsIgnoreCase("administrador"))
                {
                    existe = true;
                } else
                {
                    existe = false;
                }
            } else
            {
                existe=false;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador JDBC no encontrado: " + e.toString());
        } catch (SQLException e) {
            System.out.println("Excepcion capturada de SQL: " + e.toString());
        } finally {
            try {
                if (con != null)
                {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("No se puede cerrar la conexion: " + e.toString());
            }
        }
        return existe;
    }
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
}
