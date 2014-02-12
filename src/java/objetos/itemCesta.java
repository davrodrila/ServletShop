package objetos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NOCTURO
 */
public class itemCesta {

    private int idjuego;
    private int idplataforma;
    private int cantidad;
    private float precio;

    private itemCesta() {
        super();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }

    public int getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(int idplataforma) {
        this.idplataforma = idplataforma;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public itemCesta(int idjuego, int idplataforma, int cantidad, float precio) {
        this.idjuego = idjuego;
        this.idplataforma = idplataforma;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public boolean comparar(itemCesta ic) {
        boolean esIgual = false;
        if ((this.idjuego == ic.getIdjuego()) && (this.idplataforma == ic.getIdplataforma())) {
            esIgual = true;
        }
        return esIgual;
    }

    public itemCesta combinar(itemCesta c2) {
        itemCesta ic = null;
            itemCesta aux = this;
            if (aux.comparar(c2)) {
                aux.setCantidad(aux.getCantidad() + c2.getCantidad());
                ic = aux;
            } else {
                ic = null;
            }
        return ic;
    }
    @Override
    public boolean equals(Object o)
    {
        itemCesta aux = (itemCesta) o;
        if (aux==null)
        {
            return false;
        } else if (this.idjuego==aux.idjuego && this.idplataforma==aux.idplataforma)
        {
            return true;
        } else {
            return false;
        }
    }
}
