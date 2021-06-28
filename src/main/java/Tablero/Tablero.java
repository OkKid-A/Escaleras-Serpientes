package Tablero;

import Casillas.Casilla;
import Casillas.CasillaPierde;
import Casillas.CasillaRetrocede;
import Casillas.CasillaTirar;
import Jugadores.Jugador;

import java.awt.*;

public class Tablero {

    public static final Color AQUA = new Color(10,255,153);
    private Casilla[][] casillas;
    private Jugador[] jugadores;
    private int columnas;
    private int filas;

    public Tablero(int columnas, int filas){
        this.columnas = columnas;
        this.filas = filas;
        casillas = new Casilla[filas][columnas];
        generarTablero();
    }

    public void generarTablero(){
        boolean aqua = true;
        for (int k = 0;k < casillas.length;k++){
            for (int i = 0;i < casillas[k].length;i++){
                if (aqua){
                    casillas[k][i] = new CasillaRetrocede(AQUA,25);
                    ((CasillaRetrocede)casillas[k][i]).setRetroceso(25);
                    aqua = false;
                } else {
                    casillas[k][i] = new CasillaTirar(Color.WHITE);
                    aqua = true;
                }
            }
            if( (filas%2!=0 && columnas%2!=0)||(columnas%2!=0&&filas%2==0)){
            } else {
                aqua = !aqua;
            }
        }
    }

    public void dibujarTableroSimple(){

    }

    public Casilla getCasilla(int fila,int columna){
        return casillas[fila][columna];
    }

    public void setCasilla(int fila, int columna,Casilla casilla) {
        this.casillas[fila][columna] = casilla;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }
}
