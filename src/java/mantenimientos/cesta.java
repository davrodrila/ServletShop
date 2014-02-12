package mantenimientos;

import utiles.*;
import objetos.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class cesta extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Cesta</h2><br />");
        String accion = request.getParameter("accion");
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            int idp = Integer.parseInt(request.getParameter("plataforma"));
            float precio = Float.parseFloat(request.getParameter("precio"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                itemCesta ic = new itemCesta(id,idp,cantidad,precio);
                ServletContext contexto=getServletContext();
                contexto.setAttribute("item",ic);
                if (accion.equalsIgnoreCase("add"))
                {
                    rd = contexto.getRequestDispatcher("/agregarCesta");
                } else if (accion.equalsIgnoreCase("del"))
                {
                    rd = contexto.getRequestDispatcher("/borrarCesta");
                }
                rd.forward(request,response);
        }catch (NumberFormatException e)
        {
            out.println("Introduce una cantidad válida");
        }
        rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
