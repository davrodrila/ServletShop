/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bajas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
import persistencia.*;
import utiles.*;
import objetos.*;
import presentacion.*;

public class bajaUsuario extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Baja de Usuarios</h2><br />");
        if (util.isNumeric(request.getParameter("id"))) {

            int id = Integer.parseInt(request.getParameter("id"));

            out.println(id);
            System.out.println(id);
            Usuario u = Persistencia.obtenerUsuario(id);
            if (Borrar.Borrar(u)) {
                Presentacion.exitoBorrar(response.getWriter());
            } else {
                Errores.evaluarError(response.getWriter(), Errores.error.error_borrando);
            }
        } else {
            Errores.evaluarError(response.getWriter(), Errores.error.ID_Invalido);
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
