package Tablero;

import Jugadores.Jugador;

import javax.swing.*;
import java.awt.*;

public class Ficha extends JLabel {

    private final Dimension casilla = new Dimension(50,50);
    private final Dimension punto = new Dimension(15,15);
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
        this.setPreferredSize(punto);
        this.setMinimumSize(punto);
        this.setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D antiAlias = (Graphics2D) g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int anchoSobrante = punto.height * 2/3;
        int izquierda = (int) (casilla.getWidth() * 1/3 - punto.width/2 - anchoSobrante * 1/4);
        int centro = (int) (casilla.getWidth() * 2/3 - punto.width/2 - anchoSobrante * 1/2);
        int derecha = (int) (casilla.getWidth() * 3/3 - punto.width/2 - anchoSobrante * 3/4);
        int arriba = (int) (casilla.getHeight() * (1/3) - punto.height/2 - anchoSobrante * 1/4);
        int medio = (int) (casilla.getHeight() * 2/3 - punto.height/2 - anchoSobrante * 1/2);
        int abajo = (int) (casilla.getHeight() * 3/3 - punto.height/2 - anchoSobrante * 3/4);
        g.setColor(color);
        switch (posicion){
            case 0:
                break;
            case 1:
                g.fillOval(2, 2, anchoSobrante, anchoSobrante);
                break;
            case 2:
                g.fillOval(2, 20, anchoSobrante, anchoSobrante);
                break;
            case 3:
                g.fillOval(derecha, arriba, anchoSobrante, anchoSobrante);
                break;
            case 4:
                g.fillOval(derecha, abajo, anchoSobrante, anchoSobrante);
                break;
            case 5:
                g.fillOval(izquierda, medio, anchoSobrante, anchoSobrante);
                break;
            case 6:
                g.fillOval(derecha, medio, anchoSobrante, anchoSobrante);
                break;
        }
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

    public Color getColor() {
        return color;
    }
}
