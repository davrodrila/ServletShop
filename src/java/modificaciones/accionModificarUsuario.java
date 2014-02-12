package modificaciones;

import objetos.Usuario;
import utiles.util;
import conexiones.Conexiones;
import presentacion.Errores;
import presentacion.Presentacion;
import persistencia.Persistencia;
import persistencia.Insertar;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class accionModificarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/cabecera.jsp");
        rd.include(request, response);
        out.println("<h2 style='padding:30px 0 5px 5px;'>Modificacion de Usuarios</h2><br />");
        if (util.isNumeric(request.getParameter("id")))
        {
            boolean loginBueno=false;
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String login = request.getParameter("login");
            String loginold = request.getParameter("loginold");
            String ape = request.getParameter("ape");
            String dni = request.getParameter("DNI");
            String email = request.getParameter("mail");
            String passold = request.getParameter("passold");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");
            System.out.println(passold);
            System.out.println(pass);
            System.out.println(pass2);
            String rol = request.getParameter("Rol");
            Usuario u = new Usuario(id,login,nombre,ape,dni,email,passold,rol);
            if (!passold.isEmpty() && !pass.isEmpty())
            {
                if (Persistencia.comprobarPass(u))
                {
                    if (pass.equals(pass2))
                    {
                        u.setPass(pass);
                        loginBueno=true;
                    } else
                    {
                        Errores.evaluarError(out, Errores.error.contraseñas_no_coinciden);
                    }
                } else
                {
                    Errores.evaluarError(out, Errores.error.contraseña_incorrecta);
                    loginBueno=false;
                }
            } else
            {
                loginBueno=true;
            }
            if (!login.equals(loginold))
            {
                out.println("login no es igual al login viejo");
                if (!Persistencia.comprobarLogin(login) && loginBueno)
                {
                        loginBueno=true;
                } else
                {
                    Errores.evaluarError(out, Errores.error.login_repetido);
                    loginBueno=false;
                }
            }
            if (loginBueno)
            {
                if (Insertar.actualizar(u))
                {
                    Presentacion.exito(out);
                }
            }
        } else 
        {
            Errores.evaluarError(out, Errores.error.ID_Invalido);
        }
       rd = getServletContext().getRequestDispatcher("/pie.jsp");
       rd.include(request, response);
    }
}
