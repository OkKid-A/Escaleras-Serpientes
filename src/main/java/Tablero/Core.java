package Tablero;

import Casillas.Casilla;

import java.awt.*;

public class Core {

    private Tablero tablero;
    private Dado dado;
    private int numTurno;

    public Core(Tablero tablero, Dado dado) {
        this.tablero = tablero;
        this.dado = dado;
        numTurno = 0;
    }

    public void ejecutarTurno(int tiroDado) {
        Ficha enTurno = tablero.getFicha((numTurno%6));
        if (enTurno.isPierdeTurno()) {
            moverFicha(tiroDado, enTurno);
            numTurno++;
            tablero.getCasilla(enTurno.getFilas(),enTurno.getColumna()).aplicarCondiciones(this,enTurno);
        }  else {
            enTurno.setPierdeTurno(false);
        }
    }

    public Dimension moverFicha(int movimiento, Ficha ficha) {
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
        }
        return new Dimension();
    }

    public Dado getDado() {
        return dado;
    }
}
