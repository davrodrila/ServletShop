package persistencia;

import com.sun.crypto.provider.RSACipher;
import objetos.Plataforma;
import objetos.Direccion;
import objetos.Usuario;
import objetos.Genero;
import objetos.Juego;
import java.util.Iterator;
import java.util.List;
import conexiones.Conexiones;
import java.sql.*;
import objetos.Pedido;
import objetos.itemCesta;
import objetos.juegosPlataforma;

public class Insertar {
    public static boolean insertar(Direccion d){
        boolean exitoInsertar = false;
        if (d!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "INSERT INTO Direcciones(IDUsuario, Alias, Dir1,Dir2, Localidad, Provincia, CP) VALUES ('"+d.getIDUsuario()+"','"+d.getAlias()+"','"+d.getDir1()+"','"+d.getDir2()+"','"+d.getLocalidad()+"','"+d.getProvincia()+"','"+d.getCP()+"')";
            if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoInsertar = true;
            } else
            {
                exitoInsertar = false;
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
        }}
        return exitoInsertar;
    }
    public static boolean insertar(Usuario u) {
        boolean exitoInsertar = false;
        if (u!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            System.out.println(u.getRol());
            String sentenciaSQL = "INSERT INTO Usuarios(Login,Nombre,Apellidos,DNI,Email,Pass,Rol) VALUES ('" + u.getLogin() + "','" + u.getNombre() + "','" + u.getApellidos() + "','" + u.getDNI() + "','" + u.getEmail() + "','" + u.getPass() + "','"+u.getRol()+"')";
            if (!Persistencia.comprobarLogin(u.getLogin())) {
                if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoInsertar = true;
                }
            } else
            {
                exitoInsertar = false;
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
        }}
        return exitoInsertar;
    }
    public static boolean insertar(Plataforma p){
        boolean exitoInsertar = false;
        if (p!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "INSERT INTO Plataforma(Descripcion, Imagen) VALUES ('"+p.getDescripcion()+"','"+p.getImagen()+"')";
            if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoInsertar = true;
            } else
            {
                exitoInsertar = false;
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
        }}
        return exitoInsertar;
    }
    public static boolean insertar(Genero g){
        boolean exitoInsertar = false;
        if (g!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "INSERT INTO Generos(Descripcion, Miniatura) VALUES ('"+g.getNombre()+"','"+g.getImagen()+"')";
            if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoInsertar = true;
            } else
            {
                exitoInsertar = false;
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
        }}
        return exitoInsertar;
    }
    public static boolean insertar(Juego j){
        boolean exitoInsertar = false;
        if (j!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "INSERT INTO JUEGOS (Nombre,Precio,FechaLanzamiento,Fabricante,Genero,juegoOnline,imagenJuego,Descripcion) "
                    + "VALUES ('" +j.getNombre()+ "',"+j.getPrecio()+",'" +j.getFechaLanzamiento()+ "','"+j.getFabricante()+"',"+j.getGenero().getIDGenero()+","+j.isJuegoOnline()+",'"+j.getImagen()+"','"+j.getDescripcion()+"')";
            if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoInsertar = true;
            } else
            {
                exitoInsertar = false;
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
        }}
        return exitoInsertar;
    }
    public static boolean insertar(juegosPlataforma jp){
     boolean exitoInsertar = false;
        if (jp!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "INSERT INTO juegos_plataformas (IDJuego,IDPlataforma) VALUES("+jp.getIDJuego()+","+jp.getIDPlataforma()+")";
            if (st.executeUpdate(sentenciaSQL) == 1) {
                    exitoInsertar = true;
            } else
            {
                exitoInsertar = false;
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
        }}
        return exitoInsertar;
    }
    public static boolean insertar(Pedido p){
        boolean exitoInsertar = false;
        if (p!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL="INSERT INTO pedidos (IDUsuario,FechaPed,IDDireccion) VALUES("+p.getUsuario().getIDUsuario()+",'"+p.getFechaPedido()+"',"+p.getIDDireccion()+")";
            st.executeUpdate(sentenciaSQL);
            String cons="SELECT MAX(IDPedido) from pedidos";
            ResultSet idped = st.executeQuery(cons);
            int idp=0;
            if (idped.first()){
                idp = idped.getInt(1);
                int numlinea=0;
                    exitoInsertar = true;
                    List<itemCesta> cesta = p.getLineasPedido();
                    itemCesta ic;
                    Iterator<itemCesta> i = cesta.iterator();
                    while (i.hasNext()) {
                        ic = i.next();
                        sentenciaSQL = "INSERT INTO linea_pedido (IDPedido,Linea,IDJuego,IDPlataforma,Precio,Unidades) VALUES("+idp+","+numlinea+","+ic.getIdjuego()+","+ic.getIdplataforma()+","+ic.getPrecio()+","+ic.getCantidad()+")";
                        st.executeUpdate(sentenciaSQL);
                        numlinea++;
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
        }}
        return exitoInsertar;
    }

    public static boolean actualizar(Usuario u) {
        boolean actualizacionExito = false;
        if (u!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "UPDATE usuarios set Login='" + u.getLogin() + "',Nombre='" + u.getNombre() + "',Apellidos='" + u.getApellidos() + "',DNI='" + u.getDNI() + "',Email='" + u.getEmail() + "',Pass='" + u.getPass() + "',Rol='"+u.getRol()+"' where IDUsuario=" + u.getIDUsuario();
            if (st.executeUpdate(sentenciaSQL) == 1) {
                actualizacionExito = true;
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
        }}
        return actualizacionExito;
    }
    public static boolean actualizar(Direccion d) {
        boolean actualizacionExito = false;
        if (d!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "UPDATE Direcciones set Alias='" + d.getAlias() + "', Dir1='" + d.getDir1() + "', Dir2='" + d.getDir2() + "', Localidad='" + d.getLocalidad() + "',Provincia='" + d.getProvincia() + "', CP='" + d.getCP() + "' where IDUsuario=" + d.getIDUsuario() + " and IDDireccion=" + d.getIDDireccion();
            if (st.executeUpdate(sentenciaSQL) == 1) {
                actualizacionExito = true;
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
        }}
        return actualizacionExito;
    }
    public static boolean actualizar(Plataforma p){
        boolean actualizacionExito = false;
        if (p!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "UPDATE Plataforma set Descripcion='" + p.getDescripcion() + "', Imagen='" + p.getImagen() + "' where IDPlataforma="+p.getIDPlataforma();
            if (st.executeUpdate(sentenciaSQL) == 1) {
                actualizacionExito = true;
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
        }}
        return actualizacionExito;
    }
    public static boolean actualizar(Genero g){
        boolean actualizacionExito = false;
        if (g!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "UPDATE Generos set Descripcion='" + g.getNombre() + "', Miniatura='" + g.getImagen() + "' where IDGenero="+g.getIDGenero();
            if (st.executeUpdate(sentenciaSQL) == 1) {
                actualizacionExito = true;
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
        }}
        return actualizacionExito;
    }
    public static boolean actualizar(Juego j){
        boolean actualizacionExito = false;
        if (j!=null){
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "UPDATE Juegos set Nombre='" + j.getNombre()+ "', Precio='" + j.getPrecio() + "', Genero='" + j.getGenero().getIDGenero() + "',Descripcion='" + j.getDescripcion() + "',FechaLanzamiento='"+j.getFechaLanzamiento() + "', Fabricante='" + j.getFabricante() + "', imagenJuego='"+j.getFabricante()+"' where IDJuego="+j.getIDJuego();
            if (st.executeUpdate(sentenciaSQL) == 1) {
                actualizacionExito = true;
            }
            String borrar = "DELETE FROM juegos_plataformas where IDJuego=" + j.getIDJuego();
            st.executeUpdate(borrar);
            List<juegosPlataforma> platcrear = j.getPlataformasDisponibles();
            Iterator<juegosPlataforma> i = platcrear.iterator();
            while (i.hasNext())
            {
                Insertar.insertar(i.next());
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
        }}
        return actualizacionExito;
    }

}
