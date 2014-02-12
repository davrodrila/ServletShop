package modificaciones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import conexiones.Conexiones;
import java.sql.*;
import persistencia.*;
import objetos.*;
import presentacion.*;
import utiles.*;
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
public class accionModificarGenero extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
            rd.include(request, response);
            PrintWriter out = response.getWriter();
            out.println("<h2 style='padding:30px 0 5px 5px;'>Alta de Generos</h2><br />");
        if (util.isNumeric(request.getParameter("id"))){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String imagen = request.getParameter("imagen");
            Genero g = new Genero(id,nombre,imagen);
            out.println(id);
            if (Insertar.actualizar(g))
            {
                Presentacion.exito(out);
            } else
            {
                Errores.evaluarError(out, Errores.error.ID_Invalido);
            }
              rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
