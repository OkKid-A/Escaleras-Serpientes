package Tablero;

import Jugadores.Jugador;

public class Ficha {

    private Jugador jugador;
    private boolean pierdeTurno;
    private boolean ganaTurno;

    public Ficha(Jugador jugador){
        this.jugador = jugador;
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
}
