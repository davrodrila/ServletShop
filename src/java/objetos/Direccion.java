/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author David
 */
public class Direccion {
    private int IDDireccion;
    private int IDUsuario;
    private String alias;
    private String dir1;
    private String dir2;
    private String localidad;
    private String provincia;
    private String CP;

    public Direccion(int IDDireccion, int IDUsuario, String alias, String dir1, String dir2, String localidad, String provincia, String CP) {
        this.IDDireccion = IDDireccion;
        this.IDUsuario = IDUsuario;
        this.alias = alias;
        this.dir1 = dir1;
        this.dir2 = dir2;
        this.localidad = localidad;
        this.provincia = provincia;
        this.CP = CP;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public int getIDDireccion() {
        return IDDireccion;
    }

    public void setIDDireccion(int IDDireccion) {
        this.IDDireccion = IDDireccion;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDir1() {
        return dir1;
    }

    public void setDir1(String dir1) {
        this.dir1 = dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getTipo()
    {
        return "Direccion";
    }
}
