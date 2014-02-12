package objetos;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private int IDJuego;
    private String Nombre;
    private float Precio;
    private String FechaLanzamiento;
    private String Fabricante;
    private Genero Genero;
    private boolean juegoOnline;
    private String imagen;
    private String descripcion;
    private List<juegosPlataforma> plataformasDisponibles;

    public Juego(int IDJuego, String Nombre, float Precio, String FechaLanzamiento, String Fabricante, Genero Genero, boolean juegoOnline, String imagen, String descripcion, List<juegosPlataforma> plataformasDisponibles) {
        this.IDJuego = IDJuego;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.FechaLanzamiento = FechaLanzamiento;
        this.Fabricante = Fabricante;
        this.Genero = Genero;
        this.juegoOnline = juegoOnline;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.plataformasDisponibles = plataformasDisponibles;
    }
    public Juego(int IDJuego, String Nombre, float Precio, String FechaLanzamiento, String Fabricante, Genero Genero, boolean juegoOnline, String imagen, String descripcion) {
        this.IDJuego = IDJuego;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.FechaLanzamiento = FechaLanzamiento;
        this.Fabricante = Fabricante;
        this.Genero = Genero;
        this.juegoOnline = juegoOnline;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public String getFechaLanzamiento() {
        return FechaLanzamiento;
    }

    public void setFechaLanzamiento(String FechaLanzamiento) {
        this.FechaLanzamiento = FechaLanzamiento;
    }

    public Genero getGenero() {
        return Genero;
    }

    public void setGenero(Genero Genero) {
        this.Genero = Genero;
    }

    public int getIDJuego() {
        return IDJuego;
    }

    public void setIDJuego(int IDJuego) {
        this.IDJuego = IDJuego;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isJuegoOnline() {
        return juegoOnline;
    }

    public void setJuegoOnline(boolean juegoOnline) {
        this.juegoOnline = juegoOnline;
    }

    public List<juegosPlataforma> getPlataformasDisponibles() {
        return plataformasDisponibles;
    }

    public void setPlataformasDisponibles(List<juegosPlataforma> plataformasDisponibles) {
        this.plataformasDisponibles = plataformasDisponibles;
    }
}
