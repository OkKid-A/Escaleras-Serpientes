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
}
