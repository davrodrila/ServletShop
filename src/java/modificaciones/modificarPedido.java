package modificaciones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import conexiones.Conexiones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NOCTURO
 */
public class modificarPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
                    PrintWriter out = response.getWriter();
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
            rd.include(request, response);
            out.println("<h2 style='padding:30px 0 5px 5px;'>Modificacion de Pedido</h2><br />");
            response.setContentType("text/html");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL = "SELECT * FROM Pedidos where IDPedido=" + request.getParameter("id");

            ResultSet rs = st.executeQuery(sentenciaSQL);
            if (rs.first())
            {
                out.println("<table><form method='post' action='accionModificarPedido'>");
                ResultSet usu = st.executeQuery("SELECT * from usuarios where IDUsuario="+rs.getString("IDUsuario"));
                out.println("<tr><td>"+usu.getString("Nombre") + " " + usu.getString("Apellidos")+", DNI: "+usu.getString("DNI")+"</td>");
                out.println("<td>Fecha del pedido: "+rs.getString("FechaPed")+"</td>");
                out.println("</table><h2>Lineas del pedido </h2>");
                out.println("<table><tr><th>Nº Linea</th><th>Producto</th><th>Plataforma</th><th>Precio</th><th>Unidades</th>");
                ResultSet lineas = st.executeQuery("SELECT * FROM linea_pedido where IDPedido="+request.getParameter("id")+" ORDER BY linea_pedido DESC");
                while (lineas.next())
                {
                    out.println("<tr><td>"+lineas.getString("Linea")+"</td>");
                    ResultSet nj = st.executeQuery("SELECT * From juegos where IDJuego="+lineas.getString("IDJuego"));
                    out.println("<td>"+nj.getString("Nombre")+"</td>");
                    ResultSet np = st.executeQuery("SELECT * FROM Plataforma where IDPlataforma="+lineas.getString("IDPlataforma"));
                    out.println("<td>"+np.getString("Descripcion")+"</td>");
                    out.println("<td>"+lineas.getString("Precio")+"</td>");
                    out.println("<td>"+lineas.getString("Unidades")+"</td>");
                }
            } else
            {
                out.println("ID de pedido incorrecto. ");
            }
        } catch (ClassNotFoundException e)
        {
            System.out.println("Controlador JDBC no encontrado: " + e.toString());
        } catch (SQLException e)
        {
            System.out.println("Excepcion capturada de SQL: " + e.toString());
        } finally
        {
            try {
                if (con != null)
                {
                    con.close();
                }
            } catch (SQLException e)
            {
                System.out.println("No se puede cerrar la conexion: " + e.toString());
            }
        }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    }
}
