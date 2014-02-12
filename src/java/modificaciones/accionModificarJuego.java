package modificaciones;

import objetos.*;
import persistencia.*;
import presentacion.*;
import conexiones.Conexiones;
import java.sql.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class accionModificarJuego extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Modificacion de Juegos</h2><br />");
        int idjuego = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        float precio = Float.parseFloat(request.getParameter("precio"));
        String fechal = request.getParameter("fechalan");
        String fabricante = request.getParameter("fabricante");
        String descripcion = request.getParameter("descripcion");
        int genero = Integer.parseInt(request.getParameter("genero"));
        String rol = request.getParameter("Rol");
        boolean juegon;
        if (request.getParameter("juegoonline")=="on")
        {
            juegon=true;
        } else
        {
            juegon=false;
        }
        String imagenj = request.getParameter("imagenjuego");
        String plataformas[] = request.getParameterValues("plataforma[]");
        List<juegosPlataforma> jp = new ArrayList();

        if (plataformas!=null){
            for (int i = 0; i < plataformas.length; i++) {
                System.out.println(plataformas[i]);
                jp.add(new juegosPlataforma(idjuego,Integer.parseInt(plataformas[i])));
            }
        }
            Juego j = new Juego(idjuego,nombre,precio,fechal,fabricante,Persistencia.obtenerGenero(genero),juegon,imagenj,descripcion,jp);
            if (Insertar.actualizar(j))
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
    public String getServletInfo()
    {
        return "Short description";
    }

}
