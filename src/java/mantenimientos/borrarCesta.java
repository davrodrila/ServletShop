/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetos.DatosSesion;
import objetos.itemCesta;

/**
 *
 * @author David
 */
public class borrarCesta extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Cesta</h2><br />");
        HttpSession sesion = request.getSession();
        DatosSesion ds = (DatosSesion) sesion.getAttribute("ds");
        boolean borrado = false;
        if (ds != null) {
            List<itemCesta> icl = ds.getCesta();
            if (icl != null) {
                Iterator<itemCesta> i = icl.iterator();
                itemCesta aux;
                itemCesta ic = (itemCesta) getServletContext().getAttribute("item");
                while (i.hasNext()) {
                    System.out.println("dentro del iterator");
                    aux = i.next();
                    if (ic.getIdjuego()==aux.getIdjuego() && ic.getIdplataforma()== ic.getIdplataforma()) {
                        System.out.println("iguales");
                        i.remove();
                        ds.setCesta(icl);
                        out.println("<p>Borrado con exito.");
                        out.println("<a href='catalogo.jsp'>Volver</a>");
                        borrado = true;
                    }
                }
                if (!borrado) {
                    out.println("<p>Error borrando.");
                    out.println("<a href='catalogo.jsp'>Volver</a>");
                }
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
