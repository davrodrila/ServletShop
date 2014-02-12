/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;
import java.util.*;
/**
 *
 * @author NOCTURO
 */
public class DatosSesion {
    private Usuario Usuario;
    private List<itemCesta> cesta;

    public DatosSesion(Usuario Usuario, List<itemCesta> cesta) {
        this.Usuario = Usuario;
        this.cesta = cesta;
    }

    public Usuario getUsuario() {
        return Usuario;
    }
    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }


    public List<itemCesta> getCesta() {
        return cesta;
    }

    public void setCesta(List<itemCesta> cesta) {
        this.cesta = cesta;
    }

}
