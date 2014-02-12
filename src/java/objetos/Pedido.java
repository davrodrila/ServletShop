/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import java.util.List;

/**
 *
 * @author David
 */
public class Pedido {
    private int IDPedido;
    private Usuario usuario;
    private String FechaPedido;
    private List<itemCesta> lineasPedido;
    private int IDDireccion;

    public Pedido(int IDPedido, Usuario usuario, String FechaPedido, List<itemCesta> lineasPedido, int IDDireccion) {
        this.IDPedido = IDPedido;
        this.usuario = usuario;
        this.FechaPedido = FechaPedido;
        this.lineasPedido = lineasPedido;
        this.IDDireccion = IDDireccion;
    }

    public int getIDDireccion() {
        return IDDireccion;
    }

    public void setIDDireccion(int IDDireccion) {
        this.IDDireccion = IDDireccion;
    }

    public String getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(String FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<itemCesta> getLineasPedido() {
        return lineasPedido;
    }
    public void setLineasPedido(List<itemCesta> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public boolean equals(Object o)
    {
        if (o==null)
        {
            return false;
        }
        Pedido p =(Pedido) o;
        if (p.IDPedido==p.getIDPedido())
        {
            return true;
        } else {
            return false;
        }
    }
}
