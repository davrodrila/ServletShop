/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import objetos.Direccion;
import objetos.Usuario;
import objetos.Plataforma;
import objetos.Juego;
import objetos.juegosPlataforma;
import objetos.Genero;
import conexiones.Conexiones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import objetos.Pedido;
import objetos.itemCesta;

public class Persistencia {

    public static Usuario obtenerUsuario(int IDUsuario) {
        Usuario u = null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM usuarios where IDUsuario=" + IDUsuario;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                u = new Usuario(rs.getInt("IDUsuario"), rs.getString("Login"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getString("DNI"), rs.getString("Email"), rs.getString("Pass"),rs.getString("Rol"));
            } else {
                u = null;
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
        return u;
    }
    public static List<Usuario> listaUsuarios() {
        List<Usuario> u = null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        Usuario aux;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM usuarios";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            u = new ArrayList();
            while (rs.next())
            {
                aux = new Usuario(rs.getInt("IDUsuario"), rs.getString("Login"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getString("DNI"), rs.getString("Email"), rs.getString("Pass"),rs.getString("Rol"));
                u.add(aux);
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
        return u;
    }

    public static Direccion obtenerDireccion(int IDDireccion, int IDUsuario) {
        Direccion d = null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Direcciones where IDUsuario=" + IDUsuario + " and IDDireccion=" + IDDireccion;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                d = new Direccion(rs.getInt("IDDireccion"), rs.getInt("IDUsuario"), rs.getString("Alias"), rs.getString("Dir1"), rs.getString("Dir2"), rs.getString("Localidad"), rs.getString("Provincia"), rs.getString("CP"));
            } else {
                d = null;
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
        return d;
    }
    public static List<Direccion> listaDirecciones(int IDUsuario) {
        List<Direccion> d = null;
        Direccion aux;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Direcciones where IDUsuario=" + IDUsuario;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            d = new ArrayList();
            if (rs.first()) {
                do {
                    aux = new Direccion(rs.getInt("IDDireccion"), rs.getInt("IDUsuario"), rs.getString("Alias"), rs.getString("Dir1"), rs.getString("Dir2"), rs.getString("Localidad"), rs.getString("Provincia"), rs.getString("CP"));
                    d.add(aux);
                } while (rs.next());
            } else {
                d = null;
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
        return d;
    }
    
    public static Plataforma obtenerPlataforma(int IDPlataforma){
        Plataforma p = null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Plataforma where IDPlataforma="+IDPlataforma;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                p = new Plataforma(rs.getInt("IDPlataforma"), rs.getString("Descripcion"), rs.getString("Imagen"));
            } else {
                p = null;
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
        return p;
    }
    public static List<Plataforma> listaPlataformas(){
        List<Plataforma> p = null;
        Plataforma aux;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Plataforma";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            p = new ArrayList();
            if (rs.first()) {
                do {
                    aux = new Plataforma(rs.getInt("IDPlataforma"),rs.getString("Descripcion"),rs.getString("Imagen"));
                    p.add(aux);
                } while (rs.next());
            } else {
                p = null;
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
        return p;
    }

    public static Genero obtenerGenero(int IDGenero){
        Genero g = null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM generos where IDGenero="+IDGenero;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                g = new Genero(rs.getInt("IDGenero"),rs.getString("Descripcion"),rs.getString("Miniatura"));
            } else {
                g = null;
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
        return g;
    }
    public static List<Genero> listaGeneros(){
        List<Genero> g = null;
        Genero aux;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Generos";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            g = new ArrayList();
            if (rs.first()) {
                do {
                    aux = new Genero (rs.getInt("IDGenero"),rs.getString("Descripcion"),rs.getString("Miniatura"));
                    g.add(aux);
                } while (rs.next());
            } else {
                g = null;
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
        return g;
    }

    public static juegosPlataforma obtenerJuegosPlataforma(int IDJuego, int IDPlataforma){
        juegosPlataforma jp = null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM juegos_plataformas where IDJuego=" +IDJuego+ " and IDPlataforma=" +IDPlataforma;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                System.out.println("entra en rsfirst");
                jp = new juegosPlataforma(IDJuego,IDPlataforma);
            } else {
                jp = null;
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
        return jp;
    }
    public static List<juegosPlataforma> listaJuegosPlataforma(int IDJuego){
        List<juegosPlataforma> jp = null;
        juegosPlataforma aux;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM juegos_plataformas where IDJuego=" + IDJuego;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            jp = new ArrayList();
            if (rs.first()) {
                do {
                    aux = new juegosPlataforma(IDJuego,rs.getInt("IDPlataforma"));
                    jp.add(aux);
                } while (rs.next());
            } else {
                jp = null;
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
        return jp;
    }

    public static Juego obtenerJuego(int IDJuego){
        Juego j=null;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Juegos where IDJuego="+IDJuego;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                j = new Juego(rs.getInt("IDJuego"), rs.getString("Nombre"), rs.getFloat("Precio"), rs.getString("FechaLanzamiento"),rs.getString("Fabricante"),obtenerGenero(rs.getInt("Genero")), rs.getBoolean("juegoOnline"), rs.getString("imagenJuego"),rs.getString("Descripcion"), Persistencia.listaJuegosPlataforma(IDJuego));
            } else {
                j = null;
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
        return j;
    }
    public static List<Juego> listaJuegos(){
        List<Juego> jl = null;
        Juego j;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Juegos";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            jl = new ArrayList();
            if (rs.first()) {
                do {
                    j = new Juego(rs.getInt("IDJuego"),rs.getString("Nombre"),rs.getFloat("Precio"),rs.getString("FechaLanzamiento"),rs.getString("Fabricante"),Persistencia.obtenerGenero(rs.getInt("Genero")),rs.getBoolean("juegoOnline"),rs.getString("imagenJuego"),rs.getString("Descripcion"),Persistencia.listaJuegosPlataforma(rs.getInt("IDJuego")));
                    jl.add(j);
                } while (rs.next());
            } else {
                jl = null;
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
        return jl;
    }

    public static Pedido obtenerPedido(int IDPedido){
        Pedido p=null;
        List<itemCesta> lineaspedido;
        itemCesta c;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            Statement s = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Pedidos where IDPedido="+IDPedido;
            ResultSet rs = st.executeQuery(sentenciaSQL);
            ResultSet lineas;
            if (rs.first()) {
                lineaspedido = new ArrayList();
                do {
                    String obtenerlineas = "SELECT * FROM linea_pedido where IDPedido="+IDPedido;
                    lineas = s.executeQuery(obtenerlineas);
                    while (lineas.next())
                    {
                        c = new itemCesta(lineas.getInt("IDJuego"),lineas.getInt("IDPlataforma"),lineas.getInt("Unidades"),lineas.getFloat("Precio"));
                        lineaspedido.add(c);
                    }
                    p = new Pedido(rs.getInt("IDPedido"), Persistencia.obtenerUsuario(rs.getInt("IDUsuario")), rs.getString("FechaPed"), lineaspedido,rs.getInt("IDDireccion"));
                } while (rs.next());
            } else {
                p = null;
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
        return p;
    }
    public static List<Pedido> listaPedidos(){
        List<Pedido> pl = null;
        Pedido p;
        List<itemCesta> lineaspedido;
        itemCesta c;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Pedidos";
            ResultSet lineas;
            pl = new ArrayList();
            lineaspedido = new ArrayList();
            Statement s = con.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);
                while (rs.next()) {
                    String obtenerlineas = "SELECT * FROM linea_pedido where IDPedido="+rs.getInt("IDPedido");
                    lineas = s.executeQuery(obtenerlineas);
                    while (lineas.next())
                    {
                        c = new itemCesta(lineas.getInt("IDJuego"),lineas.getInt("IDPlataforma"),lineas.getInt("Unidades"),lineas.getFloat("Precio"));
                        lineaspedido.add(c);
                    }
                    p = new Pedido(rs.getInt("IDPedido"), Persistencia.obtenerUsuario(rs.getInt("IDUsuario")), rs.getString("FechaPed"), lineaspedido,rs.getInt("IDDireccion"));
                    pl.add(p);
                }
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador JDBC no encontrado: " + e.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("No se puede cerrar la conexion: " + e.toString());
            }
        }
        return pl;
    }
    
    public static boolean comprobarLogin(String nuevoLogin) {
        boolean estaLibre = true;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "Select * from usuarios where Login='" + nuevoLogin + "'";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                estaLibre = true;
            } else {
                estaLibre = false;
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
        return estaLibre;
    }
    public static boolean comprobarPass(Usuario u) {
        boolean esCorrecta = false;
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "Select * from usuarios where IDUsuario=" + u.getIDUsuario();
            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first()) {
                if (u.getPass().equals(rs.getString("Pass"))) {
                    System.out.println("Devolerá true en la pass. Es correcta");
                    esCorrecta = true;
                } else {
                    System.out.println("La pass no es correcta");
                    esCorrecta = false;
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
        return esCorrecta;
    }

}
