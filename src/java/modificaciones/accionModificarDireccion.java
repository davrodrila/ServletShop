package modificaciones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import objetos.Direccion;
import persistencia.Insertar;
import persistencia.Persistencia;
import presentacion.*;
import java.sql.*;
import conexiones.Conexiones;
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
public class accionModificarDireccion extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int idu = Integer.parseInt(request.getParameter("idu"));
        int idd = Integer.parseInt(request.getParameter("idd"));
        String alias = request.getParameter("nombre");
        String dir1 = request.getParameter("dir1");
        String dir2 = request.getParameter("dir2");
        String loc = request.getParameter("loc");
        String provi = request.getParameter("provi");
        String cp = request.getParameter("cp");
        Direccion d = new Direccion(idd,idu,alias,dir1,dir2,loc,provi,cp);
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Modificación de Direcciones</h2><br />");
        if (Insertar.actualizar(d))
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

