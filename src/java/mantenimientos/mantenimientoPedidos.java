package mantenimientos;

//TODO: Vincular CSS
//TODO: Mantenimiento de pedidos y sus lineas

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
public class mantenimientoPedidos extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String driver="com.mysql.jdbc.Driver";
        Connection con=null;
            PrintWriter out = response.getWriter();
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
            rd.include(request, response);
            out.println("<h2 style='padding:30px 0 5px 5px;'>Modificacion de Pedido</h2>");
            response.setContentType("text/html");
            try
            {
            Class.forName(driver);
            con=DriverManager.getConnection(Conexiones.urlCon,Conexiones.usu,Conexiones.pass);
            Statement st = con.createStatement();
            String sentenciaSQL="SELECT * FROM pedidos";
            ResultSet rs = st.executeQuery(sentenciaSQL);
            out.println("<table>");
            while (rs.next())
            {
                out.println("<tr>");
                out.println("<td>" + rs.getString("IDPedido") + "</td>");
                ResultSet usu = st.executeQuery("SELECT * from usuarios where IDUsuario="+rs.getString("IDUsuario"));
                String cad = usu.getString("Nombre") + " " + usu.getString("Apellidos");
                out.println("<td>"+cad+ "</td>");
                out.println("<td>" + rs.getString("FechaPed") + "</td>");
                out.println("<td><a href=modificarPedido?id="+rs.getString("IDPedido")+ ">Modificar</a></td>");
                out.println("<td><a href=borrarPedido?id="+rs.getString("IDPedido")+ ">Borrar</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
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
                {
                    con.close();
                }
            }catch(SQLException e)
            {
                System.out.println("No se puede cerrar la conexion: "+e.toString());
            }
        }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
