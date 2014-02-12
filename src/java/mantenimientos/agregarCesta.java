package mantenimientos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import objetos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author NOCTURO
 */
public class agregarCesta extends HttpServlet {
   
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
        boolean added=false;
        if (ds!=null)
        {
                List<itemCesta> icl = ds.getCesta();
                if (icl!=null)
                {
                    itemCesta ic =(itemCesta)getServletContext().getAttribute("item");
                    itemCesta aux;
                    if (icl.contains(ic))
                    {
                        int ind = icl.indexOf(ic);
                        aux = icl.get(ind);
                        ic.setCantidad(ic.getCantidad()+aux.getCantidad());
                        icl.remove(aux);
                        icl.add(ic);
                        added=true;
                    }
                    if (!added)
                    {
                        icl.add(ic);
                        added=true;
                    }
                    if (added)
                    {
                        out.println("<p>Elemento añadido a la cesta</p>");
                        out.println("<a href='catalogo.jsp' >Volver al catalogo </a>");
                        ds.setCesta(icl);
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
