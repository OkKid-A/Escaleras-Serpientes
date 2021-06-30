package Tablero;

import Casillas.Casilla;
import InterfazGrafica.VentanaMenuPrincipal;
import ManejoDeArchivos.Escritor;

import javax.swing.*;
import java.awt.*;

public class Core {

    private Tablero tablero;
    private Dado dado;
    private int numTurno;
    private String ruta;

    public Core(Tablero tablero, Dado dado, String ruta) {
        this.tablero = tablero;
        this.dado = dado;
        this.ruta = ruta;
        numTurno = 0;
    }

    public void ejecutarTurno(int tiroDado, JPanel panel,JFrame frame) {
        Ficha enTurno = tablero.getFicha((numTurno%6));
        JOptionPane.showMessageDialog(panel,"Has obtenido un " + tiroDado+"!!!");
        if (!enTurno.isPierdeTurno()) {
            moverFicha(tiroDado, enTurno,frame);
            numTurno++;
            tablero.getCasilla(enTurno.getFilas(),enTurno.getColumna()).aplicarCondiciones(this,enTurno,panel,frame);
        }  else {
            enTurno.setPierdeTurno(false);
        }
        JOptionPane.showMessageDialog(panel,"Es el turno de " + tablero.getFicha((numTurno+1)%6).getJugador().getNombre());
    }

    public Dimension moverFicha(int movimiento, Ficha ficha,JFrame frame) {
        tablero.getCasilla(ficha.getFilas(), ficha.getColumna()).eliminarFicha(ficha);
        if (ficha.isSentido()&&(tablero.getCasillas()[ficha.getFilas()].length>(ficha.getColumna()+movimiento))){
            Casilla fin = tablero.getCasilla(ficha.getFilas(),ficha.getColumna()+movimiento);
            fin.agregarFicha(ficha);
            ficha.setColumna(ficha.getColumna()+movimiento);
        } else if (!ficha.isSentido()&&(0<(ficha.getColumna()-movimiento))){
            Casilla fin = tablero.getCasilla(ficha.getFilas(),ficha.getColumna()-movimiento);
            fin.agregarFicha(ficha);
            ficha.setColumna(ficha.getColumna()-movimiento);
        } else if ((ficha.getFilas()-1)>=0&&ficha.isSentido()){
            Casilla fin = tablero.getCasilla(ficha.getFilas()-1,tablero.getCasillas()[ficha.getFilas()].length-1-((ficha.getColumna()+movimiento)-(tablero.getCasillas()[ficha.getFilas()].length-1)));
            fin.agregarFicha(ficha);
            ficha.setFilas(ficha.getFilas()-1);
            ficha.setColumna(tablero.getCasillas()[ficha.getFilas()].length-1-((ficha.getColumna()+movimiento)-(tablero.getCasillas()[ficha.getFilas()].length-1)));
            ficha.setSentido(false);
        } else if ((ficha.getFilas()-1)>=0&&!ficha.isSentido()){
            Casilla fin = tablero.getCasilla(ficha.getFilas()-1,1-(ficha.getColumna()-movimiento));
            fin.agregarFicha(ficha);
            ficha.setFilas(ficha.getFilas()-1);
            ficha.setColumna(1-(ficha.getColumna()-movimiento));
            ficha.setSentido(true);
        }else if ((ficha.getFilas()==0)&&((ficha.getColumna()+movimiento)>tablero.getColumnas()||(ficha.getColumna()-movimiento)<0)){
            JOptionPane.showMessageDialog(frame,"!!!!!Gano " + ficha.getJugador().getNombre()+ "!!!!!");
            ficha.getJugador().setVictorias(ficha.getJugador().getVictorias()+1);
            int temp = numTurno;
            for (int k =0;k < 5;k++){
                temp++;
                Ficha tempo = tablero.getFicha(temp%6);
                tempo.getJugador().setDerrotas(tempo.getJugador().getDerrotas()+1);
            }
            frame.dispose();
            Escritor escritor = new Escritor(ruta);
            escritor.registrarRecords(tablero.getFichas());
            VentanaMenuPrincipal menu = new VentanaMenuPrincipal();
        }
        return new Dimension();
    }

    public Dado getDado() {
        return dado;
    }
}
