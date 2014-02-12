package altas;

import conexiones.Conexiones;
import java.sql.*;
import presentacion.Errores;
import persistencia.Insertar;
import persistencia.Persistencia;
import presentacion.Presentacion;
import objetos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import presentacion.Errores.error;

public class altaUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Presentacion.cabeceraHTML(out, "Inserci&oacute;n de usuarios");
        String nombre = request.getParameter("nombre");
        String log = request.getParameter("Login");
        String ape = request.getParameter("apellidos");
        String dni = request.getParameter("DNI");
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("passc");
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Alta de Usuarios</h2><br />");
        if (!Persistencia.comprobarLogin(log)) {
            if (pass.equals(pass2)) {
                Usuario u = new Usuario(0, log, nombre, ape, dni, mail, pass,"usuario");
                if (Insertar.insertar(u)) {
                    Presentacion.exitoInsertar(out);
                }
            } else {
                Errores.evaluarError(out, error.contraseñas_no_coinciden);
            }
        } else {
            Errores.evaluarError(out, error.login_repetido);
        }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    }
}

//TODO: Enlazar CSS.

