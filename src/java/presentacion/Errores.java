/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;
import java.io.PrintWriter;
/**
 *
 * @author David
 */
public class Errores {
    public static enum error{
      ID_Invalido,
      No_Direcciones,
      Usuario_no_encontrado,
      login_repetido,
      contraseñas_no_coinciden,
      contraseña_incorrecta,
      direccion_no_encontrada,
      error_borrando
    };

    public static void evaluarError(PrintWriter out, error e)
    {
        if (error.ID_Invalido.equals(e))
        {
            out.println("Error. Uno de los IDs proporcionados no son validos.");
            Presentacion.botonVolver(out);
        } else if (error.Usuario_no_encontrado.equals(e))
        {
            out.println("Error. Usuario no encontrado en la base de datos.");
            Presentacion.botonVolver(out);
        } else if (error.No_Direcciones.equals(e))
        {
            out.println("No hay direcciones para mostrar.");
        } else if (error.login_repetido.equals(e))
        {
            out.println("Error. El login escrito ya existe.");
            Presentacion.botonVolver(out);
        } else if (error.contraseña_incorrecta.equals(e))
        {
            out.println("Error. Contraseña incorrecta.");
            Presentacion.botonVolver(out);
        } else if (error.contraseñas_no_coinciden.equals(e))
        {
            out.println("Error. Las contraseñas no coinciden.");
            Presentacion.botonVolver(out);
        } else if (error.direccion_no_encontrada.equals(e))
        {
            out.println("Error. Direcci&oacute; incorrecta.");
            Presentacion.botonVolver(out);
        } else if (error.error_borrando.equals(e))
        {
            out.println("Error en el borrado del dato seleccionado.");
            Presentacion.botonVolver(out);
        }
    }
}
