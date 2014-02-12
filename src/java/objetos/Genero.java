/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author NOCTURO
 */
public class Genero {
    private int IDGenero;
    private String Nombre;
    private String Imagen;

    public int getIDGenero() {
        return IDGenero;
    }

    public void setIDGenero(int IDGenero) {
        this.IDGenero = IDGenero;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Genero(int IDGenero, String Nombre, String Imagen) {
        this.IDGenero = IDGenero;
        this.Nombre = Nombre;
        this.Imagen = Imagen;
    }
    public boolean comparar(Genero g)
    {
        if (this.IDGenero==g.getIDGenero())
        {
            return true;
        }
        return false;
    }

}
