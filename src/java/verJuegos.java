/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class verJuegos extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/tienda";
        Connection con=null;
        try
        {
            Class.forName(driver);
            con=DriverManager.getConnection(url,"root","123456");
            Statement st = con.createStatement();
            String sentenciaSQL="SELECT * FROM JUEGOS";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html><head><title>Listado de juegos</title></head>");
            out.println("<body><table><h1>Listado de juegos</h1><tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Fecha Lanzamiento</th>");
            out.println("<th>Fabricante</th><th>Genero</th><th>juego Online?</th><th>Imagen Juego</th></tr>");
            while (rs.next())
            {
                out.println("<tr>");
                out.println("<td>" + rs.getString("IDJuego") + "</td>");
                out.println("<td>" + rs.getString("Nombre") + "</td>");
                out.println("<td>" + rs.getString("Precio") + "</td>");
                out.println("<td>" + rs.getString("FechaLanzamiento") + "</td>");
                out.println("<td>" + rs.getString("Fabricante") + "</td>");
                out.println("<td>" + rs.getString("Genero") + "</td>");
                out.println("<td>" + rs.getString("juegoOnline") + "</td>");
                out.println("<td>" + rs.getString("imagenJuego") + "</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
        }catch(ClassNotFoundException e)
        {
            System.out.println("Controlador JDBC no encontrado: "+e.toString());
        }catch(SQLException e)
        {
            System.out.println("Excepcion capturada de SQL: "+e.toString());
        }finally
        {
            try
            {
                if(con!=null)
                    con.close();
            }catch(SQLException e)
            {
                System.out.println("No se puede cerrar la conexion: "+e.toString());
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
