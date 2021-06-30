package Tablero;

import Casillas.*;
import Jugadores.Jugador;

import java.awt.*;
import java.util.ArrayList;

public class Tablero {

    public static final Color AQUA = new Color(10,255,153);
    private Casilla[][] casillas;
    private ArrayList<Ficha> fichas;
    private int columnas;
    private int filas;

    public Tablero(int columnas, int filas){
        this.columnas = columnas;
        this.filas = filas;
        casillas = new Casilla[filas][columnas];
        crearFichas();
        generarTablero();
    }

    public void generarTablero(){
        boolean aqua = true;
        for (int k = 0;k < filas;k++){
            for (int i = 0;i < columnas;i++){
                if (aqua){
                    casillas[k][i] = new Casilla(AQUA);
                    aqua = false;
                } else {
                    casillas[k][i] = new Casilla(Color.WHITE);
                    aqua = true;
                }
            }
            if( (filas%2!=0 && columnas%2!=0)||(columnas%2!=0&&filas%2==0)){
            } else {
                aqua = !aqua;
            }
        }
    }

    public void crearFichas(){
        fichas = new ArrayList<Ficha>();
        for (int k =0;k < 6;k++){
            if (k == 0){
                fichas.add(new Ficha(filas-1,new Jugador("Juan"),1,Color.BLACK));
            } else if (k==1){
                fichas.add(new Ficha(filas-1,new Jugador("Mmm"),2,Color.green));
            } else if (k==2){
                fichas.add(new Ficha(filas-1,new Jugador("Miles"),3,Color.GRAY));
            } else if (k==3){
                fichas.add(new Ficha(filas-1,new Jugador("TwT"),4,new Color(120,81,64)));
            }else if (k==4){
                fichas.add(new Ficha(filas-1,new Jugador("QwQ"),5,Color.orange));
            } else if (k==5){
                fichas.add(new Ficha(filas-1,new Jugador("(*.*)b"),6,Color.PINK));
            }
        }
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

    public Ficha getFicha(int index){
        return fichas.get(index);
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
