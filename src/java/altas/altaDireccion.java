package altas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import presentacion.*;
import persistencia.Insertar;
import persistencia.Persistencia;
import objetos.Direccion;
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
public class altaDireccion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Direccion d;
        int id;
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Alta de Direcciones</h2><br />");
        if (util.isNumeric(request.getParameter("idusu"))) {
            id = Integer.parseInt(request.getParameter("idusu"));

            String alias = request.getParameter("nombre");
            String dir1 = request.getParameter("dir1");
            String dir2 = request.getParameter("dir2");
            String loc = request.getParameter("loc");
            String provi = request.getParameter("provi");
            String cp = request.getParameter("cp");
            d = new Direccion(0, id, alias, dir1, dir2, loc, provi, cp);
            if (Insertar.insertar(d)) {
                Presentacion.exitoInsertar(out);
            }
            Presentacion.pieHTML(out);
        } else {
            Errores.evaluarError(out, Errores.error.ID_Invalido);
        }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    }
}
