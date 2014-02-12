/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author NOCTURO
 */
public class Plataforma {
    private int IDPlataforma;
    private String Descripcion;
    private String Imagen;

    public Plataforma(int IDPlataforma, String Descripcion, String Imagen) {
        this.IDPlataforma = IDPlataforma;
        this.Descripcion = Descripcion;
        this.Imagen = Imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIDPlataforma() {
        return IDPlataforma;
    }

    public void setIDPlataforma(int IDPlataforma) {
        this.IDPlataforma = IDPlataforma;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

}
