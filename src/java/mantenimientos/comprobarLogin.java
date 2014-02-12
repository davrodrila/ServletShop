package mantenimientos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import persistencia.Persistencia;
import objetos.itemCesta;
import objetos.DatosSesion;
import java.sql.*;
import conexiones.Conexiones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.List;

public class comprobarLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        try {
            boolean error=true;
            Class.forName(driver);
            con = DriverManager.getConnection(Conexiones.urlCon, Conexiones.usu, Conexiones.pass);
            Statement st = con.createStatement();
            PrintWriter out = response.getWriter();
            String sqlcad = "SELECT * FROM usuarios where Login='"+request.getParameter("login")+"'";
            ResultSet rs = st.executeQuery(sqlcad);
            if (rs.first())
            {
                if (rs.getString("Pass").equals(request.getParameter("pass")))
                {
                   HttpSession sesion = request.getSession();
                   DatosSesion ds = new DatosSesion (Persistencia.obtenerUsuario(rs.getInt("IDUsuario")),new ArrayList());
                   List<itemCesta> cesta = new ArrayList();
                   sesion.setAttribute("ds",ds);
                   out.println("<h2 style='padding:30px 0 5px 5px;'>¡Bienvenido, "+rs.getString("Nombre")+"!</h2><br />");
                   out.println("<p><a href='index.jsp'>Volver</a></p>");
                   error = true;
                } else
                {
                    error=false;
                    HttpSession sesion = request.getSession();
                    sesion.invalidate();
                }
            } else
            {
                HttpSession sesion = request.getSession();
                sesion.invalidate();
                error=false;
            }
            if (!error)
            {
                out.println("<h2>Error</h2><p>El nombre de usuario o la contraseña no son correctos</p><p><a href='index.jsp'>Volver</a></p>");
            }
            out.println("</body></html>");
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
