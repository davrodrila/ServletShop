package altas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//TODO: Vincular archivo CSS

import conexiones.Conexiones;
import objetos.*;
import persistencia.*;
import presentacion.*;
import utiles.*;
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
public class altaGenero extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        PrintWriter out = response.getWriter();
        Genero g;
        int id;
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Alta de Generos</h2><br />");
            String nom = request.getParameter("nombre");
            String img = request.getParameter("imagen");
            g = new Genero(0,nom,img);
            if (Insertar.insertar(g)) {
                Presentacion.exitoInsertar(out);
            }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
