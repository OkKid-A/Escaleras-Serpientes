package Tablero;

import Jugadores.Jugador;

import javax.swing.*;
import java.awt.*;

public class Ficha extends JLabel {

    private Jugador jugador;
    private boolean pierdeTurno;
    private boolean ganaTurno;
    private boolean sentido;
    private int posicion;
    private Color color;
    private int columna;
    private int filas;
    private boolean gano;

    public Ficha(Jugador jugador, int posicion,Color color){
        super();
        this.posicion = posicion;
        this.color = color;
        this.jugador = jugador;
        columna = 0;
        filas = 0;
        sentido = true;
        gano = false;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean isPierdeTurno() {
        return pierdeTurno;
    }

    public boolean isGanaTurno() {
        return ganaTurno;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setPierdeTurno(boolean pierdeTurno) {
        this.pierdeTurno = pierdeTurno;
    }

    public void setGanaTurno(boolean ganaTurno) {
        this.ganaTurno = ganaTurno;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isSentido() {
        return sentido;
    }
}
