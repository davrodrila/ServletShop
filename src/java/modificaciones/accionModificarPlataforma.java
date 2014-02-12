package modificaciones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import objetos.Plataforma;
import persistencia.*;
import conexiones.Conexiones;
import presentacion.*;
import java.sql.*;
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
public class accionModificarPlataforma extends HttpServlet {
   
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        PrintWriter out = response.getWriter();
        out.println("<h2 style='padding:30px 0 5px 5px;'>Modificacion de Plataforma</h2><br />");
        int id = Integer.parseInt(request.getParameter("id"));
        String desc = request.getParameter("desc");
        String img = request.getParameter("imagen");
        Plataforma p = new Plataforma(id,desc,img);
        if (Insertar.actualizar(p))
        {
            Presentacion.exito(out);
        } else
        {
            Errores.evaluarError(out, Errores.error.ID_Invalido);
        }
               rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
