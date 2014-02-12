package altas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//TODO: Vincular archivo CSS
import objetos.*;
import persistencia.*;
import presentacion.*;
import conexiones.Conexiones;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class altaJuego extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String nombre = request.getParameter("nombre");
        String fechalan = request.getParameter("fechalan");
        try{
            float precio = Float.parseFloat(request.getParameter("precio"));
            String fabricante = request.getParameter("fabricante");
            int genero = Integer.parseInt(request.getParameter("genero"));
            boolean juegon;
            if (request.getParameter("juegoonline")=="on")
            {
                juegon=true;
            } else
            {
                juegon=false;
            }
            String img = request.getParameter("imagenjuego");
            String desc = request.getParameter("descripcion");
            PrintWriter out = response.getWriter();
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
            rd.include(request, response);
            out.println("<h2 style='padding:30px 0 5px 5px;'>Alta de Juegos</h2><br />");
            Juego j = new Juego(0,nombre,precio,fechalan,fabricante,Persistencia.obtenerGenero(genero),juegon,img,desc);
            int id;
            Presentacion.cabeceraHTML(out, "Inserci&oacute;n de Juego");
                if (Insertar.insertar(j)) {
                    Presentacion.exitoInsertar(out);
                }
                Presentacion.pieHTML(out);
           rd = getServletContext().getRequestDispatcher("/pie.jsp");
           rd.include(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
