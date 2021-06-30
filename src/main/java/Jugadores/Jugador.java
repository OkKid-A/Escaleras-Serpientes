package Jugadores;

import java.io.Serializable;

public class Jugador implements Serializable {

    private String nombre;
    private int victorias;
    private int derrotas;

    public Jugador(String nombre){
        this.nombre = nombre;
        victorias = 0;
        derrotas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
