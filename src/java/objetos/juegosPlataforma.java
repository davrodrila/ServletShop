/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author NOCTURO
 */
public class juegosPlataforma {
    private int IDJuego;
    private int IDPlataforma;

    public juegosPlataforma(int IDJuego, int IDPlataforma) {
        this.IDJuego = IDJuego;
        this.IDPlataforma = IDPlataforma;
    }

    public int getIDJuego() {
        return IDJuego;
    }

    public void setIDJuego(int IDJuego) {
        this.IDJuego = IDJuego;
    }

    public int getIDPlataforma() {
        return IDPlataforma;
    }

    public void setIDPlataforma(int IDPlataforma) {
        this.IDPlataforma = IDPlataforma;
    }

    public boolean equals(Object o)
    {
        if (o==null)
        {
            return false;
        }
         juegosPlataforma aux = (juegosPlataforma) o;
         if (this.IDJuego==aux.IDJuego && this.IDPlataforma==aux.IDPlataforma){
             return true;
         }
         return false;
    }
    
}
