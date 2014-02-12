package presentacion;

import objetos.Usuario;
import objetos.Direccion;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import objetos.*;

public class Presentacion {

    public static void botonCrear(PrintWriter out, String url) {
        out.println("<p><a href='" + url + "' ><h1>Nuevo</h1></a></p>");
    }
    public static void cabeceraHTML(PrintWriter out, String titulo) {
        out.println("<html><head><title>" + titulo + "</title></head>");
    }
    public static void botonVolver(PrintWriter out) {
        out.println("<a href='javascript:history.go(-2)'>Volver</a>");
    }
    public static void pieHTML(PrintWriter out) {
        out.println("</body></html>");
    }
    public static void exitoInsertar(PrintWriter out)
    {
        out.println("<p>Datos insertados con exito</p>");
        botonVolver(out);
    }
    public static void exito(PrintWriter out) {
        out.println("<p>Datos actualizados con &eacute;xito</p>");
        botonVolver(out);
    }
        
    public static void exitoBorrar(PrintWriter out) {
        out.println("<p>Datos borrados con &eacute;xito</p>");
        botonVolver(out);
    }
}
