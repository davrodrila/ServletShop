/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetos.DatosSesion;
import objetos.Pedido;
import objetos.itemCesta;
import persistencia.Insertar;
import persistencia.Persistencia;
import presentacion.Presentacion;

/**
 *
 * @author David
 */
public class comprar extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        DatosSesion ds = (DatosSesion) sesion.getAttribute("ds");
        List<itemCesta> icl = ds.getCesta();
        Date f = new Date();
        String FechaHoy;
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Procesado de Pedido</h2><br />");
        try{
            int iddir = Integer.parseInt(request.getParameter("direcciones"));
            FechaHoy = f.toString();
            Pedido p = new Pedido(0,ds.getUsuario(),FechaHoy,icl, iddir);
            if (Insertar.insertar(p)){
                Presentacion.exitoInsertar(out);
            }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

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
