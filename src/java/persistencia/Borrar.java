/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import objetos.*;
import conexiones.Conexiones;
import java.sql.*;

/**
 *
 * @author NOCTURO
 */
public class Borrar {

    public static boolean Borrar(Usuario u) {
        boolean exitoBorrando = false;
        if (u != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                String sentenciaSQL = "DELETE FROM Usuarios where IDUsuario=" + u.getIDUsuario();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                }
                if (BorrarDirecciones(u))
                {
                    exitoBorrando = true;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
    public static boolean Borrar(Direccion d){
        boolean exitoBorrando=false;
        if (d != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                System.out.println(d.getIDUsuario());
                System.out.println(d.getIDDireccion());
                String sentenciaSQL = "DELETE FROM Direcciones where IDUsuario=" + d.getIDUsuario()+ " and IDDireccion=" +d.getIDDireccion();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                    System.out.println("ejecutada sentencia de borrado");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
    public static boolean BorrarDirecciones(Usuario u){
        int id = u.getIDUsuario();
        boolean exitoBorrando=false;
            if (u != null) {
                String driver = "com.mysql.jdbc.Driver";
                Connection con = null;
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                    Statement st = con.createStatement();
                    String sentenciaSQL = "DELETE FROM Direcciones where IDUsuario=" + u.getIDUsuario();
                    if (st.executeUpdate(sentenciaSQL) == 1) {
                        exitoBorrando = true;
                    }
                    if (BorrarDirecciones(u))
                    {
                        exitoBorrando = true;
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Controlador JDBC no encontrado: " + e.toString());
                } catch (SQLException e) {
                    System.out.println("Excepcion capturada de SQL: " + e.toString());
                } finally {
                    try {
                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException e) {
                        System.out.println("No se puede cerrar la conexion: " + e.toString());
                    }
                }
                } else {
                    exitoBorrando = false;
                }
            return exitoBorrando;
    }
    public static boolean Borrar(Plataforma p) {
        boolean exitoBorrando = false;
        if (p != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                String sentenciaSQL = "DELETE FROM Plataforma where IDPlataforma=" + p.getIDPlataforma();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                    if (borrarPlataforma(p))
                    {
                        exitoBorrando = false;
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
    public static boolean borrarPlataforma(Plataforma p){
         boolean exitoBorrando = false;
        if (p != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                String sentenciaSQL = "DELETE FROM juegos_plataformas where IDPlataforma=" + p.getIDPlataforma();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
    public static boolean Borrar(Genero g){
        boolean exitoBorrando = false;
        if (g != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                String sentenciaSQL = "DELETE FROM Generos where IDGenero=" + g.getIDGenero();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
    public static boolean Borrar(Juego j){
        boolean exitoBorrando = false;
        if (j != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                String sentenciaSQL = "DELETE FROM Juegos where IDJuego=" + j.getIDJuego();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
    public static boolean Borrar(juegosPlataforma jp){
        boolean exitoBorrando = false;
        if (jp != null) {
            String driver = "com.mysql.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
                Statement st = con.createStatement();
                String sentenciaSQL = "DELETE FROM juegos_plataformas where IDJuego=" + jp.getIDJuego();
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoBorrando = true;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Controlador JDBC no encontrado: " + e.toString());
            } catch (SQLException e) {
                System.out.println("Excepcion capturada de SQL: " + e.toString());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("No se puede cerrar la conexion: " + e.toString());
                }
            }
        } else {
            exitoBorrando = false;
        }
        return exitoBorrando;
    }
}
