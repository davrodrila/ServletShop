package altas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//TODO: Vincular archivo CSS
import conexiones.Conexiones;
import java.sql.*;
import persistencia.*;
import objetos.*;
import presentacion.*;
import utiles.util;
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
public class altaPlataforma extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Plataforma p;
        int id = 0;
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Alta de Plataformas</h2><br />");
        String nombre = request.getParameter("desc");
        String imagen = request.getParameter("imagen");
        p = new Plataforma(id, nombre, imagen);
        if (Insertar.insertar(p)) {
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
